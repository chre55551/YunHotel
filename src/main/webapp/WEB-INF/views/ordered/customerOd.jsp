<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerOrdered</title>
</head>
<body>
	<h3>${odd.customer.chinese_name}的訂單</h3>
	<p>姓名: ${odd.customer.chinese_name}</p>
	<p>手機: ${odd.customer.mobile_phone}</p>
	<p>人數: ${odd.customer.number_of_meals}</p>
	<p>用餐日期: ${odd.customer.meals_ordered_time}</p>
</body>
</html>