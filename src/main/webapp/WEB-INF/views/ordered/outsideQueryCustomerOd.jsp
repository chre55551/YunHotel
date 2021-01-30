<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>訂單查詢</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="../CommonTemplates/Indexheader.jsp"%>

	<div class="queryODBG">
		<div class="main">
			<div class="orm2">
				<h4 class="ormt2">您的所有訂單</h4>
<%-- 				<c:forEach var="getcu" items="${list}"> --%>
					<p>訂單編號: ${onum}</p>
					<p>姓名: ${name}</p>
					<p>手機: ${phone}</p>
					<p>訂單時間: ${odate}</p>
					<p>訂單狀態: ${ostatus}</p>
					<p>付款方式: ${oBill}</p>
<%-- 				</c:forEach> --%>
				<br> <input class="ormBtn" type="button" value="回官網"
					onclick="location.href='http://localhost:8080/YunHotel/YunPage'">
			</div>
		</div>
	</div>

	<div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>