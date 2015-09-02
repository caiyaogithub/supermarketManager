<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息</title>
<script type="text/javascript">
	/**删除用户**/
	function deleteUser(obj){
		var confirm = window.confirm("确定删除？") ;
		if(!confirm){
			return  ;
		}
		// 收集数据
		var id = obj.parentNode.parentNode.getElementsByTagName("td")[0].innerHTML ;
		alert("id: " + id ) ;
		// 发送数据
		var xmlHttp = new XMLHttpRequest() ;
		xmlHttp.onreadystatechange = function(){ stateChange(xmlHttp) ;} ;
		xmlHttp.open("get", "../userManager/deleteUser?id=" + id , true) ;
		xmlHttp.send(null) ;
	}
	function stateChange(xmlHttp){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200 ){
			if(xmlHttp.responseText == "success"){
				alert("数据删除成功！ ") ;
				location.reload(true) ;
			}
		}
	}
</script>
</head>
<body>
<div width = "1000" align = "center">
	<h1>用户管理页面</h1>
	<h4>用户列表</h4>
	<table border="2px solid" >
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>用户密码</th>
			<th>性别</th>
			<th>年龄</th>
			<th>电话号码</th>
			<th>地址</th>
			<th>删除</th>
		</tr>
		<c:forEach items = "${userlist}" var = "user">
				<tr>
					<td >${user.userId}</td>
					<td ><a href = "../userManager/singleUser?id=${user.userId}">${user.userName }</a></td>
					<td >${user.userPassword }</td>
					<td >${user.gender }</td>
					<td >${user.age }</td>
					<td >${user.telephoneNum }</td>
					<td >${user.address }</td>
					<td><input type = "button" value = "删除" onclick = "deleteUser(this)"/></td>
				</tr>
		</c:forEach>	
	</table>
</div>
<br/><br/><br/>
<a href = "addUser.jsp" >新增用户</a><br/><br/><br/><br/>

<a href = "${sessionScope.currentLogin == 'admin' ? '../admin/admin_main.jsp' : '../commonUser/user_main.jsp'}">返回主功能页面》》》</a>
</body>
</html>