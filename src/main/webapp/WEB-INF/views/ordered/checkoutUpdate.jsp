<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout Finish</title>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
	<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">完成結帳</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
		<h3>結帳成功，請回至結帳首頁</h3>
		<input class="bormb" type="button" value="回結帳" onclick="location.href='http://localhost:8080/YunHotel/checkout/checkoutQueryRoomOd'" >
				</div>
        </div>
        	
     </div>

</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>