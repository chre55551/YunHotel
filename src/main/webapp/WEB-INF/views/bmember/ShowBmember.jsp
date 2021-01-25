<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/style.css' type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<h3>客戶資料</h3>
		<hr>
		<table border='1'>
			<tr>
				<th width='60'>編輯</th>
				<th width='160'>客戶姓名</th>
			</tr>
			<c:choose>
				<c:when test="${not empty sab}">
					<c:forEach var='c' items="${sab}">
						<tr>
							<td align='center'><a
								href='modifyCustomer/${c.bs_id}'>${c.bs_id}</a></td>
							<td>${c.user_id}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
				查無Customer資料
			</c:otherwise>
			</c:choose>
		</table>
		<br> <a href="<c:url value='/' />">回首頁</a>
	</div>
</body>
</html>