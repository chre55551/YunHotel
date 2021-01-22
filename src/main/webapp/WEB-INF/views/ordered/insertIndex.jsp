<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>InsertIndex</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

        <div id="container">
            <ul id="ALLdiamond">
                
            <li id="diamond">
                <a href="insertMealsOd" class="diamondtxt">餐點訂單</a>
            </li>
            <li id="diamond">
              <a href="insertRoomOd" class="diamondtxt">房間訂單</a>
            </li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>