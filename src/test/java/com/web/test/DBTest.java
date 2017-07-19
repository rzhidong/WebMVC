package com.web.test;

import com.web.dao.impl.UserDaoImpl;
import com.web.domain.User;
import com.web.util.DBUtil;

public class DBTest {
	
	public static void main(String[] args) {
		
		System.out.println(DBUtil.getConnection());
		
		User user = new User();
		
		user.setId("1");
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("1@1.cn");
		user.setBirthday("1999-01-09");
		
		//new UserDaoImpl().add(user);
		
		System.out.println(new UserDaoImpl().find(user.getUsername()));
		
		System.out.println(new UserDaoImpl().find(user.getUsername(), user.getPassword()));
	}

}
