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
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
		<h2>新增成功</h2><hr/>
		<h3>這是${odd.customer.chinese_name}的訂單</h3>
		<p>姓名: ${odd.customer.chinese_name}</p>
		<p>手機: ${odd.customer.mobile_phone}</p>
		<p>人數: ${odd.orderedToMeals.mealsnum_of_people}</p>
		<p>用餐日期: ${odd.orderedToMeals.mdate.mdate}</p>
		<p>用餐時段: ${odd.orderedToMeals.mdate.time_period }</p><br>
		<input type="button" value="回新增" onclick="location.href='http://localhost:8080/YunHotel/ordered/insertIndex'" >
<%-- 		<a href="<c:url value='insertMealsOd'/> ">回新增</a> --%>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>