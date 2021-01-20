<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<title>customerOrdered</title>
</head>
<body>
	<h3>${odd.customer.chinese_name}的訂單</h3>
	<p>姓名: ${odd.customer.chinese_name}</p>
	<p>手機: ${odd.customer.mobile_phone}</p>
	<p>人數: ${odd.orderedToMeals.number_of_meals}</p>
	<p>用餐日期: ${odd.orderedToMeals.meals_ordered_time}</p>
</body>
</html>