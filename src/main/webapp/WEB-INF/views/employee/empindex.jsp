<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<h3>員工資料</h3>
		
		<a href='employees'>查詢全部員工資料</a><br>
		
		<a href='thisEmployee'>查詢單筆員工資料</a><br>
		
		<a href='insertEmployee'>新增員工資料</a><br>

		<hr>
		<a href="<c:url value='/' />">首頁</a><br>
	</div>
</body>
</html>