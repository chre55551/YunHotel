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
<title>QueryBmember</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>查詢後台會員</h3>
		<form action="/YunHotel/bmember/GetaBmember" method="POST" class="container">
			<div>
				<label>後台會員ID</label> <input name="bs_account" id="bs_account" />
			</div>
			
			<div>
				<input value="查詢" type="submit">
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">

	</script>
</body>
</html>