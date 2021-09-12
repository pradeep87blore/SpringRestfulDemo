package com.pradeep.restfulservices.restfulservicesdemo.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// Create a new user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		
		User savedUser = uds.save(user);

		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	// Delete a specific user
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id)
	{
		uds.deleteUser(id);
		
		return ResponseEntity.noContent().build();
	}
}
