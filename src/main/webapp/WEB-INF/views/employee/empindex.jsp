<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css' type="text/css" />
<title>Employee</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

        <div id="container">
            <ul id="ALLdiamond">             
            <li id="diamond">
              <a href="insertEmployee" class="diamondtxt">新增員工資料</a>
            </li>
            <li id="diamond">
                 <a href="queryEmployee" class="diamondtxt">查詢員工資料</a>
            </li>
            <li id="diamond">
                <div class="diamondtxt">修改員工資料</div>
            </li>
            <li id="diamond">
                <div class="diamondtxt">刪除員工資料</div>
            </li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>