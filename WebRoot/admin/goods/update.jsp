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
    
    <title>My JSP 'save.jsp' starting page</title>
    
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
	更新商品信息<br/>
	<form action="${pageContext.request.contextPath }/goodsAction_update.action" 
	method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>
					商品名称:
				</td>
				<td>
					<input type="text" name="gname" value="${goods.gname}"/>
				</td>
			</tr>
			<tr>
				<td>
					商品售价:
				</td>
				<td>
					<input type="text" name="gprice" value="${goods.gprice }"/>
				</td>
			</tr>
			<tr>
				<td>
					图片上传:
				</td>
				<td colspan="2">
					<input type="file" value="请选择文件" name="goodsFile.image"/>
					<br/>
				</td>
			</tr>
			<tr>
				<td>
					商品类型:
				</td>
				<td>
					<select id="cid" name="category.cid">
						<option value="0">请选择</option>
						<c:forEach items="${applicationScope.categorys}" var="category">
							<c:choose>
								<c:when test="${category.cid==goods.category.cid}">
									<option value="${category.cid}" selected="selected">${category.ctype}</option>
								</c:when>
								<c:otherwise>
									<option value="${category.cid}">${category.ctype }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					加入推荐:
				</td>
				<td>
					<c:choose>
						<c:when test="${goods.gcommend==true}">
							<input type="radio" name="gcommend" checked="checked" value="true" />推荐
							<input type="radio" name="gcommend" value="false"/>不推荐
						</c:when>
						<c:otherwise>
							<input type="radio" name="gcommend" value="true" />推荐
							<input type="radio" name="gcommend" value="false" checked="checked"/>不推荐
						</c:otherwise>
					</c:choose>

				</td>
			</tr>
			<tr>
				<td>
					是否有效:
				</td>
				<td>
					<c:choose>
						<c:when test="${goods.gopen==true}">
							<input type="radio" name="gopen" value="true" checked="checked" />上架
							<input type="radio" name="gopen" value="false"/>下架
						</c:when>
						<c:otherwise>
							<input type="radio" name="gopen" value="true"/>上架
							<input type="radio" name="gopen" value="false"  checked="checked" />下架
						</c:otherwise>
					</c:choose>

				</td>
			</tr>
			<tr>
				<td>
					商品简单描述:
				</td>
				<td colspan="2">
					<textarea name="gremark" rows="4" cols="40" >${goods.gremark}</textarea>
				</td>
			</tr>
			<tr>
				<td>
					商品详细描述:
				</td>
				<td colspan="2">
					<textarea name="gxremark" rows="4" cols="40">${goods.gxremark}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="提交" />
					<input type="reset" value="重置">
					<input type="hidden" name="gpic" value="${goods.gpic }" />
					<input type="hidden" name="gid" value="${goods.gid }" />
				</td>
			</tr>
		</table>
	</form>
	    
    
  </body>
</html>
