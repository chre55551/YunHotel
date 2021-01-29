<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css' type="text/css" />
<title>後台</title>
</head>
<body>
<%@ include file="CommonTemplates/header.jsp"%>

<div class="main">
	<%@ include file="CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">首頁</p>
        <p class="hr"></p>
        		
        <div class="allcontent">
        	<div class="litletitle">	
        	</div>
        </div>
        	
     </div>

</div>
<%@ include file="CommonTemplates/footer.jsp"%>
</body>
</html>