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
		<button id="insertOd">新增</button>
		<a href="<c:url value='/indexOrdered'/> ">返回</a>
		<table>
			<form:form action="insertOrdred" method="get" modelAttribute="odd"
				id="Odxx">
				<tr>
					<td>顧客編號</td>
					<td><form:input path="customer_id" id="requestCi" /></td>
				</tr>
				<tr>
					<td>餐點訂單編號</td>
					<td><form:input path="ordered_tomeals_id" id="requestOtmi" /></td>
					<%-- 				<td><form:errors path="ordered_tomeals_id" --%>
					<!-- 						cssStyle="color: red;" /></td> -->
				</tr>
				<tr>
					<td>房間訂單編號</td>
					<td><form:input path="ordered_toroom_id" id="requestOtri" /></td>
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
						</form:select></td>
					<%-- 				<td><form:errors path="status_id" cssStyle="color: red;" /></td> --%>
				</tr>
				<tr>
					<td>付款方式</td>
					<td><form:select path="payment_id" id="requestPi">
							<form:option value="1">現金</form:option>
							<form:option value="2">信用卡</form:option>
						</form:select></td>
					<%-- 				<td><form:errors path="payment_id" cssStyle="color: red;" /></td> --%>
				</tr>
				<tr>
					<td>訂單總價</td>
					<td><form:input path="ordered_accounts" id="requestOa" /></td>
					<%-- 				<td><form:errors path="ordered_accounts" cssStyle="color: red;" /></td> --%>

				</tr>
				<tr>
					<td>訂單日期</td>
					<td><form:input path="ordered_date" type="date" id="requestOd" /></td>
					<%-- 				<td><form:errors path="ordered_date" cssStyle="color: red;" /></td> --%>

				</tr>
				<tr>
					<td>發票編號</td>
					<td><form:input path="iv_no" id="requestIn" /></td>
					<%-- 				<td><form:errors path="iv_no" cssStyle="color: red;" /></td> --%>
				</tr>
				<tr>
					<td>備註</td>
					<td><form:input path="note" id="requestNote" /></td>
					<%-- 				<td><form:errors path="note" cssStyle="color: red;" /></td> --%>
				</tr>
			</form:form>
		</table>

	</div>
</body>
</html>