<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<title>訂房</title>
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

	<div class="main">
		<br>

		<form action="/YunHotel/ordered/insertRoomOrdered" method="POST">
			<h3>您好，${customer.chinese_name}，想訂哪間房?</h3>
			<!-- 			<div> -->
			<!-- 				<label>姓名</label> <input name="chinese_name" /> -->
			<!-- 			</div> -->
			<!-- 			<div> -->
			<!-- 				<label>身分證</label> <input name="idcard_number" /> -->
			<!-- 			</div> -->
			<!-- 			<div> -->
			<!-- 				<label>手機</label> <input name="mobile_phone" /> -->
			<!-- 			</div> -->
			<!-- 			<div> -->
			<!-- 				<label>生日</label> <input name="birthday" type="date" /> -->
			<!-- 			</div> -->
			<!-- 			<div> -->
			<!-- 				<label>地址</label> <input name="address" /> -->
			<!-- 			</div> -->
			<div>
				<label>房型</label> <input name="room_type" />
			</div>
			<div>
				<label>備註</label> <input name="note" id="requestNote" />
			</div>

			<div>
				<input value="預訂" type="submit"> <input value="清除"
					type="reset">
			</div>
		</form>
	</div>
	<div>
	<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>