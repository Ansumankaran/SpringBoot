package com.ansuman.demo.employee.repos;

import org.springframework.data.repository.CrudRepository;

import com.ansuman.demo.employee.entites.Student;


public interface StudentRepository extends CrudRepository<Student, Long> {
	Student findByMobileNumberAndPassword(String mobileNumber,String password);
	Student findByMobileNumber(String mobileNumber);
	
}
