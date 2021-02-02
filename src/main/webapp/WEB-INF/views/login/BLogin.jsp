<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>會員登入</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
	<h3>會員登入</h3>

	<form action="../bmember/login" method="post">
		<p>帳號: </p>
		<input type="text" name="account"></input>
		<br>
		<p>密碼: </p>
		<input type="password" name="password"></input>
		<br>
		<input type="submit" value="登入">
	
	<a href="<c:url value='/'/> ">回首頁</a>
	</form>
	</div>
	</div>
	
</body>
</html>