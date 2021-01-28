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
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>顯示會員</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>


	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">

			<p>帳號: ${rcc.account}</p>
			<p>密碼: ${rcc.password}</p>
			<p>性別: ${rcc.gender}</p>
			<p>家裡電話: ${rcc.home_phone}</p>
			<p>手機電話: ${rcc.mobile_phone}</p>
			<p>工作: ${rcc.job}</p>
			<p>信箱: ${rcc.email}</p>
			<p>密碼: ${rcc.password}</p>
			<p>信箱: ${rcc.email}</p>
			<p>真實姓名: ${rcc.chinese_name}</p>
			<p>身分證字號: ${rcc.idcard_number}</p>
			<p>生日: ${rcc.birthday}</p>
			<p>地址: ${rcc.address}</p>
			<a href="<c:url value='IndexMember'/> ">回上一頁</a>
		</div>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>