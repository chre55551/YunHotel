<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IndexOrdered</title>
</head>
<body>
	<hr>
	<div>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><a href="thisOrdered">查詢產品資料</a><BR>
				<BR></td>
		</tr>

<!-- 		<tr height="52" bgcolor="lightblue" align="center"> -->
<!-- 			<td width="350"><p align="left" /> -->
<!-- 				<a href='products'>查詢所有產品資料</a><BR></td> -->
<!-- 			<td width="350"> -->
<!-- 				<p align="left" /> -->
<%-- 				<a href="<c:url value='/update/stock' />">更新多筆產品的庫存數量</a><BR> --%>
<!-- 			</td> -->
<!-- 		</tr> -->

<!-- 		<tr height="52" bgcolor="lightblue" align="center"> -->
<!-- 			<td width="350"><p align="left" /> <a href='queryByCategory'>分類查詢</a><BR> -->
<!-- 			</td> -->
		<tr>
			<td width="350"><p align="left" /> 
				<a href='insertOrdered'>新增產品資料</a><BR>
			</td>
		</tr>
	</table>
		<a href="<c:url value='/'/> ">回首頁</a>
	</div>
	<hr>
	<%-- 	req.getRequestURL()=${getRequestURL} --%>
	<%-- 	<br> req.getRequestURI()=${getRequestURI} --%>
	<%-- 	<br> req.getContextPath()=${getContextPath} --%>
	<%-- 	<br> req.getQueryString()=${getQueryString} --%>
	<!-- 	<br> -->
</body>
</html>