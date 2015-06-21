<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
  	<script type="text/javascript">
	  	$(function(){
	  		$(".bdelete").click(function(){
	  			$.post("categoryAction_delete.action",
	  			{cid : $(this).attr("lang")} );
	  			$(this).parents("tr:first").remove();
	  		});
	  		
	  		$(".bupdate").click(function(){
	  			var chotTd = $(this).parent().prev();//热点的td
	  			var ctypeTd = $(this).parent().siblings(".ctype");//类此那个的td
	  			if($(this).val()=="更新"){
	  				$(this).val("确认");
	  				chotTd.children().removeAttr("disabled");
	  				ctypeTd.html("<input type='text' value='" + ctypeTd.html() + "' />");
	  			}else{
	  				$(this).val("更新");
	  				chotTd.children().attr("disabled","disabled");
	  				ctypeTd.html(ctypeTd.children().val());
	  				var isChecked = chotTd.children().attr("checked")=="checked" ? true : false;
	  				$.post(
	  					"categoryAction_update.action",
	  					{
	  						"cid" : $(this).attr("lang"),
	  						"ctype" : ctypeTd.html(),
	  						"chot" : isChecked
	  					}
	  				);
	  			}
	  		});
	  	});
	 </script>
  </head>
  
  <body>
  	类别查询:<br/>
	<form action="${pageContext.request.contextPath}/categoryAction_query.action" method="post">
		<input type="text" name="ctype" />
		<input type="submit" value="查询" />
	</form>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>类别</th>
			<th>热点</th>
			<th>更新</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.categorys}" var="cat" varStatus="num">
			<tr>
				<td>${num.count}</td>
				<td class="ctype">
					<c:out value="${cat.ctype}"></c:out>					
				</td>
				<td>
					<c:choose>
						<c:when test="${cat.chot==true}">
							<input type="checkbox" value="true" checked="checked" disabled="disabled"/>
						</c:when>
						<c:otherwise>
							<input type="checkbox" value="true" disabled="disabled"/>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<input type="button" class="bupdate" value="更新" lang="${cat.cid }"/>
				</td>
				<td>
					<input type="button" class="bdelete" value="删除" lang="${cat.cid }"/>
				</td>
			</tr>
		</c:forEach>

	</table>    
  </body>
</html>
