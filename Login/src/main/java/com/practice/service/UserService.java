package com.practice.service;


import org.springframework.stereotype.Service;

import com.practice.model.User;


@Service
public interface UserService {

	public User registorUser(User user);
	
	public String login(String username ,String password);
	
	
	public String updateUser(User user);
}
