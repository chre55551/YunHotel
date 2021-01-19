<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>InsertOrdered</title>
<style type="text/css">
#bg{
background-color:#C4E1FF
}

</style>
</head>
<body>
<div>
	<h3>新增訂單</h3>
<!-- 	<a href='ThisOrdred'>新增訂單資料</a> &nbsp;&nbsp;&nbsp; -->
	<button id="insertOd">新增訂單資料</button>
	<a href="<c:url value='index'/> ">返回</a>
	<table>
		<form:form action="insertOrdred" method="get" modelAttribute="odd" id="Odxx">
			<tr>
				<td>訂單編號</td>
				<td><form:input path="ordered_number" id="requestOn"/></td>
<%-- 				<td><form:errors path="ordered_number" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>顧客編號</td>
				<td><form:input path="customer_id" id="requestCi"/></td>
<%-- 				<td><form:errors path="customer_id" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>餐點訂單編號</td>
				<td><form:input path="ordered_tomeals_id" id="requestOtmi"/></td>
<%-- 				<td><form:errors path="ordered_tomeals_id" --%>
<!-- 						cssStyle="color: red;" /></td> -->
			</tr>
			<tr>
				<td>房間訂單編號</td>
				<td><form:input path="ordered_toroom_id" id="requestOtri"/></td>
<%-- 				<td><form:errors path="ordered_toroom_id" --%>
<!-- 						cssStyle="color: red;" /></td> -->
			</tr>
			<tr>
				<td>訂單狀態</td>
				<td><form:select path="status_id" id="requestSi">
					<form:option value="1">未付款</form:option>
					<form:option value="2">已付訂</form:option>
					<form:option value="3">已結清</form:option>
					<form:option value="4">已取消</form:option>
					</form:select>
				</td>
<%-- 				<td><form:errors path="status_id" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>付款方式</td>
				<td><form:select path="payment_id" id="requestPi">
				<form:option value="1">現金</form:option>
				<form:option value="2">信用卡</form:option>
				</form:select>
				</td>
<%-- 				<td><form:errors path="payment_id" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>訂單總價</td>
				<td><form:input path="ordered_accounts" id="requestOa"/></td>
<%-- 				<td><form:errors path="ordered_accounts" cssStyle="color: red;" /></td> --%>
				
			</tr>
			<tr>
				<td>訂單日期</td>
				<td><form:input path="ordered_date" type="date" id="requestOd"/></td>
<%-- 				<td><form:errors path="ordered_date" cssStyle="color: red;" /></td> --%>
				
			</tr>
			<tr>
				<td>備註</td>
				<td><form:input path="note" id="requestNote"/></td>
<%-- 				<td><form:errors path="note" cssStyle="color: red;" /></td> --%>
			</tr>
		</form:form>
	</table>
	</div>
	
	<script type="text/javascript">
	
	$("#insertOd").click(function() {
		$("Odxx").submit();
		var atr = $("#odd").serialize();
		$.ajax({
			url : '/???',
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