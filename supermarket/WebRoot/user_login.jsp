<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户登陆</title>
</head>
<body>	
<div width = "500" align = "center">
	<h2>普通用户登陆</h2>
	<form action="authority/UserLogin" method = "post"  >
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
</div>
</body>
</html>