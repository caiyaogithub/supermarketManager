<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户功能页面</title>
</head>
<body>
	<span>欢迎用户：<font>${userlogin} 登录系统</font></span><br />
	<a href = "../billManager/listBill">订单管理</a> <br/>
	<a href = "../providerManager/listProvider">供应商管理</a><br/> 
	<a href = "../authority/exit" >退出系统</a><br/>
</body>
</html>