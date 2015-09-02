<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加供应商页面</title>
<script type="text/javascript">
	/**检查供应商名是否存在**/
	function checkProviderNameExist(obj){
		document.getElementById("checkResult").innerHTML = "" ;
		// 收集数据
		var providerName = obj.value ;
		alert("ProviderName ： " + providerName ) ;
		// 发送数据
		var xmlHttp = new XMLHttpRequest() ;
		xmlHttp.onreadystatechange = function(){ stateChange(xmlHttp) ;}
		xmlHttp.open("get", "../providerManager/checkProviderNameExist?name=" + providerName, true ) ;
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
<div width = "500" align = "center">
 <%
			String result = "" ;
			if(request.getParameter("result") != null && request.getParameter("result").equals("1")){
				result = "表单信息填写错误，请重新填写" ;
			}
%>
  <div><%=result%></div>
 <h1 align = "center">添加供应商</h1>
 <form action="addProvider" method = "post" >
 <table>
 	<tr>
 		<td>供应商名：</td>
 		<td><input type = "text" name = "providername" onblur = "checkProviderNameExist(this)" />  <div id = "checkResult"></div></td>
 	</tr>
 	<tr>
 		<td>供应商描述：</td>
 		<td><input type = "text" name = "providerDesc"/></td>
 	</tr>
 	<tr>
 		<td>联系人: </td>
 		<td><input type = "text" name = "linkman" /></td>
 	</tr>
 	<tr>
 		<td>供应商电话：</td>
 		<td><input type = "text" name = "telephone" /></td>
 	</tr>
 	<tr>
 		<td>传真：</td>
 		<td> <input type = "text" name = "fax" /></td>
 	</tr>
 	<tr>
 		<td>地址：</td>
 		<td><input type = "text" name = "address" /></td>
 	</tr>
 	<tr>
 		<td><input type = "submit" value = "提交" /></td>
 		<td><input type = "button" value = "取消添加" onclick = "javascript:window.history.back(-1)"/></td>
 	</tr>
 </table>
 </form>
 </div>
</body>
</html>