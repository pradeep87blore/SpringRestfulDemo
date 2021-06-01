package com.pradeep.restfulservices.restfulservicesdemo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService uds;
	
	@GetMapping(path = "/users")
	// Get all users
	public List<User> findAllUsers()
	{
		return uds.findAll();
		
	}
	
	// Find specific user
	@GetMapping(path = "/users/{id}")
	public User findUser(@PathVariable Integer id)
	{
		return uds.findUser(id);
	}
}
