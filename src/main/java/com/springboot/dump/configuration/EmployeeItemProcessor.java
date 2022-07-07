package com.springboot.dump.configuration;

import org.springframework.batch.item.ItemProcessor;

import com.springboot.dump.model.Employee;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {


	@Override
	public Employee process(Employee item) throws Exception {
		
		return item;
	}

}
