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
<title>DeleteBmember</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div id="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>刪除後台會員</h3>
		<form action="/YunHotel/bmember/DeleteBmember" method="DELETE" id="container">
			<div>
				<label>後台會員ID</label> <input name="bs_id" id="requestCn" />
			</div>
			
			<div>
				<input value="刪除" type="submit">

			</div>
		</form>
	</div>
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">

	</script>
</body>
</html>