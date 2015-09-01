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
		alert("userName ： " + userName ) ;
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
	
</script>
</head>
<body>
 <%
			String result = "" ;
			if(request.getParameter("result") != null && request.getParameter("result").equals("1")){
				result = "表单信息填写错误，请重新填写" ;
			}
%>
  <div><%=result%></div>
 <h1 align = "center">添加用户</h1>
 <form action="addUser" method = "post" >
 <!-- 对这些字段的校验前后台都需要执行 -->
 	用户名：<input type = "text" name = "username" onblur = "checkUserNameExist(this)" />  <div id = "checkResult"></div><br/>
 	用户密码：<input type = "text" name = "password"/> <br/>
 	确认密码: <input type = "text" name = "rpassword" /> <br/>
 	用户性别 ： <input type = "text" name = "gender" /> <br/>
 	用户年龄： <input type = "text" name = "age" /> <br/>
 	用户电话： <input type = "text" name = "telephone" /> <br/>
 	地址： <input type = "text" name = "address" /> <br/>
 	<input type = "submit" value = "提交" />
 </form>
</body>
</html>