package com.ansuman.demo.employee.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ansuman.demo.employee.entites.User;
import com.ansuman.demo.employee.repos.UserRepository;

@RestController
public class UserController {
	private static List<User> users=new ArrayList<>();  

	@Autowired
	private UserRepository userRepository;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(value="/user")
	public String signup(@RequestBody User request) {
		userRepository.save(request);
		return "created";
	}
	
	@GetMapping(path="/user/{id}")
	public User retriveUser(@PathVariable Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}
	
}
