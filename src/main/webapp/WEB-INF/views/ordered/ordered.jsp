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

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

        <div id="container">
            <ul id="ALLdiamond">             
            <li id="diamond">
              <a href="insertIndex" class="diamondtxt">新增訂單</a>
            </li>
            <li id="diamond">
                 <a href="queryIndex" class="diamondtxt">查詢訂單</a>
            </li>
            <li id="diamond">
                <div class="diamondtxt">修改訂單</div>
            </li>
            <li id="diamond">
                <div class="diamondtxt">刪除訂單</div>
            </li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>