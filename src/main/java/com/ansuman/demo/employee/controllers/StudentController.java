package com.ansuman.demo.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	@PostMapping("/login/{mobileNumber}")
	public String verification(@PathVariable String mobileNumber) {
		String output = "";
		Student data = studentRepository.findByMobileNumber(mobileNumber);
		if(data != null) {
			output = data.getPassword();
		}else {
			output = "Mobile Number is not Register";
		}
		return output;
	}


}
