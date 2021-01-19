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
    <header> 
        <img id="logo" src="${pageContext.request.contextPath}/image/home.png">
        <p id="backstage">後台管理系統</p>
        <a href="#" id="logout">登出</a>
    </header>

    <div id="main">
        <div id="leftmenu">
            <ul>
                <li><a href="#" class="menutxt">後台首頁</a></li>
                <li><a href="#" class="menutxt">member</a></li>
                <li><a href="#" class="menutxt">ordered</a></li>
                <li><a href="#" class="menutxt">employee</a></li>
                <li><a href="#" class="menutxt">meals</a></li>
                <li><a href="#" class="menutxt">room</a></li>
                <li><a href="#" class="menutxt">news</a></li>
                <li><a href="<c:url value='/YunPage' />" class="menutxt">回到官網</a></li>
            </ul>
        </div>

       

    <div id="footer"> 
        <p>© The Hotel. All Rights Reserved.</p>
    </div>
</body>
</html>