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
<title>customerMealsOrdered</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div id="container">
		<h2>${customer.chinese_name}，這是您的訂位資訊</h2><hr/>
		<p>姓名: ${odd.customer.chinese_name}</p>
		<p>手機: ${odd.customer.mobile_phone}</p>
		<p>人數: ${odd.orderedToMeals.number_of_meals}</p>
		<p>用餐日期: ${odd.orderedToMeals.meals_ordered_time}</p>
		<a href="<c:url value='insertMealsOd'/> ">回訂餐</a>
		<a href="<c:url value='/'/> ">回官網</a>
		
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>