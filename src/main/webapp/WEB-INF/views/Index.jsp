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
			<div class="dateline">
				<div class="dateline2">
				<div class="D1">
					<p class="dateF">入住:</p>
					<br>
					<!-- readonly:不讓使用者自行輸入日期 -->
					<input type="text" id="from" class="datepicker from" readonly>
					<img class="datepic" src="image/date1.png">
				</div>

				<div class="D1">
					<p class="dateF">退房:</p>
					<br> <input type="text" id="to" class="to datepicker" readonly>
					<img class="datepic" src="image/date1.png">
				</div>
				<div class="D1 ORbtnposition">
					<button class="ORbtn"
						onclick="location.href='ordered/outsideInsertRoomOd'">
						<p>馬上訂房</p>
					</button>
				</div>
			</div>

<!-- 			<iframe -->
<!-- 				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7229.995031787542!2d121.53984541484618!3d25.034158368927347!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442abd3791a7bff%3A0xff4346aca2916a6!2zMTA25Y-w5YyX5biC5aSn5a6J5Y2A5b6p6IiI5Y2X6Lev5LiA5q61Mzkw6Jmf6Jmf!5e0!3m2!1szh-TW!2stw!4v1611547527726!5m2!1szh-TW!2stw" -->
<!-- 				width="600" height="450" frameborder="0" style="border: 0;" -->
<!-- 				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>	 -->	
		</div>
	
	
 
	<%@ include file="CommonTemplates/Indexfloat.jsp"%>
	
	</div>

	<%@ include file="CommonTemplates/footer.jsp"%>

	<script src="js/plugin/jquery-3.5.1.min.js"></script>
	<script src="js/plugin/jquery-ui.js"></script>
	<script>	
//隨捲軸移動訂位===============================================================		
		$(function() {
			var $win = $(window),
			$ad = $('.abgne_float').css('opacity', 0).show(),	// 讓廣告區塊變透明且顯示出來
			_width = $ad.width(),
			_height = $ad.height(),
			_diffY = 20, _diffX = 20,	// 距離右及下方邊距
			_moveSpeed = 650;	// 移動的速度
	 
		// 先把 #abgne_float_ad 移動到定點
		$ad.css({
			top: $(document).height(),
			left: $win.width() - _width - _diffX,
			opacity: 1
		});
	 
		// 幫網頁加上 scroll 及 resize 事件
		$win.bind('scroll resize', function(){
			var $this = $(this);
	 
			// 控制 #abgne_float_ad 的移動
			$ad.stop().animate({
				top: $this.scrollTop() + $this.height() - _height - _diffY,
				left: $this.scrollLeft() + $this.width() - _width - _diffX
			}, _moveSpeed);
		}).scroll();	// 觸發一次 scroll()
		
//訂房日歷===============================================================			
			
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