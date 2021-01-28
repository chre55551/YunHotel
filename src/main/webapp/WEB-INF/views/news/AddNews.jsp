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
<title>insertMealsOrdered</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增消息</h3>
		<form action="/YunHotel/news/insertNews" method="POST" class="container">
<!-- 			<div> -->
<!-- 				<label>編號：</label> <input name="news_id"/> -->
<!-- 			</div> -->
			<div>
				<label>消息上傳時間：</label> <input name="news_date" type="date"/>
			</div>
			<div>
				<label>消息內容：</label> <input name="news_content"/>
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