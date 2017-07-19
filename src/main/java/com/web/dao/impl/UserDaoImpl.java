package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.dao.IUserDao;
import com.web.domain.User;
import com.web.util.DBUtil;

public class UserDaoImpl implements IUserDao {

	private Connection connection;

	private PreparedStatement pdst;

	private ResultSet resultSet;

	public void add(User user) {
		// TODO Auto-generated method stub

		connection = DBUtil.getConnection();

		String sql = "insert into user "
				+ "(username,password,email,birthday)"
				+ " values(?,?,?,?)";

		try {
			pdst = connection.prepareStatement(sql);
			pdst.setString(1, user.getUsername());
			pdst.setString(2, user.getPassword());
			pdst.setString(3, user.getEmail());
			pdst.setString(4, user.getBirthday());

			pdst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnecton(connection);
			try {
				pdst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public User find(String username) {
		// TODO Auto-generated method stub

		connection = DBUtil.getConnection();

		String sql = "select * from user where username = ?";

		User user = null;

		try {
			pdst = connection.prepareStatement(sql);
			pdst.setString(1, username);

			resultSet = pdst.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					user = new User();
					user.setId(resultSet.getString("id"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));
					user.setBirthday(resultSet.getString("birthday"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnecton(connection);
			try {
				pdst.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}

	public User find(String username, String password) {
		// TODO Auto-generated method stub
		connection = DBUtil.getConnection();

		String sql = "select * from user where username = ? and password = ?";

		User user = null;

		try {
			pdst = connection.prepareStatement(sql);
			pdst.setString(1, username);
			pdst.setString(2, password);
			resultSet = pdst.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					user = new User();
					user.setId(resultSet.getString("id"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));
					user.setBirthday(resultSet.getString("birthday"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnecton(connection);
			try {
				pdst.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}

}
