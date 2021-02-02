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
<title>Meals2AddSucess</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
		<h2>新增成功</h2><hr/>
		<h3>餐點編號：${MES.meals2_id}</h3>
		<p>餐點類型: ${MES.meals2_type}</p>
		<p>餐點價格: ${MES.meals2_price}</p>
		<p>餐點庫存: ${MES.meals2_stock}</p>
		
		<a href="<c:url value='IndexMeals2'/> ">回餐點</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>