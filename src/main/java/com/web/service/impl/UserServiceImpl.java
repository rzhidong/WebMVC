package com.web.service.impl;

import com.web.dao.IUserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.domain.User;
import com.web.exception.UserExistException;
import com.web.service.IUserService;

public class UserServiceImpl implements IUserService{
	
	private IUserDao userDao = new UserDaoImpl();

	public void registerUser(User user) throws UserExistException {
		// TODO Auto-generated method stub
		if (userDao.find(user.getUsername()) != null) {
			//
			throw new UserExistException("注册的用户名已存在！！！");
		}else {
			userDao.add(user);
		}
	}

	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.find(username, password);
	}

}
