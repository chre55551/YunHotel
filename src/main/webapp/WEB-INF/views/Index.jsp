<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<title>澐YunHotel酒店.首頁</title>
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

	<header>
		<ul>
			<li><img class="logo" src="image/logo.png"></li>
			<li>&emsp;&emsp;&emsp;&emsp;</li>
			<li><a href="#">關於我們</a></li>
			<li><a href="showNews">最新消息</a></li>
			<li><a href="room/RoomIntroduction">房型介紹</a></li>
			<li><a href="meals/Delicious">美食佳餚</a></li>
			<li><a href="#">其他設施</a></li>
			<li><a href="ordered/outsideInsertMealsOd">訂位</a></li>
		</ul>
	</header>

	<div class="main">
		<div class="container">
			<div class="dateline">
				<div class="D1">
					<p class="dateF">入住:</p>
					<br>
					<!-- readonly:不讓使用者自行輸入日期 -->
					<input type="text" id="from" class="datepicker from" readonly>
					<img class="datepic" src="image/date1.png">
					<button></button>
				</div>

				<div class="D1">
					<p class="dateF">退房:</p>
					<br> <input type="text" id="to" class="to datepicker" readonly>
					<img class="datepic" src="image/date1.png">
					<button></button>
				</div>
				<div>
					<input value="馬上訂房" type="button"
						onclick="location.href='ordered/outsideInsertRoomOd'">
				</div>
			</div>

<!-- 			<iframe -->
<!-- 				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7229.995031787542!2d121.53984541484618!3d25.034158368927347!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442abd3791a7bff%3A0xff4346aca2916a6!2zMTA25Y-w5YyX5biC5aSn5a6J5Y2A5b6p6IiI5Y2X6Lev5LiA5q61Mzkw6Jmf6Jmf!5e0!3m2!1szh-TW!2stw!4v1611547527726!5m2!1szh-TW!2stw" -->
<!-- 				width="600" height="450" frameborder="0" style="border: 0;" -->
<!-- 				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>	 -->	
</div>
	</div>



	<div class="footer">
		<p>© The Hotel. All Rights Reserved.</p>
	</div>


	<script src="js/plugin/jquery-3.5.1.min.js"></script>
	<script src="js/plugin/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#from").datepicker(
					{
						changeMonth : true, //顯示月份列表供選擇
						firstDay : 1, //星期一開始
						minDate : 0, //最小日期只能選今天
						dateFormat : "yy-mm-dd",
						onClose : function(selectedDate) {
							$('#to').datepicker('option', 'minDate',
									new Date(selectedDate).addDays(1));
						}
					});

			function addDays(date, days) {
				var dat = date;
				dat.setDate(dat.getDate() + days);
				return dat;
			}

			$("#to").datepicker({

				changeMonth : true,
				firstDay : 1,
				minDate : "+1", //最小日期只能選隔天(退房)
				dateFormat : "yy-mm-dd",
				onClose : function(selectedDate) {
					$("#from").datepicker("option", "maxDate", selectedDate);
				}
			});
		});
	</script>

</body>
</html>