package com.web.service;

import com.web.dao.IUserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.domain.User;
import com.web.exception.UserExistException;

public interface IUserService {

	void registerUser(User user) throws UserExistException;
	
	User loginUser(String username, String password);
}
