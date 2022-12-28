package com.practice.service;

import com.practice.model.User;
import com.practice.repo.UserRepo;

public class UserSerImpl implements UserService{

	private UserRepo repo;
	
	
	@Override
	public User registorUser(User user) {
		User us=repo.save(user);
		us.setPassword("******");
		return us;
	}

	@Override
	public String login(String username, String password) {
		
		
		return null;
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
