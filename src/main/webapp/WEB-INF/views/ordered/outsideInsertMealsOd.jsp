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
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>訂位</title>
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
		<div class="orm">
			<form action="/YunHotel/ordered/insertMealsOrdered" method="POST">
				<div class="ormt">
					<h4>請輸入訂位的時間</h4>
				</div>
				<!-- 			<div> -->
				<!-- 				<label>姓名</label> <input name="chinese_name" id="requestCn" /> -->
				<!-- 			</div> -->
				<!-- 			<div> -->
				<!-- 				<label>手機</label> <input name="mobile_phone" id="requestMp" /> -->
				<!-- 			</div> -->
				<!-- 			<div> -->
				<!-- 				<label>人數</label> <input name="mealsnum_of_people" id="requestMp" /> -->
				<!-- 			</div> -->
				<div class="ormt">
					<label>用餐日期:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input name="mdate" id="requestMp" type="date" />
				</div>
				<div class="ormt">
					<label>用餐時段:</label>&nbsp;&nbsp;&nbsp;&nbsp;<select name="time_period">
						<option value="11:00~13:00">上午十一點</option>
						<option value="13:00~15:00">下午一點</option>
						<option value="15:00~17:00">下午三點</option>
						<option value="17:00~19:00">下午五點</option>
						<option value="19:00~21:00">晚上七點</option>
					</select>
				</div>
				<div class="ormt">
					<label>備註:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input name="note" id="requestNote" />
				</div>
				<div>
					<input value="預訂" type="submit" class="ormBtn"> <input value="清除"
						type="reset" class="ormBtn">
				</div>
			</form>
		</div>
	<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
	
	
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
	});
	</script>
</body>
</html>