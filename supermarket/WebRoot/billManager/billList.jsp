<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示账单信息</title>
<script type="text/javascript">
	/**删除账单**/
	function deleteBill(obj){
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
		xmlHttp.open("get", "../billManager/deleteBill?id=" + id , true) ;
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
		<form action="../billManager/listBillByNameAndisPay">
		商品名称<input type = "text" name = "name" /><br/>
		是否付款
			<select name = "isPay">
				<option value = "true">是</option>
				<option value = "false">否</option>
			</select><br/>
		<input type = "submit" value = "提交查询" />
		</form>
	</div>
	<hr/>
	<h1>账单信息</h1><br/>
	<table>
		<tr>
			<th>账单ID</th>
			<th>商品名</th>
			<th>供应商名</th>
			<th>总价格</th>
			<th>商品单位</th>
			<th>商品数量</th>
			<th>是否付款</th>
			<th>商品描述</th>
			<th>订单时间</th>
		</tr>
		<c:forEach items = "${billlist}" var = "bill">
				<tr>
					<td >${bill.billId}</td>
					<td ><a href = "../billManager/singleBill?id=${bill.billId}">${bill.goodsName}</a></td>
					<td >${bill.providerName}</td>
					<td >${bill.price}</td>
					<td >${bill.goodsUnit}</td>
					<td >${bill.goodsNum}</td>
					<td >${bill.isPay}</td>
					<td >${bill.goodsDesc}</td>
					<td >${bill.billTime}</td>
					<td><input type = "button" value = "删除" onclick = "deleteBill(this)"/></td>
				</tr>
		</c:forEach>	
	</table>
</div>
	<a href = "../billManager/visitAddBill" >新增账单》》》</a>
</body>
</html>