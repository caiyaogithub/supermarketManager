<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单个订单信息</title>
</head>
<body>
	<h2 align = "center">${billInfo.goodsName}订单的信息</h2>
	<form action="../billManager/modifyBill" method = "post">
	    <table width = "500" align = "center">
	    	<tr>
	    		<td>订单ID</td>
	    		<td>
	    		${billInfo.billId}
	    		<input type = "hidden" value = "${billInfo.billId }" name = "id" />
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>商品名</td>
	    		<td>
	    		<input type = "text" value = "${billInfo.goodsName }" name = "goodsName" />
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>供应商名</td>
	    		<td>
	    		<select name = "provider">
	 				<option value = "${billInfo.providerId}" >${billInfo.providerName}</option>
	 				<c:forEach items="${providers}" var = "providerItem">
	 					<option value= "${providerItem.providerId }">${providerItem.providerName}</option>
	 				</c:forEach>
 		  		</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>价格</td>
	    		<td><input type = "text" name = "price"  value = "${billInfo.price }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>单位</td>
	    		<td><input type = "text" name = "goodsUnit"  value = "${billInfo.goodsUnit }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>商品数量</td>
	    		<td><input type = "text" name = "goodsNum"  value = "${billInfo.goodsNum }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>是否付款</td>
	    		<td>
	    			<select name = "isPay" >
	    				<option value = "${billInfo.isPay }">${billInfo.isPay == "true" ? "是" : "否" }</option>
	    				<option value = "true">是</option>
	    				<option value = "false">否</option>
	    			</select>
	    	</tr>
	    	
	    	<tr>
	    		<td>商品描述</td>
	    		<td><input type = "text" name = "goodsDesc"  value = "${billInfo.goodsDesc }"/></td>
	    	</tr>
	    	
	    	<tr>
	    	<!-- 订单时间不能修改 -->
	    		<td>订单时间</td>
	    		<td>${billInfo.billTime }<input type = "hidden" name = "billTime"  value = "${billInfo.billTime }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td><input type = "submit" value = "提交修改"/></td>
	    		<td colspan = "1" ><input type = "button" value = "取消修改" onclick = "javascript:window.location.href='../billManager/listBill'" /></td>
	    	</tr>
	    </table>
	</form>
</body>
</html>