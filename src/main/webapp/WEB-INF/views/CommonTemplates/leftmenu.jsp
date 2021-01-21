<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	    <div id="leftmenu">
			<ul>
				<li><a href="#" class="menutxt">後台首頁</a></li>
				<li><a href="${pageContext.request.contextPath}/bmember/IndexMember" class="menutxt">會員</a></li>
				<li><a href="${pageContext.request.contextPath}/ordered/indexOrdered" class="menutxt">訂單</a></li>
				<li><a href="#" class="menutxt">員工</a></li>
				<li><a href="${pageContext.request.contextPath}/meals/IndexMeals" class="menutxt">餐點</a></li>
				<li><a href="${pageContext.request.contextPath}/room/IndexRoom" class="menutxt">房務</a></li>
				<li><a href="${pageContext.request.contextPath}/news/newsindex" class="menutxt">消息</a></li>
				<li><a href="../YunPage" class="menutxt">回到官網</a></li>
			</ul>
		</div>
</body>
</html>