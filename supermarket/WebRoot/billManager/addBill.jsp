<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date,java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加订单页面</title>
<script type="text/javascript">	
</script>
</head>
<body>
<div width = "500" align ="center">
 <%
			String result = "" ;
			if(request.getParameter("result") != null && request.getParameter("result").equals("1")){
				result = "表单信息填写错误，请重新填写" ;
			}
%>
  <div><%=result%></div>
 
 <h1 align = "center">添加订单</h1>
 <form action="addBill" method = "post" >
 <!-- 对这些字段的校验前后台都需要执行 -->
  <table>
  	<tr>
  		<td>供应商：</td>
  		<td><select name = "providerId">
 				<option>------请选择供应商------</option>
 				<c:forEach items="${providers}" var = "provider">
 					<option value="${provider.providerId}">${provider.providerName}</option>
 				</c:forEach>
 		  </select>
 		  </td>
  	</tr>
  	<tr>
  		<td>交易价格：</td>
  		<td><input type = "text" name = "price"/></td>
  	</tr>
  	<tr>
  		<td>商品单位:</td>
  		<td> <input type = "text" name = "goodsUnit" /></td>
  	</tr>
  	<tr>
  		<td>商品数量：</td>
  		<td><input type = "text" name = "goodsNum" /></td>
  	</tr>
  	<tr>
  		<td>是否付款：</td>
  		<td><select name = "isPay">
 				<option value = "true">是</option>
 				<option value = "false">否</option>
 			</select>
 			</td>
  	</tr>
  	<tr>
  		<td>商品名称：</td>
  		<td><input type = "text" name = "goodsName" /></td>
  	</tr>
  	<tr>
  		<td>商品描述： </td>
  		<td><input type = "text" name = "goodsDesc" /></td>
  	</tr>
  	<tr>
  		<td><input type = "submit" value = "提交" /></td>
  		<td><input type = "button" value = "取消添加" onclick = "javascript:window.location.href='../billManager/listBill'"/> </td>
  	</tr> 
  </table>
 	<!-- yyyy-[m]m-[d]d hh:mm:ss[.f...].  -->
 	<input type = "hidden" name = "billTime" value = "<%=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) %>" /> <br/>
 </form>
 </div>
</body>
</html>