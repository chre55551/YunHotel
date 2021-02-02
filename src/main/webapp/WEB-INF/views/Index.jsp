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

	<%@ include file="CommonTemplates/Indexheader.jsp"%>

<div class="main">
	<div class="first">
	<div class="firstDark">
	
		<img class="title" src="image/headertitle.png">
	
		<div class="dateline">
			<div class="dateline2">
			<form action="http://localhost:8080/YunHotel/ordered/outsideInsertRoomOd">
				<div class="D1">
					<p class="dateF">入住:</p>
					<br>
					<!-- readonly:不讓使用者自行輸入日期 -->
					<input name="rdate" type="date" id="from" class="datepicker"/>
<!-- 					<img class="datepic" src="image/date1.png"> -->
				</div>

				<div class="D1">
					<p class="dateF">退房:</p>
					<br> <input name="rdateEnd" type="date" id="to" class="datepicker"/>
<!-- 					<img class="datepic" src="image/date1.png"> -->
				</div>
				
				<div class="D1 ORbtnposition">
					<button class="ORbtn" type="submit">
						<p>馬上訂房</p>
					</button>
				</div>
			</form>
				
			</div>
		</div>
	</div>
	</div>
<!-- 			<iframe -->
<!-- 				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7229.995031787542!2d121.53984541484618!3d25.034158368927347!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442abd3791a7bff%3A0xff4346aca2916a6!2zMTA25Y-w5YyX5biC5aSn5a6J5Y2A5b6p6IiI5Y2X6Lev5LiA5q61Mzkw6Jmf6Jmf!5e0!3m2!1szh-TW!2stw!4v1611547527726!5m2!1szh-TW!2stw" -->
<!-- 				width="600" height="450" frameborder="0" style="border: 0;" -->
<!-- 				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>	 -->	
		
	
	<div class="middle">
		<div class="middlepos">
			<p class="middleF">澐Hotel</p>
			<p class="middleF_introduce">
			一個簡約又不失高雅的旅遊好去處，在繁忙的生活中，提供您閑靜愜意的環境，
			遠離都市的塵囂，讓身心靈好好地充個電，望向藍天大海，享受著大自然帶來的寧靜，
			讓來到這裡的每一個人有回到家的感覺，放鬆心情，享受旅遊，就在澐Hotel。
			</p>
		</div>
	</div>
	
		
	<div class="third">
		<div class="room_intro_div">
			<div class="room_introduce">
				<div class="thirdDark_left">
				<a href="room/RoomIntroduction">
					<p class="thirdF_left">房 型 介 紹</p>
					<p class="thirdmin">查看更多</p>
				</a>
				</div>
			</div>
		</div>
		
		<div class="food_intro_div">
			<div class="food_introduce">
				<div class="thirdDark_right">
				<a href="meals2/Delicious">
					<p class="thirdF_right">美 食 饗 宴</p>
					<p class="thirdmin">查看更多</p>
				</a>
				</div>
			</div>
		</div>
		
		<div class="spa_intro_div">
			<div class="spa_introduce">
				<div class="thirdDark_right">
				<a href="OtherFacilities">
					<p class="thirdF_right">S P A</p>
					<p class="thirdmin">查看更多</p>
				</a>
				</div>
			</div>
		</div>
		
	</div>
	
 
	<%@ include file="CommonTemplates/Indexfloat.jsp"%>
	
</div>

	<%@ include file="CommonTemplates/footer.jsp"%>

	<script src="js/plugin/jquery-3.5.1.min.js"></script>
	<script src="js/plugin/jquery-ui.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/Yun_js/SharedFunctions.js"></script>

	<script>	
//訂房日歷===============================================================			
			 $( "#from" ).datepicker({
			      firstDay : 1, //星期一開始
			      changeMonth: true,
			      minDate : 0, //最小日期只能選今天
			      dateFormat : "yy-mm-dd"
			      onClose: function( selectedDate ) {
			        $( "#to" ).datepicker( "minDate", selectedDate );
			      }
			    });


			function addDays(date, days) {
				var dat = date;
				dat.setDate(dat.getDate() + days);
				return dat;
			}

		    $( "#to" ).datepicker({
		    	firstDay : 1, //星期一開始
		        changeMonth: true,
				minDate : "+1", //最小日期只能選隔天(退房)
				dateFormat : "yy-mm-dd",
		        onClose: function( selectedDate ) {
		          $( "#from" ).datepicker( "option", "maxDate", selectedDate );
		        }
		      });
		});
	</script>

</body>
</html>