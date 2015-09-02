<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户页面</title>
<script type="text/javascript">
	/**检查用户名是否存在**/
	function checkUserNameExist(obj){
		document.getElementById("checkResult").innerHTML = "" ;
		// 收集数据
		var userName = obj.value ;
		if(obj.value == null || obj.value == "" ){
			document.getElementById("checkResult").innerHTML = "用户名不能为空" ;
		}
		// 发送数据
		var xmlHttp = new XMLHttpRequest() ;
		xmlHttp.onreadystatechange = function(){ stateChange(xmlHttp) ;}
		xmlHttp.open("get", "../userManager/checkUserNameExist?name=" + userName, true ) ;
		xmlHttp.send( null ) ;
	}
	function stateChange(xmlHttp){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200 ){
			if(xmlHttp.responseText != null && xmlHttp.responseText != "" ){
				document.getElementById("checkResult").innerHTML = xmlHttp.responseText ;
			}
		}
	}
	function checkPsdConsistent(){
		var password = document.getElementById("password") ;
		var rpassword = document.getElementById("rpassword") ;
		if(password != rpassword ){
			document.getElementById("psdCheck").innerHTML = "两次密码输入不匹配" ;
		}
	}
	function cancelAdd(){
		
	}
</script>
</head>
<body>
<div width = "500" align = "center" >
	<h1>添加用户</h1>
 <%
			String result = "" ;
			if(request.getParameter("result") != null && request.getParameter("result").equals("1")){
				result = "表单信息填写错误，请重新填写" ;
			}
%>
  <div><%=result%></div>
 <form action="addUser" method = "post" >
 <!-- 对这些字段的校验前后台都需要执行 -->
 <table>
 	<tr>
 		<td>用户名：</td>
 		<td><input type = "text" name = "username" onblur = "checkUserNameExist(this)" /><span id = "checkResult" ></span></td>
 	</tr>
 	<tr>
 		<td>用户密码：</td>
 		<td><input type = "text" name = "password" onblur = "checkPsdConsistent()"/></td>
 	</tr>
 	<tr>
 		<td>确认密码: </td>
 		<td><input type = "text" name = "rpassword" onblur = "checkPsdConsistent()"/> <span id = "psdCheck"></span></td>
 	</tr>
 	<tr>
 		<td>用户性别 ：</td>
 		<td><select name = "gender">
 			<option value = "男">男</option>
 			<option value = "女">女</option>
 		</select>
 		</td>
 	</tr>
 	<tr>
 		<td>用户年龄：</td>
 		<td> <input type = "text" name = "age" /></td>
 	</tr>
 	<tr>
 		<td>用户电话： </td>
 		<td><input type = "text" name = "telephone" /> </td>
 	</tr>
 	<tr>
 		<td>地址： </td>
 		<td><input type = "text" name = "address" /></td>
 	</tr>
 	<tr>
 		<td><input type = "submit" value = "提交" /></td>
 		<td><input type = "button" value = "取消添加" onclick = "javascript:window.history.back(-1);"/></td>
 	</tr>
 </table>
 </form>
</div>
</body>
</html>