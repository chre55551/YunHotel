<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>GetaBmember</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div id="container">
	<h3>查詢第${qbm.bs_id}則的消息</h3>
	<p>編號: ${qbm.bs_id}</p>
	<p>帳號: ${qbm.bs_account}</p>
	<p>密碼: ${qbm.bs_password}</p>
	<p>消息內容: ${qbm.bs_email}</p>
		<a href="<c:url value='IndexMember'/> ">回上一頁</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>