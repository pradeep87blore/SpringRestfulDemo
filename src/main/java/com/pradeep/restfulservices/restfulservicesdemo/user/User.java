package com.pradeep.restfulservices.restfulservicesdemo.user;

import java.util.Date;

public class User {

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

		private Integer id;
		
		private String name;
		
		private Date dob;
		
}
