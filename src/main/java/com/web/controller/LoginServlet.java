package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.domain.User;
import com.web.service.IUserService;
import com.web.service.impl.UserServiceImpl;



public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取用户填写的登录用户名
		String username = request.getParameter("username");
		// 获取用户填写的登录密码
		String password = request.getParameter("password");

		IUserService service = new UserServiceImpl();
		// 用户登录
		User user = service.loginUser(username, password);
		if (user == null) {
			String message = String
					.format("对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'",
							request.getContextPath()
									+ "/servlet/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		// 登录成功后，就将用户存储到session中
		request.getSession().setAttribute("user", user);
		String message = String
				.format("恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'",
						user.getUsername(), request.getContextPath()
								+ "/index.jsp");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
