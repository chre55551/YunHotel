<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Ordered</title>

</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
    <%@ include file="../CommonTemplates/leftmenu.jsp"%>
        	
    <div class="right">
        <p class="title">訂單</p>
        <p class="hr"></p>
        
        
        <div class="litlte_allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        
            <ul class="ALLdiamond">             
            	<li class="diamond_M"> 
              		<a href="insertIndex" class="diamondtxt">&emsp;   新增訂單</a>
            	</li>
            	<li class="diamond_M">
                 <a href="customerToOrdered" class="diamondtxt">&emsp;   查詢訂單</a>
            	</li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>