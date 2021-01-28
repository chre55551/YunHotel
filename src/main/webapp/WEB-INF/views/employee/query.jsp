<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Query</title>
</head>
<body>
 
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

        <div class="container">
            <ul class="ALLdiamond">
                
            <li class="diamond">
<!--                 <div class="diamondtxt">依顧客查詢</div> -->
                <a href="showAllemployees" class="diamondtxt">查詢所有</a>
            </li>
            <li class="diamond">
<!--                 <div class="diamondtxt">依日期查詢</div> -->
                <a href="ThisEmployee" class="diamondtxt">單筆查詢</a>
            </li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>