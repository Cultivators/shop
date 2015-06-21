<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=gb2312" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  	<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$(".dbutton").click(function(){
				$.post("sorderAction_removeSorder.action",
					{"goods.gid" : $(this).attr("id")},
					function(result){
						$("#ftotal").html(result.ftotal);
					}
				);
				$(this).parents("tr:first").remove();  				
  			});
  		});
  	</script>
  	</head>
  
  <body>
	�����嵥
	<table>
		<tr>
			<td>��Ʒ���</td>
			<td>��Ʒ����</td>
			<td>��Ʒ�۸�</td>
			<td>��Ʒ����</td>
			<td>����</td>
		</tr>
		<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
		<tr>
			<td>
				${sorder.goods.gid}
			</td>
			<td>
				${sorder.sname}
			</td>
			<td>
				${sorder.sprice }
			</td>
			<td>
				<input type="text" value="${sorder.snumber }" size="2" />
			</td>
			<td>
				<input type="button" value="ɾ��"  class="dbutton" id="${sorder.goods.gid}" />
			</td>
		</tr>		
		</c:forEach>
	</table>
	<div id="ftotal">
		��Ʒ�ܼ�Ϊ:<fmt:formatNumber pattern="#.##" value="${sessionScope.forder.ftotal}"></fmt:formatNumber>
	</div>
	<a href="${pageContext.request.contextPath}/users/confirm.jsp">�ύ</a>
  </body>
</html>
