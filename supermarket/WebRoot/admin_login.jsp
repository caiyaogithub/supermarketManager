<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
	<form action="authority/AdminLogin" method = "post"  >
		用户名：<input type = "text" name = "name" /> <br>
		密码： <input type = "text" name = "password" /><br>
		<input type = "submit" value = "提交" />
		<span>
		<%
			String result = "" ;
			if(request.getParameter("result") != null && request.getParameter("result").equals("1")){
				result = "用户名或密码错误" ;
			}
		 %>
		<%=result %>
		</span>
	</form>
</body>
</html>