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

			<h3>註冊帳號</h3>
			<div class="container">

				<form action="/YunHotel/customer/registerOK" method="POST"
					class="container">
					<p>帳號:</p>
					<input type="text" name="account" id="account" autocomplete="off" placeholder="請輸入姓名">
					<span id="acccheck">此欄位必須輸入</span>
					<br>
					<p>(不可空白,至少兩個字且必須為中文字)</p>
					<p>密碼:</p>
					<input type="password" name="password" id="np"></input> <br>
					
					性別：<br> <input type="radio" name="sex" value="male">男
					<input type="radio" name="sex" value="female">女
					<p>
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
					<input type="text" name="address"></input> <br> <br> <input
						class="ormBtn" type="submit" value="註冊"
						onclick="location.href='http://localhost:8080/YunHotel/YunPage'">

				</form>
				<script type="text/javascript">
					function btclick() {
						if (!((document.getElementById("np").value)
								.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,30}$/))) {
							alert("your password : "
									+ document.getElementById("np").value);
						}
					}
				</script>

			</div>
		</div>
	</div>

</body>
</html>