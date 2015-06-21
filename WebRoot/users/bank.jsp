<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bank.jsp' starting page</title>
    
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
   订单编号:${sessionScope.forder.fid}<br/>
   订单金额:${sessionScope.forder.ftotal}<br/>
    <form action="" method="post">
    	<table>
    		<tr>
    		<c:forEach items="${applicationScope.bankImage}" var="image" varStatus="num">
    			<td>
    				<input type="radio" />
    				<img src="${pageContext.request.contextPath}/image/logo/${image}" />
    			</td>
    			<c:if test="${num.count%5==0 }">
    				<tr/><tr>
    			</c:if>
    		</c:forEach>
    		</tr>
    	</table>
    </form>
  </body>
</html>
