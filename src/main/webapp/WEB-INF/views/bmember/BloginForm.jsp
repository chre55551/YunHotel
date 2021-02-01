<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>GetaBmember</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	 <div class="right">
        <p class="title">登入失敗</p>
        <p class="hr"></p>
        <br> <input class="ormBtn" type="button" value="回登入"
				onclick="location.href='http://localhost:8080/YunHotel/bmember/BLogin'">
	</div>
</body>
</html>