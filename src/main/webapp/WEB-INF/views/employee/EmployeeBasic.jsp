<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
		<h3>表單資料</h3>
	<a href='employees'>新增員工資料</a> &nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/'/> ">回前頁</a>
	<table>
		<form:form action="employees" method="post" modelAttribute="odd">
			<tr>
				<td>員工編號</td>
				<td><form:input path="ordered_number" /></td>
				<td><form:errors path="ordered_number" cssStyle="color: red;" /></td>
			</tr>
		
		</form:form>
	</table>
</body>
</html>