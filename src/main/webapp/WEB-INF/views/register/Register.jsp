<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊會員</title>
</head>
<body>
	<h3>新增會員</h3>
	<a href="<c:url value='/'/> ">回首頁</a>
	<table>
		<form:form action="insertbmemberbb" method="post" modelAttribute="bb">
			<tr>
				<td>帳號</td>
				<td><form:input path="account" /></td>

			</tr>
			<tr>
				<td>密碼</td>
				<td><form:input path="password" /></td>

			</tr>
			<tr>
				<td>性別</td>
				<td><form:input path="gender" /></td>

			</tr>
			<tr>
				<td>真實姓名</td>
				<td><form:input path="chinese_name" /></td>

			</tr>
			<tr>
				<td>工作</td>
				<td><form:input path="job" /></td>

			</tr>
			<tr>
				<td>信箱</td>
				<td><form:input path="email" /></td>

			</tr>
			<tr>
				<td>身分證字號</td>
				<td><form:input path="idcard_number" /></td>

			</tr>
			<tr>
				<td>生日</td>
				<td><form:input path="birthday" /></td>

			</tr>
			<tr>
				<td>地址</td>
				<td><form:input path="address" /></td>

			</tr>
			<tr>
				<td>家裡電話</td>
				<td><form:input path="home_phone" /></td>

			</tr>

			<tr>
				<td>手機電話</td>
				<td><form:input path="mobile_phone" /></td>

			</tr>
			<div>
				<input value="註冊" type="submit">
			</div>
		</form:form>
	</table>
</body>
</html>