package com.ansuman.demo.employee.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ansuman.demo.employee.entites.Employee;
import com.ansuman.demo.employee.repos.EmployeeRepository;
import com.jayway.jsonpath.internal.JsonContext;

import net.minidev.json.JSONObject;

@RestController
public class EmployeeController {
	

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/login/{fname}")
	public String start(@PathVariable String fname) {
		String output;
		System.out.println(fname);
		output =fname;
		return output;

	}
	@GetMapping("/get")
	public String give() {
		return "Sucess";
	}
	
	
	
	
//	
	@PostMapping(value="/add")
	    public  Map<String, Object>  search(@RequestBody Employee request) {
		    Employee emp =employeeRepository.findByFirstName(request.getFirstName());
		    Map<String, Object> rtn = new LinkedHashMap<>();
		    if(emp == null){
		     //handler your own exception here
			    rtn.put("status", 0);
			    rtn.put("description", "Username is not there");	
		    }else { 
		    	if (request.getLastName().equals(emp.getLastName())) {
		    		rtn.put("status", 1);
			    	rtn.put("description", "Sucess");
		    		
		    	}else {
		    		rtn.put("status", 0);
		    		rtn.put("description", "Password Does not match");
		    	}
		    }
		    return rtn;
	    };

}
