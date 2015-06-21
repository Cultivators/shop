<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'query.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="${pageContext.request.contextPath}/goodsAction_query.action" method="post">
		商品名:<input type="text" name="gname" />
		<input type="submit" value="查询"/>
	</form>
	<table border="1">
		<tbody>
			<tr>
				<th>编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>日期</th>
				<th>是否推荐</th>
				<th>是否上架</th>
				<th>所属类别</th>
				<th>更新</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${requestScope.goodsList}" var="gl" varStatus="num">
				<tr>
					<td>${num.count}</td>
					<td>${gl.gname}</td>
					<td>${gl.gprice}</td>
					<td><fmt:formatDate value="${gl.gdate}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>${gl.gcommend}</td>
					<td>${gl.gopen}</td>
					<td>${gl.category.ctype}</td>
					<td><c:url value="/goodsAction_get.action" var="gupdate">
							<c:param name="gid" value="${gl.gid}"></c:param>
						</c:url> <a href="${gupdate}">更新</a>
					</td>
					<td><c:url value="/goodsAction_delete.action" var="gdelete">
							<c:param name="gid" value="${gl.gid}"></c:param>
						</c:url> <a href="${gdelete}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
