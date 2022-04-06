package com.tejaswi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tejaswi.Entity.FulltimeEmployee;
import com.tejaswi.Entity.ParttimeEmployee;
import com.tejaswi.Repository.CourseRepositoryEntity;
import com.tejaswi.Repository.EmployeeRepository;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner
{
	@Autowired
	CourseRepositoryEntity courseRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//courseRepository.add_reviews();
		//courseRepository.update_reviews();
		//employeeRepository.findAllEmployee();
		//employeeRepository.findAllParttime_Employee();
		//employeeRepository.insertEmployee(new ParttimeEmployee("shital","60"));
		//employeeRepository.insertEmployee(new FulltimeEmployee("rajni","12000"));
	}

}
