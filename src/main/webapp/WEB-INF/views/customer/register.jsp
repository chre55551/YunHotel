<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/register.css'
	type="text/css" />
<title>註冊</title>
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
	<div class="steakRR">
		<div class="main">
			<br>
			<div class="orm">
				<h3>註冊帳號</h3>
				<div class="container">

					<form action="/YunHotel/customer/Login" method="POST"
						class="container">
						<p>帳號:</p>
						<input type="text" name="account"></input> <br>
						<p>密碼:</p>
						<input type="password" name="password"></input> <br>
						<p>性別:</p>
						<input type="text" name="gender"></input> <br>
						<p>家裡電話:</p>
						<input type="text" name="home_phone"></input> <br>
						<p>手機電話:</p>
						<input type="text" name="mobile_phone"></input> <br>
						<p>工作:</p>
						<input type="text" name="job"></input> <br>
						<p>電子信箱:</p>
						<input type="text" name="email"></input> <br>
						<p>真實姓名:</p>
						<input type="text" name="chinese_name"></input> <br>
						<p>身分證字號:</p>
						<input type="text" name="idcard_number"></input> <br>
						<p>生日:</p>
						<input type="date" name="birthday"></input> <br>
						<p>地址:</p>
						<input type="text" name="address"></input> <br> <input
							type="submit" value="註冊">
						<div>
							<a href="http://localhost:8080/YunHotel/YunPage" />回首頁</a>
						</div>
					</form>



				</div>
</body>
</html>