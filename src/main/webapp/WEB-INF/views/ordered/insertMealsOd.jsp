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
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>insertMealsOrdered</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>


	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增餐點訂單</h3>
		<form action="/YunHotel/ordered/insertMealsOrdered" method="POST"
			class="container">
			<div class="bormm">
				<label class="bormt">姓名: </label> <input name="chinese_name" id="requestCn" class="bodsm"/>
			</div>
			<div class="bormm">
				<label class="bormt">手機: </label> <input name="mobile_phone" id="requestMp" class="bodsm"/>
			</div>
			<div class="bormm">
				<label class="bormt">人數: </label> <input name="mealsnum_of_people" id="requestMp" class="bodsm"/>
			</div>
			<div class="bormm">
				<label class="bormt">用餐日期: </label> <input name="mdate" id="requestMp"
					type="date" class="bodsm"/>
			</div>
			<div class="bormm">
				<label class="bormt">用餐時段: </label> <select name="time_period" class="bodsm">
					<option disabled="disabled">請選擇用餐時段</option>
					<option value="11:00~13:00">11:00~13:00</option>
					<option value="13:00~15:00">13:00~15:00</option>
					<option value="15:00~17:00">15:00~17:00</option>
					<option value="17:00~19:00">17:00~19:00</option>
					<option value="19:00~21:00">19:00~21:00</option>
				</select>
			</div>
			<div class="bormm">
				<label class="bormt">備註: </label> <input name="note" id="requestNote" class="bodsm"/>
			</div>
			<br>
			<div class="bormm">
				<input value="新增" type="submit" class="bormb" style="margin-right: 20px">
				<input value="清除" type="reset" class="bormb">
				<%-- <a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">
		// 		$("#insertOd").click(function() {
		// 			 o=$("#odd input");
		// 			 o.each(function(X,item){console.log(item.value)})
		// 			 var atr = o.each(function(X,item){item.value})

		// 			 var btr = {
		// 				 chinese_name:atr[0],
		// 				 mobile_phone:atr[1],
		// 				 number_of_meals:atr[2],
		// 				 meals_ordered_time:atr[3]
		// 			 }

		//當初寫新增的ajax
		// 			$.ajax({
		// 				type : 'POST',
		// 				data : {chinese_name : $("#requestCn").val(),
		// 					 mobile_phone : $("#requestMp").val(),
		// 					 number_of_meals : $("#requestNom").val(),
		// 					 meals_ordered_time : $("#requestMot").val()},
		// 				url : '/YunHotel/ordered/insertMealsOrdered',
		// 				dataType : "json",
		// 				success : function() {
		// 					alert("新增成功");
		// 				}
		// 			})
		// 		})

		// 		document.getElementById("insertOd").addEventListener("click",
		// 				function() {
		// 					let QQQ = document.getElementById("Odxx").serialize();
		// 					let myQuery = new URLSearchParams({
		// 						ordered_number : document.getElementById("requestOn").value,
		// 						customer_id : document.getElementById("requestCi").value,
		// 						ordered_tomeals_id : document.getElementById("requestOtmi").value,
		// 						ordered_toroom_id : document.getElementById("requestOtri").value,
		// 						status_id : document.getElementById("requestSi").value,
		// 						payment_id : document.getElementById("requestPi").value,
		// 						ordered_accounts : document.getElementById("requestOa").value,
		// 						ordered_date : document.getElementById("requestOd").value,
		// 						iv_no : document.getElementById("requestIn").value,
		// 						note : document.getElementById("requestNote").value
		// 					})
		// 					console.log(myQuery.toString());

		// 					fetch("/insertOrderedCheck".{
		// 						method : "POST",
		// 						body : myQuery
		// 					}).then(function(response){
		// 						return response.text();
		// 					}).then(function(data) {
		// 						document.getElementById("requestOn").innerHTML = data;
		// 					})
		// 		});
	</script>
</body>
</html>