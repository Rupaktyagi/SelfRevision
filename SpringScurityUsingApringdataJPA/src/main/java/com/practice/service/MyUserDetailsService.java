package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.model.Employee;
import com.practice.model.MyUserDetail;
import com.practice.repo.EmployeeRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo repo;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			Employee emp = repo.findByUserName(username);
			
			if(emp!=null)
			{
				return new MyUserDetail(emp);
			}
		throw new UsernameNotFoundException("No user Found");
	}

}
