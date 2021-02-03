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
	<div class="steakBG">
		<div class="main">
			<br>
			<div class="orm">
				<form action="/YunHotel/ordered/outsideCustomerMealsOd" method="POST">
					<div>
						<h4 class="ormt">請輸入訂位的時間</h4>
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
						<label>用餐日期:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input name="mdate"
							id="requestMp" type="date" class="odsm" />
					</div>

					<div class="ormt">
						<label>用餐時段:</label>&nbsp;&nbsp;&nbsp;&nbsp;<select
							name="time_period" class="odsm" style="width: 120px">
							<option value="11:00~13:00">上午十一點</option>
							<option value="13:00~15:00">下午一點</option>
							<option value="15:00~17:00">下午三點</option>
							<option value="17:00~19:00">下午五點</option>
							<option value="19:00~21:00">晚上七點</option>
						</select>
					</div>

					<div class="ormt">
						<label>用餐人數:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input
							name="mealsnum_of_people" id="requestMop" type="text"
							class="odsm" style="width: 120px"/>
					</div>

					<div class="ormt">
						<label>備註:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="note"
							id="requestNote" class="odsm" style="width: 140px"/>
					</div>
					<div>
						<input value="預訂" type="submit" class="ormBtn"> <input
							value="清除" type="reset" class="ormBtn">
					</div>
				</form>
			</div>
			<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
		</div>
		<%@ include file="../CommonTemplates/footer.jsp"%>
	</div>

	<script
		src="${pageContext.request.contextPath}/js/Yun_js/SharedFunctions.js">
		</script>
		
		<script type="text/javascript">
		
		//增加鍵盤敲擊事件
		document
				.addEventListener(
						"keydown",
						function(event) {
							if (event.key == "f") { //如果按下的鍵為f鍵
								//設定預先輸入的值
								let defaultpeople = "4";
								let defaultnote = "一位鍋邊素";
								//抓取目標input並填入值
								document.getElementById("requestMop").value = defaultpeople;
								document.getElementById("requestNote").value = defaultnote;
							}
						})
		
		</script>

</body>
</html>