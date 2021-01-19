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
				<tr>
					<td>姓名</td>
					<td><input /></td>
				</tr>
				<tr>
					<td>電話</td>
					<td><input /></td>
				</tr>
				<tr>
					<td>人數</td>
					<td><input /></td>
				</tr>
				<tr>
					<td>用餐時間</td>
					<td><input name ="ordered_tomeals_id" id="requestOtmi" /></td>
				</tr>
		</table>

	</div>
</body>
</html>