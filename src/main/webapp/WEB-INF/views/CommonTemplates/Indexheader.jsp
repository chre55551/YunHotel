<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<header>

		<ul>
			<li><a href="http://localhost:8080/YunHotel/YunPage"><img
					class="logo"
					src="${pageContext.request.contextPath}/image/yunlogo.jpg"></a></li>
			<li>&emsp;&emsp;&emsp;&emsp;</li>
			<li><a href="#">關於我們</a></li>
			<li><a href="http://localhost:8080/YunHotel/news/outsideNews">最新消息</a></li>
			<li><a href="room/RoomIntroduction">房型介紹</a></li>
			<li><a href="meals/Delicious">美食佳餚</a></li>
			<li><a href="#">其他設施</a></li>
		<c:choose>
			<c:when test="${not empty LoginOK}">
			
				<li><a href="http://localhost:8080/YunHotel/customer/ShowMember">會員中心</a></li>
				<li><a href="http://localhost:8080/YunHotel/customer/logout">登出</a></li>
			</c:when>

			<c:otherwise>
				<li><a href="http://localhost:8080/YunHotel/customer/Login">登入</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
	</header>
</body>
</html>