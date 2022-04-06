package com.tejaswi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="tejaswi_employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee
{
	@Id
	@GeneratedValue
	private int id;
	
	private String empname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Employee(int id, String empname) {
		super();
		this.id = id;
		this.empname = empname;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + "]";
	}
	public Employee(String empname) {
		super();
		this.empname = empname;
	}
	
	
}
