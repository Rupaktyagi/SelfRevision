package com.practice.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.practice.model.Employee;
import com.practice.repo.EmployeeRepo;

@Component
public class GetCurrentUser {

	private EmployeeRepo employeeDao;
	
	
	
	public Employee getLoggedInUserDetails() {
		
		
		SecurityContext sc=SecurityContextHolder.getContext();
		
		Authentication auth = sc.getAuthentication();
		
		return employeeDao.findByUserName(auth.getName());
		
		
		
	}
	
}
