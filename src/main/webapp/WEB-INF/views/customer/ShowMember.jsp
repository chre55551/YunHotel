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
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/customer.css'
	type="text/css" />
<title>顯示所有會員</title>
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
	<div class="steakbb">
		<div class="main">
			<br>
			<div class="orm">

			<p>帳號: ${rcm.account}</p>
			<p>密碼: ${rcm.password}</p>
			<p>性別: ${rcm.gender}</p>
			<p>家裡電話: ${rcm.home_phone}</p>
			<p>手機電話: ${rcc.mobile_phone}</p>
			<p>工作: ${rcm.job}</p>
			<p>信箱: ${rcm.email}</p>
			<p>真實姓名: ${rcc.chinese_name}</p>
			<p>身分證字號: ${rcc.idcard_number}</p>
			<p>生日: ${rcc.birthday}</p>
			<p>地址: ${rcc.address}</p>
			
			<br> <input class="ormBtn" type="button" value="回官網" 	onclick="location.href='http://localhost:8080/YunHotel/YunPage'">
			<br> <input class="ormBtn" type="button" value="修改" 	onclick="location.href='http://localhost:8080/YunHotel/customer/UpdateMember'">
		</div>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>