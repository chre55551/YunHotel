<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<title>insertMealsOrdered</title>
</head>
<body>
	<div>
		<h3>新增餐點訂單</h3>

		<table id="odd">
			<tr>
				<td>姓名</td>
				<td><input name="chinese_name" id="requestCn" /></td>
			</tr>
			<tr>
				<td>手機</td>
				<td><input name="mobile_phone" id="requestMp" /></td>
			</tr>
			<tr>
				<td>人數</td>
				<td><input name="number_of_meals" id="requestNom" /></td>
			</tr>
			<tr>
				<td>用餐時間</td>
				<td><input name="meals_ordered_time" id="requestMot" /></td>
			</tr>
		</table>
		<button name="insertMealsOrdered" id="insertOd">新增</button>
		<a href="<c:url value='indexOrdered'/> ">返回</a>

	</div>
	<script type="text/javascript">
		$("#insertOd").click(function() {
// 			 o=$("#odd input");
// 			 o.each(function(X,item){console.log(item.value)})
// 			 var atr = o.each(function(X,item){item.value})
			 
// 			 var btr = {
// 				 chinese_name:atr[0],
// 				 mobile_phone:atr[1],
// 				 number_of_meals:atr[2],
// 				 meals_ordered_time:atr[3]
// 			 }

			$.ajax({
				type : 'POST',
				data : {chinese_name : $("#requestCn").val(),
					 mobile_phone : $("#requestMp").val(),
					 number_of_meals : $("#requestNom").val(),
					 meals_ordered_time : $("#requestMot").val()},
				url : '/YunHotel/ordered/insertMealsOrdered',
				dataType : "json",
				success : function() {
					alert("新增成功");
				}
			})
		})
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