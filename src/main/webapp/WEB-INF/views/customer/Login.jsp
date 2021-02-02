<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/customer.css'
	type="text/css" />
<title>登入</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


	<%@ include file="../CommonTemplates/Indexheader.jsp"%>
	<div class="steakbb">
		<div class="main">
			<br>
			<div class="orm">
				<form action="../customer/login" method="post">
					<p>帳號:</p>
					<input type="text" name="account"></input> <br>
					<p>密碼:</p>
					<input type="password" name="password"></input> <br> <input
						type="submit" value="登入"> <a href="register" type="submit"
						class="diamondtxt">新增會員</a> <a
						href="<c:url value='http://localhost:8080/YunHotel/YunPage'/> ">回首頁</a>
				</form>

			</div>
		</div>
	</div>
</body>
</html>