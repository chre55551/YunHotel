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

<div id="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
        <div id="container">
            <ul id="ALLdiamond">
                
            <li id="diamond">
                <a href='showAllNews' class="diamondtxt">所有消息</a>
            </li>
            <li id="diamond">
                <a href='showinsertNews' class="diamondtxt">新增消息</a>
            </li>
            <li id="diamond">
                <a href='DeleteNew' class="diamondtxt">刪除消息</a>
            </li>
            <li id="diamond">
                <a href='UpdateNew' class="diamondtxt">修改消息</a>
            </li>
            <li id="diamond">
                <a href='queryNew' class="diamondtxt">查詢消息</a>
            </li>
            </ul>
        </div>
</div>
<div></div>
<%@ include file="../CommonTemplates/footer.jsp"%>

</body>
</html>