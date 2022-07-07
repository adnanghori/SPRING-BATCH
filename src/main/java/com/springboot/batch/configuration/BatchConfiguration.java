package com.springboot.batch.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.springboot.batch.model.Employee;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {	
		@Autowired
		private DataSource dataSource;
		@Autowired
		private JobBuilderFactory jobBuilderFactory;
		@Autowired
		private StepBuilderFactory stepBuilderFactory;
		
		@Bean
		public FlatFileItemReader<Employee> itemReader(){
			FlatFileItemReader<Employee> itemReader = new FlatFileItemReader<>();
			itemReader.setResource(new ClassPathResource("employees.csv"));
			itemReader.setLineMapper(getLineMapper());
			itemReader.setLinesToSkip(0);
			return itemReader;
		}

		private LineMapper<Employee> getLineMapper(){
			DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
			delimitedLineTokenizer.setNames(new String[] {"EMPLOYEE_ID","FIRST_NAME","LAST_NAME","EMAIL","PHONE_NUMBER","HIRE_DATE","JOB_ID","SALARY","COMMISSION_PCT","MANAGER_ID","DEPARTMENT_ID"});
			delimitedLineTokenizer.setIncludedFields(new int[] {0,1,2,3,4,5,6,7,8,9,10});
			BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
			fieldSetMapper.setTargetType(Employee.class);
			DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<Employee>();
			defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
			defaultLineMapper.setFieldSetMapper(fieldSetMapper);
			return defaultLineMapper;
		}
		@Bean
		public EmployeeItemProcessor employeeItemProcessor() {
			return new EmployeeItemProcessor();
		}
		public JdbcBatchItemWriter<Employee> batchItemWriter(){
			JdbcBatchItemWriter<Employee> jdbcBatchItemWriter = new JdbcBatchItemWriter<>();
			jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
			jdbcBatchItemWriter.setSql("insert into employee(EMPLOYEE_ID, FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values(:EMPLOYEE_ID,:FIRST_NAME,:LAST_NAME,:EMAIL,:PHONE_NUMBER,:HIRE_DATE,:JOB_ID,:SALARY,:COMMISSION_PCT,:MANAGER_ID,:DEPARTMENT_ID)");
			jdbcBatchItemWriter.setDataSource(this.dataSource);
			return jdbcBatchItemWriter;
		}
		public Job importEmployeeJob() {
			Job job = this.jobBuilderFactory.get("EMPLOYEE-IMPORT-JOB").incrementer(new RunIdIncrementer()).flow(step()).end().build();
			return job;
		}
		@Bean
		public Step step() {
			TaskletStep step = this.stepBuilderFactory.get("step1").<Employee,Employee>chunk(10).reader(itemReader()).processor(employeeItemProcessor()).writer(batchItemWriter()).build();
			return step;
		}
		 @Bean
         public TaskExecutor taskExecutor() {
             SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
             taskExecutor.setConcurrencyLimit(4);
             return taskExecutor;
         }
}
