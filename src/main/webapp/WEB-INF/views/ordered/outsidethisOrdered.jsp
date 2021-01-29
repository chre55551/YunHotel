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

	<div class="steakBG">
		<div class="main">
			<div class="orm2">
				<h4 class="ormt2">詳細訂單</h4>
			<c:forEach var="od" items="${list}">				
				<p class="ormt2">訂單編號: ${od.ordered_number}</p>
				<p class="ormt2">姓名: ${od.chinese_name}</p>
				<p class="ormt2">電話: ${od.mobile_phone}</p>

				<c:choose>
					<c:when test="${not empty od.customer.birthday}">
						<p class="ormt2">生日: ${od.customer.birthday}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">生日: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.customer.idcard_number}">
						<p class="ormt2">身分證字號: ${od.customer.idcard_number}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">身分證字號: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.customer.address}">
						<p class="ormt2">地址: ${od.customer.address}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">地址: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.status.ordered_status}">
						<p class="ormt2">訂單狀態: ${od.status.ordered_status}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">訂單狀態: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.payment.bill_status}">
						<p class="ormt2">付款方式: ${od.payment.bill_status}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">付款方式: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when
						test="${not empty od.orderedToMeals.mealsnum_of_people}">
						<p class="ormt2">用餐人數:
							${od.orderedToMeals.mealsnum_of_people}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.mdate.mdate}">
						<p class="ormt2">用餐日期: ${od.mdate.mdate}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.mdate.time_period}">
						<p class="ormt2">用餐時段: ${od.mdate.time_period}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.room.room_name}">
						<p class="ormt2">房號: ${od.room.room_name}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">房號: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.roomType.room_type}">
						<p class="ormt2">房型: ${od.roomType.room_type}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">房型: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty rdates}">
						<p class="ormt2">欲訂房日期:</p>
						<c:forEach var="rdate" items="${rdates}">
							<p>${rdate.rdate}</p>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.ordered_accounts}">
						<p class="ormt2">訂單總價: ${od.ordered_accounts}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">訂單總價: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.ordered_date}">
						<p class="ormt2">訂單成立時間: ${od.ordered_date}</p>
					</c:when>
					<c:otherwise>
						<!--     				訂單成立時間: 無 -->
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.ordered_last_update}">
						<p class="ormt2">訂單修改時間: ${od.ordered_last_update}</p>
					</c:when>
					<c:otherwise>
						<!--     				訂單修改時間: 無 -->
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty od.note}">
						<p class="ormt2">備註: ${od.note}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">備註: 無</p>
					</c:otherwise>
				</c:choose>
			</c:forEach>
				<br> 
<!-- 				<input class="ormBtn" type="button" value="回官網" -->
<!-- 					onclick="location.href='http://localhost:8080/YunHotel/YunPage'"> -->
				<input class="ormBtn" type="button" value="回官網"
					onclick="location.href='http://localhost:8080/YunHotel/YunPage'">
			</div>
		</div>
	</div>
	<div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>