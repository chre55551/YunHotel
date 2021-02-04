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
			<div class="rg">
			<p class="rgF">註冊帳號</p>
				<form action="/YunHotel/customer/registerOK" method="POST">
					<div class="rgtxt">帳號:
					<input type="text" name="account" id="theAccount"></div>
					<div class="rgtxt">密碼:
					<input type="password" name="password" id="thePwd"></input></div>
					
					<div class="rgtxt">性別:<select name="gender" id="theGender">
							<option value="0">請選擇</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select></div>
					<div class="rgtxt">家裡電話:
					<input type="text" name="home_phone" id="theHphone"></input> </div>
					<div class="rgtxt">手機電話:
					<input type="text" name="mobile_phone" id="theMphone"></input> </div>
					<div class="rgtxt">工作:
					<input type="text" name="job" id="theJob"></input> </div>
					<div class="rgtxt">電子信箱:
					<input type="text" name="email" id="theEmail"></input> </div>
					<div class="rgtxt">真實姓名:
					<input type="text" name="chinese_name" id="theName"></input> </div>
					<div class="rgtxt">身分證字號:
					<input type="text" name="idcard_number" id="theCard"></input> </div>
					<div class="rgtxt">生日:
					<input type="date" name="birthday" id="theDate"></input></div> 
					<div class="rgtxt">地址:
					<input type="text" name="address" id="theAddress"></input> </div>
					<input class="ormBtn" type="submit" value="註冊"  style="margin-top:40px;"
						onclick="location.href='http://localhost:8080/YunHotel/YunPage'">
				</form>
					<button id="btn" style="display:none;"></button>
				</div>
		</div>
		<div style="width:100vw;height:200px;"></div>
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
											let defaultAccount = "chris";
										let defaultPwd = "123456789";
										let defaultGender = "男";
										let defaultHphone = "2500000";
										let defaultMphone = "0911222332";
										let defaultJob = "工程師";
										let defaultEmail = "test2233@gmail.com";
										let defaultCard = "A123456788";
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



	<%@ include file="../CommonTemplates/footer.jsp"%>

</body>
</html>
