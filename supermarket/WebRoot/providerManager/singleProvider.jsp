<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单个供应商信息</title>
</head>
<body>
	<h2 align = "center">${providerInfo.providerName}的信息</h2>
	<form action="../providerManager/modifyProvider" method = "post">
	    <table width = "500" align = "center">
	    	<tr>
	    		<td>供应商ID</td>
	    		<td>
	    		${providerInfo.providerId}
	    		<input type = "hidden" value = "${providerInfo.providerId }" name = "id" />
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>供应商名</td>
	    		<td><input type = "text" name = "name" value = "${providerInfo.providerName }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>描述</td>
	    		<td><input type = "text" name = "desc"  value = "${providerInfo.providerDesc }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>联系人</td>
	    		<td><input type = "text" name = "linkman"  value = "${providerInfo.linkman }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>电话</td>
	    		<td><input type = "text" name = "telephone"  value = "${providerInfo.telephone }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>fax</td>
	    		<td><input type = "text" name = "fax"  value = "${providerInfo.fax }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>地址</td>
	    		<td><input type = "text" name = "address"  value = "${providerInfo.address }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td><input type = "submit" value = "提交修改"/></td>
	    	</tr>
	    </table>
	</form>
</body>
</html>