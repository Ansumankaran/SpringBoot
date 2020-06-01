package com.ansuman.demo.employee.repos;

import java.awt.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ansuman.demo.employee.entites.User;

public interface UserRepository extends CrudRepository<User,Long> {
	
  
	Optional<User> findById(Long id);
	
}
