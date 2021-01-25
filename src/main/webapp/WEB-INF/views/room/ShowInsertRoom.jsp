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
<title>Show Insert Room</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
		<h2>新增完成</h2><hr/>
		<h3>房型名稱：${roomType.room_type}</h3>
		<h3>房價: ${roomType.room_price}</h3>
		<h3>房間圖片: ${roomType.room_image}</h3>
		<h3>房間圖片名稱: ${roomType.room_image_name}</h3>
		<a href="<c:url value='IndexRoom'/> ">回房務</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>