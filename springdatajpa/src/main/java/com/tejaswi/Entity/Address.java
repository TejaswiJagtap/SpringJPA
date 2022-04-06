package com.tejaswi.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address
{
	private String house_no;
	private String city;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String house_no, String city) {
		super();
		this.house_no = house_no;
		this.city = city;
	}
	
	
}
