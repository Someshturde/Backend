package com.niit.dao;

import com.niit.model.User;

public interface UserDao {

	public void registerUser(User user);
	
	User login(User user);
	
	User getUser(String email);
}
