<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>請輸入結帳資訊</title>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<form action="/YunHotel/checkout/checkoutRoomOd" method="POST"
			class="container">
			<br>
			<div class="bormm">
				<label class="bormt">房號:</label> <input name="room_name" id="requestCn" class="bodsm"/>
			</div>
			<br>
			<div class="bormm">
				<label class="bormt">退房日期:</label> <input name="rdateEnd" id="requestMp" class="bodsm" 
					type="date" />
			</div>
			<br>
			<div>
				<input value="查詢" type="submit" class="bormb">
			</div>
		</form>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>