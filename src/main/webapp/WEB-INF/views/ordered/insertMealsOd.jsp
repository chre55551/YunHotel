<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertMealsOrdered</title>
</head>
<body>
	<div>
		<h3>新增餐點訂單</h3>

		<table >
				<tr>
					<td>姓名</td>
						<td><input name ="chinese_name" id="requestCn" /></td>
				</tr>
				<tr>
					<td>手機</td>
						<td><input name ="mobile_phone" id="requestMp" /></td>
				</tr>
				<tr>
					<td>人數</td>
					<td><input name ="number_of_meals" id="requestNom" /></td>
				</tr>
				<tr>
					<td>用餐時間</td>
					<td><input name ="meals_ordered_time" id="requestMot" /></td>
				</tr>
		</table>
			<button name="insertOrderedCheck" id="insertOd">新增</button> 
			<a href="<c:url value='index'/> ">返回</a>

	</div>
	<script type="text/javascript">

	$("#insertOd").click(function() {
		$("Odxx").submit();
		var atr = $("#odd").serialize();
		$.ajax({
			url : '/insertOrderedCheck',
			async : false,
			type : 'POST',
			datatype : "json",
			
			data : atr,
			success : function(data) {
				alert()
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