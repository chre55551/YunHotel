<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertBmember</title>
</head>
<body>
	<h3>新增會員</h3>
	<a href="<c:url value='/'/> ">回首頁</a>
	<table>
		<form:form action="insertbmemberbb" method="post" modelAttribute="bb">
			<tr>
				<td>帳號</td>
				<td><form:input path="bs_account" /></td>

			</tr>
			<tr>
				<td>密碼</td>
				<td><form:input path="bs_password" /></td>

			</tr>
			<tr>
				<td>信箱</td>
				<td><form:input path="bs_email" /></td>

			</tr>
			<tr>
				<td>權限</td>
				<td><form:input path="authority" /></td>

			</tr>
			<tr>
				<td>使用者名稱</td>
				<td><form:input path="user_id" /></td>

			</tr>

			<div>
				<input value="新增" type="submit">
			</div>
		</form:form>
	</table>
</body>
</html>