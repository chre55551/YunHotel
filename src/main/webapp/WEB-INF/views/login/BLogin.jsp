<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>
</head>
<body>
	<h3>會員登入</h3>
	<a href="<c:url value='/'/> ">回首頁</a>
	<form action="" method="post">
		<p>帳號: </p>
		<input type="text" name="account"></input>
		<br>
		<p>密碼: </p>
		<input type="text" name="password"></input>
		<br>
		<input type="submit" value="登入">
	
	
	</form>
</body>
</html>