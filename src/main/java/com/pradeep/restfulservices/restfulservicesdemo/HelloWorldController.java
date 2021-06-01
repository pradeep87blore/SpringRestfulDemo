package com.pradeep.restfulservices.restfulservicesdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {

	// This function shall handle the GET request to the /hello-world path
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world") // This is a generic way
	@GetMapping( path="/hello-world") // Instead, we can use a specific GetMapping that maps a GET call to this method
	public String helloWorld()
	{
		return "Hello World, I am a Spring boot app";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
}
