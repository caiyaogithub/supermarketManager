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
 	供应商：<select name = "providerId">
 				<option>------请选择供应商------</option>
 				<c:forEach items="${providers}" var = "provider">
 					<option value="${provider.providerId}">${provider.providerName}</option>
 				</c:forEach>
 		  </select><br/>
 	交易价格：<input type = "text" name = "price"/> <br/>
 	商品单位: <input type = "text" name = "goodsUnit" /> <br/>
 	商品数量： <input type = "text" name = "goodsNum" /> <br/>
 	是否付款： <select name = "isPay">
 				<option value = "true">是</option>
 				<option value = "false">否</option>
 			</select><br/>
 	商品名称： <input type = "text" name = "goodsName" /> <br/>
 	商品描述： <input type = "text" name = "goodsDesc" /> <br/>
 	<!-- yyyy-[m]m-[d]d hh:mm:ss[.f...].  -->
 	<input type = "hidden" name = "billTime" value = "<%=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) %>" /> <br/>
 	<input type = "submit" value = "提交" />
 </form>
</body>
</html>