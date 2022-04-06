package com.tejaswi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tejaswi_passport")
public class Passport
{
	@Id
	@GeneratedValue
	private int id;
	private String passport_no;
	
	@OneToOne(mappedBy = "passport")
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passport(int id, String passport_no) {
		super();
		this.id = id;
		this.passport_no = passport_no;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", passport_no=" + passport_no + "]";
	}
	public Passport(String passport_no) {
		super();
		this.passport_no = passport_no;
	}
	
}
