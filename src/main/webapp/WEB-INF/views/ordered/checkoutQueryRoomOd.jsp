<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<table class="mytable container" id="container">
			<%@ include file="../CommonTemplates/leftmenu.jsp"%>
			<tr>
				<th>房號:</th>
				<td><input id="room_name" type="text"></td>
				<th>退房日期</th>
				<td><input id="rdateEnd" type="date"></td>
				<td>
					<div class="mycenter">
						<button id="peko" onclick="window.location.href='checkoutRoomOd'">查詢</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>