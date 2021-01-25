<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>您好，${customer.chinese_name}，想訂哪間房?</h3>
		<form action="/YunHotel/ordered/insertRoomOrdered" method="POST"
			class="container">
			<div>
				<label>房型</label> <input name="room_type" /> 
<!-- 				從ordered到ordered_toroom到room再到room_type的bean裡取 -->
			</div>
			<div>
				<label>訂房日期</label> <input name="room_ordered_time" type="date" />
			</div>
			<div>
				<input value="新增" type="submit"> 
				<input value="清除" type="reset">
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>