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
<title>NewAddSucess</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div id="container">
		<h2>新增成功</h2><hr/>
		<h3>編號：${NWS.news_id}</h3>
		<p>上傳時間: ${NWS.news_date}</p>
		<p>內容: ${NWS.news_content}</p>
		<a href="<c:url value='showinsertNews'/> ">回新增</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>