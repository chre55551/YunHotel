<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Query All Rooms</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
    
		<table class="mytable" class="container">
			<%@ include file="../CommonTemplates/leftmenu.jsp"%>
			<thead>
				<c:forEach var="xx" items="rom" >
				<tr>
<%-- 　					<td>${xx.}</td> --%>
　					<td>這裡可以放表格內容</td>
　					<td>這裡可以放表格內容</td>
　					<td>這裡可以放表格內容</td>
　					<td>這裡可以放表格內容</td>
　				</tr>
				</c:forEach>
			</thead>
		</table>
    </div>

  <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>