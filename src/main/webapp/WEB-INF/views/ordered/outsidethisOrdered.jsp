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
				<p class="ormt2">訂單編號: ${ordered.ordered_number}</p>
				<p class="ormt2">姓名: ${customer.chinese_name}</p>
				<p class="ormt2">電話: ${customer.mobile_phone}</p>

				<c:choose>
					<c:when test="${not empty customer.birthday}">
						<p class="ormt2">生日: ${customer.birthday}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">生日: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty customer.idcard_number}">
						<p class="ormt2">身分證字號: ${customer.idcard_number}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">身分證字號: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty customer.address}">
						<p class="ormt2">地址: ${customer.address}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">地址: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty status.ordered_status}">
						<p class="ormt2">訂單狀態: ${status.ordered_status}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">訂單狀態: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty payment.bill_status}">
						<p class="ormt2">付款方式: ${payment.bill_status}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">付款方式: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when
						test="${not empty ordered.orderedToMeals.mealsnum_of_people}">
						<p class="ormt2">用餐人數:
							${ordered.orderedToMeals.mealsnum_of_people}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty mdate.mdate}">
						<p class="ormt2">用餐日期: ${mdate.mdate}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty mdate.time_period}">
						<p class="ormt2">用餐時段: ${mdate.time_period}</p>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty room.room_name}">
						<p class="ormt2">房號: ${room.room_name}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">房號: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty roomType.room_type}">
						<p class="ormt2">房型: ${roomType.room_type}</p>
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
					<c:when test="${not empty ordered.ordered_accounts}">
						<p class="ormt2">訂單總價: ${ordered.ordered_accounts}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">訂單總價: 無</p>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty ordered.ordered_date}">
						<p class="ormt2">訂單成立時間: ${ordered.ordered_date}</p>
					</c:when>
					<c:otherwise>
						<!--     				訂單成立時間: 無 -->
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty ordered.ordered_last_update}">
						<p class="ormt2">訂單修改時間: ${ordered.ordered_last_update}</p>
					</c:when>
					<c:otherwise>
						<!--     				訂單修改時間: 無 -->
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty ordered.note}">
						<p class="ormt2">備註: ${ordered.note}</p>
					</c:when>
					<c:otherwise>
						<p class="ormt2">備註: 無</p>
					</c:otherwise>
				</c:choose>

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