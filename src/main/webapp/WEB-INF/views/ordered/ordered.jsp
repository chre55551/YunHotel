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
                <li><a href="../" class="menutxt">後台首頁</a></li>
                <li><a href="#" class="menutxt">會員</a></li>
                <li><a href="indexOrdered" class="menutxt">訂單</a></li>
                <li><a href="#" class="menutxt">員工</a></li>
                <li><a href="#" class="menutxt">餐點</a></li>
                <li><a href="#" class="menutxt">房務</a></li>
                <li><a href="../news/newsindex" class="menutxt">消息</a></li>
                <li><a href="../YunPage" class="menutxt">回到官網</a></li>
            </ul>
        </div>

        <div id="container">
            <ul id="ALLdiamond">
                
            <li id="diamond">
                <div class="diamondtxt">所有訂單</div>
            </li>
            <li id="diamond">
                <a href="insertMealsOd" class="diamondtxt">新增餐點訂單</a>
            </li>
            <li id="diamond">
                <div class="diamondtxt">新增房間訂單</div>
            </li>
            <li id="diamond">
                <div class="diamondtxt">刪除訂單</div>
            </li>
            <li id="diamond">
                <div class="diamondtxt">修改訂單</div>
            </li>
            <li id="diamond">
                <div class="diamondtxt">查詢訂單</div>
            </li>
            </ul>
        </div>
    </div>

    <div id="footer"> 
        <p>© The Hotel. All Rights Reserved.</p>
    </div>
</body>
</html>