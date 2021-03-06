package com.pradeep.restfulservices.restfulservicesdemo.helloworld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message)
	{
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("Hello World Bean [message = %s]", message);
	}
	
	
}
