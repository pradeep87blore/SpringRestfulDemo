package com.pradeep.restfulservices.restfulservicesdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController // Indicates that this class acts as a controller
public class HelloWorldController {

	// This function shall handle the GET request to the /hello-world path
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world") // This is a generic way
	/**
	 * This function returns a simple string message on being invoked
	 * The @GetMapping annotation maps the specified path to this controller function
	 * @return
	 */
	@GetMapping( path="/hello-world") // Instead, we can use a specific GetMapping that maps a GET call to this method
	public String helloWorld()
	{
		return "Hello World, I am a Spring boot app";
	}
	
	/**
	 * This function creates a bean,inserts the output string into it and returns the same
	 * The bean (HelloWorldBean here) has it's toString overridden to return the message as expected
	 * @return
	 */
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
	
	/**
	 * This function accepts a "name" field in the request path and uses that in the response
	 * 
	 * The @PathVariable annotation is needed to map the variable to the value in the request path
	 * Example:
	 * http://localhost:8080/hello-world/path-variable/Pradeep
	 * Output: {"message":"Hello World from Pradeep"}
	 * @param name
	 * @return
	 */
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello World from %s", name));
	}
}
