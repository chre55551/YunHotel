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
<title>GetaNew</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
	<h3>查詢第${NWS.news_id}則的消息</h3>
	<p>編號: ${NWS.news_id}</p>
	<p>上傳時間: ${NWS.news_date}</p>
	<p>更新時間: ${NWS.news_updated_date}</p>
	<p>消息內容: ${NWS.news_content}</p>
		<a href="<c:url value='newsindex'/> ">回上一頁</a>
		<a href="<c:url value='UpdateNew'/> ">修改消息</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>