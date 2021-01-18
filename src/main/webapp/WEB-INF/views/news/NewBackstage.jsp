<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>消息功能</title>
</head>
<body>
	<div align='center'>
		<h3>消息功能</h3>
		
		<a href='showNews'>顯示消息</a><br> 
		<a href='insertNews'>新增消息</a><br>
		<a href='deleteNew'>刪除消息</a><br>
		<a href='updateNews'>修改消息</a><br>
		<hr>
		<a href="<c:url value='/' />">首頁</a><br>
	</div>
</body>
</html>