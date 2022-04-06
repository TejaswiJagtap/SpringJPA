package com.tejaswi.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tejaswi_fulltime_employee")
public class FulltimeEmployee extends Employee
{
	private String salary;

	public FulltimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FulltimeEmployee(String empname, String salary) {
		super(empname);
		this.salary = salary;
	}
	
	
}
