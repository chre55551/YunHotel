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
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>customerRoomOrdered</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<%@ include file="../CommonTemplates/Indexheader.jsp"%>
	<div class="ckeckinBG">
		<div class="main">
			<div class="orm3">
				<!-- odd是insertRoomOrdered裡面的值 第二個bean的名要對應bean裡面她屬性設的名子，第三個就是對應裡面的名子-->
				<h4 class="ormt2">${odd.customer.chinese_name}這是您的訂房資訊</h4>
				<p class="ormt2">姓名: ${odd.customer.chinese_name}</p>
				<p class="ormt2">身分證: ${odd.customer.idcard_number}</p>
				<p class="ormt2">手機: ${odd.customer.mobile_phone}</p>
				<p class="ormt2">生日: ${odd.customer.birthday}</p>
				<p class="ormt2">地址: ${odd.customer.address}</p>
				<p> class="ormt2"房號: ${roomname}</p>
				<p class="ormt2">訂房日期: ${rdate}</p>
				<br> <input type="button" value="回官網"
					onclick="location.href='http://localhost:8080/YunHotel/YunPage'">
			</div>
		</div>
	</div>
	<div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>