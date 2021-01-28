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
<title>customerMealsOrdered</title>
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

	<div class="steakBG">
		<div class="main">
			<div class="orm2">
				<h4 class="ormt2">${ct.chinese_name}，這是您的訂位資訊</h4>
				<p class="ormt2">姓名: ${ct.chinese_name}</p>
				<p class="ormt2">手機: ${ct.mobile_phone}</p>
				<p class="ormt2">人數: ${odd.orderedToMeals.mealsnum_of_people}</p>
				<p class="ormt2">用餐日期: ${odd.orderedToMeals.mdate.mdate}</p>
				<p class="ormt2">用餐時段: ${odd.orderedToMeals.mdate.time_period }</p>
				<br> <input class="ormBtn" type="button" value="回官網" 	onclick="location.href='http://localhost:8080/YunHotel/YunPage'">
			</div>
		</div>
	</div>
	<div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>