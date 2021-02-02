<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="leftmenu">
		<ul>
			<li><a href="http://localhost:8080/YunHotel" class="menutxt">後台首頁</a></li>
			<li><img class="pic"
				src="${pageContext.request.contextPath}/image/member.png"> <a
				href="${pageContext.request.contextPath}/bmember/IndexMember"
				class="menutxt">會員</a></li>
			<li><img class="pic"
				src="${pageContext.request.contextPath}/image/orderlist.png">
				<a href="${pageContext.request.contextPath}/ordered/indexOrdered"
				class="menutxt">訂單</a></li>
			<li><img class="pic"
				src="${pageContext.request.contextPath}/image/employee.png"> <a
				href="${pageContext.request.contextPath}/employee/empindex"
				class="menutxt">員工</a></li>
			<li><img class="pic"
				src="${pageContext.request.contextPath}/image/food.png"> <a
				href="${pageContext.request.contextPath}/meals2/IndexMeals2"
				class="menutxt">餐點</a></li>
			<li><img class="pic"
				src="${pageContext.request.contextPath}/image/roomthing.png">
				<a href="${pageContext.request.contextPath}/room/IndexRoom"
				class="menutxt">房務</a></li>
			<li><img class="pic"
				src="${pageContext.request.contextPath}/image/news.png"> <a
				href="${pageContext.request.contextPath}/news/newsindex"
				class="menutxt">消息</a></li>
			<li><img class="pic"
				src="${pageContext.request.contextPath}/image/money.png"> <a
				href="${pageContext.request.contextPath}/ordered/checkoutIndex"
				class="menutxt">結帳</a></li>
			<li><c:choose>
					<c:when test="${not empty BLoginOK}">
						<img class="pic"
							src="${pageContext.request.contextPath}/image/login.png">
						<a href="http://localhost:8080/YunHotel/bmember/BLogout">登出</a>
					</c:when>
					<c:otherwise>
						<img class="pic"
							src="${pageContext.request.contextPath}/image/login.png">
						<a href="${pageContext.request.contextPath}/bmember/BLogin"
							class="menutxt">登入</a>
					</c:otherwise>
				</c:choose></li>
			<li><a href="http://localhost:8080/YunHotel/YunPage"
				class="menutxt">回到官網</a></li>
		</ul>
	</div>
</body>
</html>