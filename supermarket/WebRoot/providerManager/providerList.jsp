<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示供应商信息</title>
<script type="text/javascript">
	/**删除供应商**/
	function deleteProvider(obj){
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
		xmlHttp.open("get", "../providerManager/deleteProvider?id=" + id , true) ;
		xmlHttp.send(null) ;
	}
	function stateChange(xmlHttp){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200 ){
			if(xmlHttp.responseText == "success"){
				alert("数据删除成功！ ") ;
				location.reload(true) ; // 这样做没有达到异步的效果
			}
		}
	}
</script>
</head>
<body>
<div width="500px" align = "center">
	<div width = "400px" align = "center">
		<h3>组合查询</h3>
		<form action="../providerManager/listProviderByNameAndDesc">
		供应商名称<input type = "text" name = "name" /><br/>
		供应商描述<input type = "text" name = "desc" /><br/>
		<input type = "submit" value = "提交查询" />
		</form>
	</div>
	<hr/>
	<h1>供应商信息</h1><br/>
	<table>
		<tr>
			<th>供应商ID</th>
			<th>供应商名</th>
			<th>描述</th>
			<th>联系人</th>
			<th>电话号码</th>
			<th>传真</th>
			<th>地址</th>
			<th>删除</th>
		</tr>
		<c:forEach items = "${providerlist}" var = "provider">
				<tr>
					<td >${provider.providerId}</td>
					<td ><a href = "../providerManager/singleProvider?id=${provider.providerId}">${provider.providerName }</a></td>
					<td >${provider.providerDesc }</td>
					<td >${provider.linkman }</td>
					<td >${provider.telephone }</td>
					<td >${provider.fax }</td>
					<td >${Provider.address }</td>
					<td><input type = "button" value = "删除" onclick = "deleteProvider(this)"/></td>
				</tr>
		</c:forEach>	
	</table>
</div>
	<a href = "addProvider.jsp" >新增供应商》》》</a>
</body>
</html>