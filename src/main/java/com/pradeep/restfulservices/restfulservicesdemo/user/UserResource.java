package com.pradeep.restfulservices.restfulservicesdemo.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; // Import all static methods in this class

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	public EntityModel<User> findUser(@PathVariable Integer id)
	{
		// The below EntityModel allows us to provide the link for "findAllUsers" as part of the response.
		EntityModel<User> model = EntityModel.of(uds.findUser(id)); // Find users as usual
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).findAllUsers()); // Here is the part establishing the dynamic link
		model.add(linkToUsers.withRel("all-users")); // Add the link to the "findAllUsers" request path to the response
		
		WebMvcLinkBuilder linkToDeleteUser = linkTo(methodOn(this.getClass()).deleteUser(id)); // Here is the part establishing the dynamic link
		model.add(linkToDeleteUser.withRel("delete-user")); // Add the link to the "findAllUsers" request path to the response
		return model; // Return the enriched response
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
