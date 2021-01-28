<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>news</title>
</head>
<body>
 
<%@ include file="../CommonTemplates/header.jsp"%>

<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">消息</p>
        <p class="hr"></p>
        		
        <div class="allcontent">
        	<div class="litletitle">	
        		<div class="ltF_div">
        			<img class="Rpic" src="${pageContext.request.contextPath}/image/add.png">
        			<a class="ltF" href='showinsertNews'>新增消息</a>
        		</div>
        	</div>
        </div>
        	
     </div>

</div>

<%@ include file="../CommonTemplates/footer.jsp"%>

</body>
</html>