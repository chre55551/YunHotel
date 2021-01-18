<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertOrdered</title>
<style type="text/css">
#bg{
background-color:#C4E1FF
}

</style>
</head>
<body>
<div id="main">
	<h3>新增訂單</h3>
	<a href='ThisOrdred'>新增訂單資料</a> &nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/indexOrdered'/> ">回首頁</a>
	<table>
		<form:form action="insertOrdred" method="get" modelAttribute="odd">
			<tr>
				<td>訂單編號</td>
				<td><form:input path="ordered_number" /></td>
<%-- 				<td><form:errors path="ordered_number" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>顧客編號</td>
				<td><form:input path="customer_id" /></td>
<%-- 				<td><form:errors path="customer_id" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>餐點訂單編號</td>
				<td><form:input path="ordered_tomeals_id" /></td>
<%-- 				<td><form:errors path="ordered_tomeals_id" --%>
<!-- 						cssStyle="color: red;" /></td> -->
			</tr>
			<tr>
				<td>房間訂單編號</td>
				<td><form:input path="ordered_toroom_id" /></td>
<%-- 				<td><form:errors path="ordered_toroom_id" --%>
<!-- 						cssStyle="color: red;" /></td> -->
			</tr>
			<tr>
				<td>訂單狀態</td>
				<td><form:select path="status_id">
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
				<td><form:select path="payment_id">
				<form:option value="1">現金</form:option>
				<form:option value="2">信用卡</form:option>
				</form:select>
				</td>
<%-- 				<td><form:errors path="payment_id" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>訂單總價</td>
				<td><form:input path="ordered_accounts" /></td>
<%-- 				<td><form:errors path="ordered_accounts" cssStyle="color: red;" /></td> --%>
				
			</tr>
			<tr>
				<td>訂單日期</td>
				<td><form:input path="ordered_date" type="date" /></td>
<%-- 				<td><form:errors path="ordered_date" cssStyle="color: red;" /></td> --%>
				
			</tr>
			<tr>
				<td>發票編號</td>
				<td><form:input path="iv_no" /></td>
<%-- 				<td><form:errors path="iv_no" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td>備註</td>
				<td><form:input path="note" /></td>
<%-- 				<td><form:errors path="note" cssStyle="color: red;" /></td> --%>
			</tr>
		</form:form>
	</table>
	</div>
</body>
</html>