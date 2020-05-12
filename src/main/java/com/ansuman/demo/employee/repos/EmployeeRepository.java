package com.ansuman.demo.employee.repos;

import org.springframework.data.repository.CrudRepository;

import com.ansuman.demo.employee.entites.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
