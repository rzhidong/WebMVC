package com.web.dao;

import com.web.domain.User;

public interface IUserDao {
	
	void add(User user);
	
	User find(String username);
	
	User find(String username, String password);

}
