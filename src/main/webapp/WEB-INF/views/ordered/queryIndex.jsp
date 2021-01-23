<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>QueryIndex</title>
</head>
<body>
 
<%@ include file="../CommonTemplates/header.jsp"%>

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

        <div id="container">
            <ul id="ALLdiamond">
                
            <li id="diamond">
<!--                 <div class="diamondtxt">依顧客查詢</div> -->
                <a href="customerToOrdered" class="diamondtxt">依顧客查詢</a>
            </li>
            <li id="diamond">
<!--                 <div class="diamondtxt">依日期查詢</div> -->
                <a href="dateToOrdered" class="diamondtxt">依日期查詢</a>
            </li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>