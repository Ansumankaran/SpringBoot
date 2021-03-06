package com.ansuman.demo.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansuman.demo.employee.entites.Student;
import com.ansuman.demo.employee.repos.StudentRepository;



@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@PostMapping
	public String saveuser(@RequestBody Student request) {
		Student createdUser = studentRepository.save(request);
		return "Sucess";
	}
	@CrossOrigin(origins = "http://localhost:8600")
	@PostMapping("/login/{mobileNumber}/{password}")
	public String verification(@PathVariable String mobileNumber,@PathVariable String password) {
		String output = "";
		try {
		
		System.out.println(mobileNumber+" pass "+password);
		Student data = studentRepository.findByMobileNumberAndPassword(mobileNumber, password);
		if(data != null) {
			output = "success";
		}else {
			output = "Mobile Number is not Register";
		}
		
		}catch(Exception e)
		{
			 output=e.getMessage();
			return output;
		}
		return output;
	}
	@CrossOrigin(origins = "http://localhost:8600")
	@PostMapping("/login/{mobileNumber}")
	public String verification1(@PathVariable String mobileNumber) {
		String output = "";
		try {
		Student data = studentRepository.findByMobileNumber(mobileNumber);
		if(data != null) {
			output = data.getPassword();
		}else {
			output = "Mobile Number is not Register";
		}
		
		}catch(Exception e)
		{
			 output=e.getMessage();
			return output;
		}
		return output;
	}
	@CrossOrigin(origins = "http://localhost:8600")
	@PostMapping("/valid")
	public String validation(@RequestBody Student request) {
		String output = "";
		try {
		Student data = studentRepository.findByMobileNumber(request.getMobileNumber());
		if(data != null) {
			output = data.getPassword();
		}else {
			output = "Mobile Number is not Register";
		}
		
		}catch(Exception e) {
			output = e.getMessage();
			return output;
		}
		return output;
	}
	@DeleteMapping("/delete")
	public void deleteUser() {
		studentRepository.deleteAll();
	}



}
