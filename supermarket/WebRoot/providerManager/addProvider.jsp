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
 <%
			String result = "" ;
			if(request.getParameter("result") != null && request.getParameter("result").equals("1")){
				result = "表单信息填写错误，请重新填写" ;
			}
%>
  <div><%=result%></div>
 <h1 align = "center">添加供应商</h1>
 <form action="addProvider" method = "post" >
 <!-- 对这些字段的校验前后台都需要执行 -->
 	供应商名：<input type = "text" name = "providername" onblur = "checkProviderNameExist(this)" />  <div id = "checkResult"></div><br/>
 	供应商描述：<input type = "text" name = "providerDesc"/> <br/>
 	联系人: <input type = "text" name = "linkman" /> <br/>
 	供应商电话： <input type = "text" name = "telephone" /> <br/>
 	传真： <input type = "text" name = "fax" /> <br/>
 	地址： <input type = "text" name = "address" /> <br/>
 	<input type = "submit" value = "提交" />
 </form>
</body>
</html>