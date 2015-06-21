<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'detail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%-- <script type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script type="text/javascript">
	$(function(){
		$(".buy").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action",href).submit();
			return false;
		});
	});
</script> --%>
</head>

<body>
	商品详细信息
	<table border="1" cellpadding="0" width="400px" cellspacing="0"
		id="save_text">
		<tr>
			<td>商品名称：</td>
			<td>${requestScope.goods.gname}</td>
		</tr>
		<tr>
			<td>商品售价：</td>
			<td>${requestScope.goods.gprice}</td>
		</tr>
		<tr>
			<td colspan="2"><img
				src="${pageContext.request.contextPath}/image/${fn:substring(requestScope.goods.gpic, fn:indexOf(requestScope.goods.gpic,'?')+1,-1)}" />
			</td>
		</tr>
		<tr>
			<td>商品类型：</td>
			<td>${requestScope.goods.category.ctype}</td>
		</tr>
		<tr>
			<td>商品简单介绍</td>
			<td>${requestScope.goods.gremark}</td>
		</tr>
		<tr>
			<td>商品详细介绍</td>
			<td>${requestScope.goods.gxremark}</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:url value="/sorderAction_addSorder.action" var="add">
					<c:param name="goods.gid" value="${requestScope.goods.gid }"></c:param>
					<c:param name="sname" value="${requestScope.goods.gname }"></c:param>
					<c:param name="sprice" value="${requestScope.goods.gprice}"></c:param>
					<c:param name="snumber" value="1" ></c:param>
				</c:url> 
				<a href="${add}">购买</a>
			</td>
		</tr>
	</table>
</body>
</html>
