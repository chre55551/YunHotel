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
<title>customerRoomOrdered</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
		<h2>新增成功</h2><hr/>
		<!-- odd是insertRoomOrdered裡面的值 第二個bean的名要對應bean裡面她屬性設的名子，第三個就是對應裡面的名子-->
		<h3>這是${odd.customer.chinese_name}的訂單</h3>
		<p>姓名: ${odd.customer.chinese_name}</p>
		<p>身分證: ${odd.customer.idcard_number}</p>
		<p>手機: ${odd.customer.mobile_phone}</p>
		<p>生日: ${odd.customer.birthday}</p>
		<p>地址: ${odd.customer.address}</p>
		<p>房號: ${roomname}</p>
		<p>
		<c:forEach var="rdate"   items="${rdates}" >
		訂房日期: ${rdate.rdate}  
		</c:forEach>
		</p><br>
		<input type="button" value="回新增" onclick="location.href='insertMealsOd'" >
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>