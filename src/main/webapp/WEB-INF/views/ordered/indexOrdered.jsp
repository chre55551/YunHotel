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

			<tr>
				<td width="350"><p align="center" /> <a href='insertOrdered'>新增餐點訂單</a><BR>
				</td>
			</tr>
			<tr>
				<td width="350"><p align="center" /> <a href="thisOrdered">查詢餐點訂單</a><BR>
					<BR></td>
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