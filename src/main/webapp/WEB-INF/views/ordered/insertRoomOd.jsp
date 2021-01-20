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
	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增房間訂單</h3>
		<form action="/YunHotel/ordered/insertRoomOrdered" method="POST"
			id="container">
			<div>
				<label>姓名</label> <input name="chinese_name" />
			</div>
			<div>
				<label>身分證</label> <input name="idcard_number" />
			</div>
			<div>
				<label>手機</label> <input name="mobile_phone" />
			</div>
			<div>
				<label>生日</label> <input name="birthday" type="date" />
			</div>
			<div>
				<label>地址</label> <input name="address" />
			</div>
			<div>
				<label>房號</label> <input name="room_number" />
			</div>
			<div>
				<label>訂房日期</label> <input name="room_ordered_time" type="date" />
			</div>
			<div>
				<input value="新增" type="submit"> 
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>