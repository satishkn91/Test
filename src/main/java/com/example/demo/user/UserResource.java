package com.example.demo.user;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	public UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		List<User>  user = service.findAll();
		
		return service.findAll();
	}

	@GetMapping(path = "/user/{id}")
	public User findUser(@PathVariable int id) {
		
		User user = service.findById(id);
		if(user==null) {
			throw new UserNotFoundException("id -" +id);
		}
		return user;
	}
	
	@DeleteMapping(path = "/user/{id}")
	public void deleteUser(@PathVariable int id) {
		
		  service.deleteUser(id);
			/*
			 * if(user==null) { throw new UserNotFoundException("id -" +id); }
			 */
		
		
	}

	@PostMapping(path = "/user")
	public void createUser(@Valid @RequestBody User user) {
		 service.save(user);
		
	}

}
