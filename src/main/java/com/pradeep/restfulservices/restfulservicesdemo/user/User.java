package com.pradeep.restfulservices.restfulservicesdemo.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {


	private Integer id;
	
	@Size(min=3, message="Name should have at least 3 characters") // This validates that the size should be at least 3
	private String name;
	
	@Past (message="Date of birth cannot be in the future")// This validates that the date should always be in the past
	private Date dob;
	
		public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

		@Override
	public String toString() {
		return String.format("User Name: %s, User Id: %d, User Date of Birth: %s", this.name, this.id, this.dob.toString());
	}

		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

		
}
