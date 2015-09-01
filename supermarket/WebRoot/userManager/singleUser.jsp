<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单个用户信息</title>
</head>
<body>
	<h2 align = "center">${userInfo.userName}的信息</h2>
	<form action="../userManager/modifyUser" method = "post">
	    <table width = "500" align = "center">
	    	<tr>
	    		<td>用户ID</td>
	    		<td>
	    		${userInfo.userId}
	    		<input type = "hidden" value = "${userInfo.userId }" name = "id" />
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>用户名</td>
	    		<td><input type = "text" name = "name" value = "${userInfo.userName }"/></td>
	    	</tr>
	    	<tr>
	    		<td>密码</td>
	    		<td><input type = "text" name = "password"  value = "${userInfo.userPassword }"/></td>
	    	</tr>
	    	<tr>
	    		<td>性别</td>
	    		<td><input type = "text" name = "gender"  value = "${userInfo.gender }"/></td>
	    	</tr>
	    	<tr>
	    		<td>年龄</td>
	    		<td><input type = "text" name = "age"  value = "${userInfo.age }"/></td>
	    	</tr>
	    	<tr>
	    		<td>电话</td>
	    		<td><input type = "text" name = "telephone"  value = "${userInfo.telephoneNum }"/></td>
	    	</tr>
	    	<tr>
	    		<td>地址</td>
	    		<td><input type = "text" name = "address"  value = "${userInfo.address }"/></td>
	    	</tr>
	    	<tr>
	    		<td><input type = "submit" value = "提交修改"/></td>
	    	</tr>
	    </table>
	</form>
</body>
</html>