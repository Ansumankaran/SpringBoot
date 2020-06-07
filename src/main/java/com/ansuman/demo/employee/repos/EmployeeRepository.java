package com.ansuman.demo.employee.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ansuman.demo.employee.entites.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	
	
	Employee findByFirstName(@Param("firstName") String name);
			

}
