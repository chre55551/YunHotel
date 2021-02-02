<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Show Blank Insert Meals Form</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		
		<form action="/YunHotel/meals/InsertMeals" method="POST" class="container">
<!-- 			<div> -->
<!-- 				<label>編號：</label> <input name="news_id"/> -->
<!-- 			</div> -->
            <h3>新增餐點</h3>
			<div>
				<label>餐點名稱：</label> <input name="meals_name" />
			</div>
			<div>
				<label>餐點價格：</label> <input name="meals_price"/>
			</div>
			<div>
				<label>餐點庫存：</label> <input name="meals_stock"/>
			</div>
			<div>
				<input value="新增" type="submit">
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>