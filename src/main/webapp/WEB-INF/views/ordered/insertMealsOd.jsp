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
		<a href="<c:url value='index'/> ">返回</a>
		<table>
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

	</div>
</body>
</html>