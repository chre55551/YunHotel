<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>查詢你的訂單</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="../CommonTemplates/Indexheader.jsp"%>

	<div class="queryODBG">
		<div class="main">
			<div class="orm2" style="text-align:left;">
				<h4 class="ormt2" style="margin-left: 10px; margin-top: 20px;">詳細訂單</h4>
				<c:choose>
					<c:when
						test="${not empty otm.mealsnum_of_people}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">用餐人數:
							${otm.mealsnum_of_people}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty mdate.mdate}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">用餐日期: ${mdate.mdate}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty mdate.time_period}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">用餐時段: ${mdate.time_period}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty room.room_name}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">房號: ${room.room_name}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty roomType.room_type}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">房型: ${roomType.room_type}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty rdates}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">欲訂房日期:</p>
						<c:forEach var="rdate" items="${rdates}">
							<p style="margin-left: 10px; margin-top: 20px;">${rdate.rdate}</p>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.ordered_accounts}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">訂單總價: ${od.ordered_accounts}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">訂單總價: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.ordered_date}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">訂單成立時間: ${od.ordered_date}</p>
					</c:when>
					<c:otherwise>
						<!--     				訂單成立時間: 無 -->
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.ordered_last_update}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">訂單修改時間: ${od.ordered_last_update}</p>
					</c:when>
					<c:otherwise>
						<!--     				訂單修改時間: 無 -->
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.note}">
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">備註: ${od.note}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2" style="margin-left: 10px; margin-top: 20px;">備註: 無</p>
					</c:otherwise>
				</c:choose>
				<br> 
<!-- 				<input class="ormBtn" type="button" value="回官網" -->
<!-- 					onclick="location.href='http://localhost:8080/YunHotel/YunPage'"> -->
				<input class="ormBtn" type="button" value="回列表"  style="margin-bottom: 10px;"
					onclick="location.href='http://localhost:8080/YunHotel/ordered/outsideQueryCustomerOd'">
			</div>
		</div>
	</div>
	<div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>