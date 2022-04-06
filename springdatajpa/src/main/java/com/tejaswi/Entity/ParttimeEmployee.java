package com.tejaswi.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tejaswi_parttime_employee")
public class ParttimeEmployee extends Employee
{
	private String hourlywage;

	public ParttimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParttimeEmployee(String empname, String hourlywage) {
		super(empname);
		this.hourlywage = hourlywage;
	}
	

	
}
