<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单个用户信息</title>
<script type="text/javascript">
/**检查用户名是否存在**/
	function checkUserNameExist(obj){
		document.getElementById("checkResult").innerHTML = "" ;
		// 收集数据
		var userName = obj.value ;
		var id = obj.parentNode.parentNode.parentNode.getElementsByTagName("tr")[0].getElementsByTagName("td")[1].getElementsByTagName("input")[0].value ;
		alert("userName ： " + userName + "id ： " + id ) ;
		// 发送数据
		var xmlHttp = new XMLHttpRequest() ;
		xmlHttp.onreadystatechange = function(){ stateChange(xmlHttp) ;}
		xmlHttp.open("get", "../userManager/checkModifyUserName?name=" + userName + "&id=" + id , true ) ;
		xmlHttp.send( null ) ;
	}
	function stateChange(xmlHttp){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200 ){
			if(xmlHttp.responseText != null && xmlHttp.responseText != "" ){
				document.getElementById("checkResult").innerHTML = xmlHttp.responseText ;
			}
		}
	}
</script>
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
	    		<td><input type = "text" name = "name" value = "${userInfo.userName }" onblur = "checkUserNameExist(this)" /><div id = "checkResult"></div></td>
	    	</tr>
	    	<tr>
	    		<td>密码</td>
	    		<td><input type = "text" name = "password"  value = "${userInfo.userPassword }"/></td>
	    	</tr>
	    	<tr>
	    		<td>性别</td>
	    		<td>
	    			<select name = "gender" >
	    				<option value = "${userInfo.gender}">${userInfo.gender}</option>
	    				<option value = "男">男</option>
	    				<option value = "女">女</option>
	    			</select>
	    		</td>
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
	    	<tr></tr>
	    	<tr></tr>
	    	<tr>
	    		<td colspan="1"><input type = "submit" value = "提交修改"/></td>
	    		<td colspan = "1" ><input type = "button" value = "取消修改" onclick = "javascript:window.location.href='../userManager/listUser'" /></td>
	    	</tr>
	    </table>
	</form>
</body>
</html>