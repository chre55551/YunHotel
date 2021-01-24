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
<title>Show Query Room</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div id="container">
	<h3>查詢第${rom.room_typeid}的房型</h3>
	<p>編號: ${rom.room_typeid}</p>
	<p>房價: ${rom.room_price}</p>
	<p>庫存: ${rom.room_stock}</p>
	<p>房間圖片: ${rom.room_image}</p>
	<p>房間圖片名稱: ${rom.room_image_name}</p>
		<a href="<c:url value='IndexRoom'/> ">回上一頁</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>