<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>顯示會員</title>
</head>

<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
			<h3>前台顧客資料</h3>
			<hr>
			<table border='1'>
				<tr>
					<th width='60'>編輯</th>
					<th width='160'>顧客姓名</th>
					<th width='60'>刪除</th>
				</tr>
				<c:choose>
					<c:when test="${not empty sab}">
						<c:forEach var='c' items="${sab}">
							<tr>
								<td align='center'><a href='modifyBmember/${c.bs_id}'>${c.bs_id}</a></td>
								<td>${c.user_id}</td>
								<td><a href="modifyBBmember/${c.bs_id}">刪除</a></td>
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

	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>