package com.springboot.batch.configuration;

import org.springframework.batch.item.ItemProcessor;

import com.springboot.batch.model.Employee;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {


	@Override
	public Employee process(Employee item) throws Exception {
		
		return item;
	}

}
