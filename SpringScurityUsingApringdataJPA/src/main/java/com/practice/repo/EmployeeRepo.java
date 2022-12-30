package com.practice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public Employee findByUserName(String username);
	
}
