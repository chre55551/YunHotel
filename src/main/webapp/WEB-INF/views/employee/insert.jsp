<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>Insert</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

        <div id="container">
            <ul id="ALLdiamond">
                
            <li id="diamond">
                <a href="insertEmp" class="diamondtxt">員工資料</a>
            </li>
            <li id="diamond">
              <a href="insertSch" class="diamondtxt">排班</a>
            </li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>