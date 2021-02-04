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
					<input type="text" name="account" id="theAccount">
					<p>密碼:</p>
					<input type="password" name="password" id="thePwd"></input><br>
					<div>
						性別: <select name="gender" id="theGender">
							<option value="0">請選擇</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
					<br>
					<p>家裡電話:</p>
					<input type="text" name="home_phone" id="theHphone"></input> <br>
					<p>手機電話:</p>
					<input type="text" name="mobile_phone" id="theMphone"></input> <br>
					<p>工作:</p>
					<input type="text" name="job" id="theJob"></input> <br>
					<p>電子信箱:</p>
					<input type="text" name="email" id="theEmail"></input> <br>
					<p>真實姓名:</p>
					<input type="text" name="chinese_name" id="theName"></input> <br>
					<p>身分證字號:</p>
					<input type="text" name="idcard_number" id="theCard"></input> <br>
					<p>生日:</p>
					<input type="date" name="birthday" id="theDate"></input> <br>
					<p>地址:</p>
					<input type="text" name="address" id="theAddress"></input> <br>
					<br> <input class="ormBtn" type="submit" value="註冊"
						onclick="location.href='http://localhost:8080/YunHotel/YunPage'">

				</form>
				<div>
					<button id="btn"></button>
				</div>

				<script>
					//抓與按鈕
					let myBtn = document.getElementById("btn");
					//設定點擊事件
					myBtn
							.addEventListener(
									"click",
									function() {
										//設定預先輸入的值
										let defaultAccount = "poky";
										let defaultPwd = "12345";
										let defaultGender = "男";
										let defaultHphone = "25010000";
										let defaultMphone = "0988-848-123";
										let defaultJob = "工程師";
										let defaultEmail = "test123@gmail.com";
										let defaultCard = "A123456765";
										let defaultDate = new Date().toISOString().slice(0,10);
										let defaultName = "大帥哥";
										let defaultAddress = "台北市大安區";

										//抓取目標input並填入值
										document.getElementById("theAccount").value = defaultAccount;
										document.getElementById("thePwd").value = defaultPwd;
										document.getElementById("theGender").value = defaultGender;
										document.getElementById("theHphone").value = defaultHphone;
										document.getElementById("theMphone").value = defaultMphone;
										document.getElementById("theJob").value = defaultJob;
										document.getElementById("theEmail").value = defaultEmail;
										document.getElementById("theCard").value = defaultCard;
										document.getElementById("theDate").value = defaultDate;
										document.getElementById("theName").value = defaultName;										
										document.getElementById("theAddress").value = defaultAddress;
									})

					//增加鍵盤敲擊事件
					document
							.addEventListener(
									"keydown",
									function(event) {
										if (event.key == "f") { //如果按下的鍵為f鍵
											//設定預先輸入的值
											let defaultAccount = "pocky";
										let defaultPwd = "12345678";
										let defaultGender = "男";
										let defaultHphone = "25010023";
										let defaultMphone = "0911333333";
										let defaultJob = "工程師";
										let defaultEmail = "test9@gmail.com";
										let defaultCard = "A125896740";
										let defaultDate = new Date("1996-03-21").toISOString().slice(0,10);
										let defaultName = "魏伯源"
										let defaultAddress = "新北市新莊區中正路";

											//抓取目標input並填入值
										document.getElementById("theAccount").value = defaultAccount;
										document.getElementById("thePwd").value = defaultPwd;
										document.getElementById("theGender").value = defaultGender;
										document.getElementById("theHphone").value = defaultHphone;
										document.getElementById("theMphone").value = defaultMphone;
										document.getElementById("theJob").value = defaultJob;
										document.getElementById("theEmail").value = defaultEmail;
										document.getElementById("theCard").value = defaultCard;
										document.getElementById("theDate").value = defaultDate;
										document.getElementById("theName").value = defaultName;										
										document.getElementById("theAddress").value = defaultAddress;
										}
									})
									
									document
							.addEventListener(
									"keydown",
									function(event) {
										if (event.key == "a") { //如果按下的鍵為a鍵
											//設定預先輸入的值
											let defaultAccount = "chriss";
										let defaultPwd = "123456789";
										let defaultGender = "男";
										let defaultHphone = "25098765";
										let defaultMphone = "0911222333";
										let defaultJob = "工程師";
										let defaultEmail = "test10@gmail.com";
										let defaultCard = "A145896777";
										let defaultDate = new Date("1996-06-21").toISOString().slice(0,10);
										let defaultName = "陳奕勳"
										let defaultAddress = "新北市新莊區中正路";

											//抓取目標input並填入值
										document.getElementById("theAccount").value = defaultAccount;
										document.getElementById("thePwd").value = defaultPwd;
										document.getElementById("theGender").value = defaultGender;
										document.getElementById("theHphone").value = defaultHphone;
										document.getElementById("theMphone").value = defaultMphone;
										document.getElementById("theJob").value = defaultJob;
										document.getElementById("theEmail").value = defaultEmail;
										document.getElementById("theCard").value = defaultCard;
										document.getElementById("theDate").value = defaultDate;
										document.getElementById("theName").value = defaultName;										
										document.getElementById("theAddress").value = defaultAddress;
										}
									})
				</script>


			</div>
		</div>
	</div>

</body>
</html>