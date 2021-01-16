<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordered</title>
</head>
<body>
	<h3>表單資料</h3>
	<a href='ShowOrdered'>新增訂單資料</a> &nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/'/> ">回前頁</a>
	<table>
		<!-- 		<tr> -->
		<!-- 			<th>訂單編號</th> -->
		<!-- 			<th>顧客編號</th> -->
		<!-- 			<th>餐點訂單編號</th> -->
		<!-- 			<th>房間訂單編號</th> -->
		<!-- 			<th>狀態ID</th> -->
		<!-- 			<th>付款ID</th> -->
		<!-- 			<th>訂單總價</th> -->
		<!-- 			<th>訂單日期</th> -->
		<!-- 			<th>發票編號</th> -->
		<!-- 			<th>備註</th> -->
		<!-- 		</tr> -->
		<%-- 		<c:forEach var='ordered' items='${ordered}'> --%>
		<!-- 		<tr> -->
		<%-- 			<td>${ordered.ordered_number}</td> --%>
		<%-- 			<td>${ordered.customer_id}</td> --%>
		<%-- 			<td>${ordered.ordered_tomeals_id}</td> --%>
		<%-- 			<td>${ordered.ordered_toroom_id}</td> --%>
		<%-- 			<td>${ordered.status_id}</td> --%>
		<%-- 			<td>${ordered.payment_id}</td> --%>
		<%-- 			<td>${ordered.ordered_accounts}</td> --%>
		<%-- 			<td>${ordered.ordered_date}</td> --%>
		<%-- 			<td>${ordered.iv_no}</td> --%>
		<%-- 			<td>${ordered.note}</td> --%>
		<!-- 		</tr> -->
		<%-- 		</c:forEach> --%>
		<form:form action="ShowOrdered" method="post" modelAttribute="odd">
			<tr>
				<td>訂單編號</td>
				<td><form:input path="ordered_number" /></td>
				<td><form:errors path="ordered_number" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>顧客編號</td>
				<td><form:input path="customer_id" /></td>
				<td><form:errors path="customer_id" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>餐點訂單編號</td>
				<td><form:input path="ordered_tomeals_id" /></td>
				<td><form:errors path="ordered_tomeals_id"
						cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>房間訂單編號</td>
				<td><form:input path="ordered_toroom_id" /></td>
				<td><form:errors path="ordered_toroom_id"
						cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>狀態ID</td>
				<td><form:input path="status_id" /></td>
				<td><form:errors path="status_id" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>付款ID</td>
				<td><form:input path="payment_id" /></td>
				<td><form:errors path="payment_id" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>訂單總價</td>
				<td><form:input path="ordered_accounts" /></td>
				<td><form:errors path="ordered_accounts" cssStyle="color: red;" />
				</td>
			</tr>
			<tr>
				<td>訂單日期</td>
				<td><form:input path="ordered_date" /></td>
				<td><form:errors path="ordered_date" cssStyle="color: red;" />
				</td>
			</tr>
			<tr>
				<td>發票編號</td>
				<td><form:input path="iv_no" /></td>
				<td><form:errors path="iv_no" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>備註</td>
				<td><form:input path="note" /></td>
				<td><form:errors path="note" cssStyle="color: red;" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>