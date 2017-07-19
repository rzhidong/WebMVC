<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<base href="<%=basePath%>">
</head>

<body style="text-align: center;">
	<form
		action="servlet/RegisterServlet"
		method="post">
		<table width="60%" border="1">
			<tr>
				<td>用户名</td>
				<td>
					<%--使用EL表达式${}提取存储在request对象中的formbean对象中封装的表单数据(formbean.username)以及错误提示消息(formbean.errors.username)--%>
					<input type="text" name="username" value="${formbean.username}">${formbean.errors.username}
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"
					value="${formbean.password}">${formbean.errors.password}</td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="confirmPwd"
					value="${formbean.confirmPwd}">${formbean.errors.confirmPwd}
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${formbean.email}">${formbean.errors.email}
				</td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthday"
					value="${formbean.birthday}">${formbean.errors.birthday}</td>
			</tr>
			<tr>
				<td><input type="reset" value="清空"></td>
				<td><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
</body>
</html>
