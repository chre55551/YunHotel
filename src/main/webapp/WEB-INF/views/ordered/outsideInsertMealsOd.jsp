<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>insertMealsOrdered</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div id="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>${customer.chinese_name}，請輸入您的訂位資訊</h3>
		<form action="/YunHotel/ordered/insertMealsOrdered" method="POST" id="container">
			<div>
				<label>人數</label> <input name="number_of_meals" id="requestMp" />
			</div>
			<div>
				<label>用餐日期</label> <input name="meals_ordered_time" id="requestMp"
					type="date" />
			</div>
			<div>
				<input value="訂位" type="submit">
				<input value="清除" type="reset">
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