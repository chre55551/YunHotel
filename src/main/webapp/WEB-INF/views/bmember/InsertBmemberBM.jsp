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
<title>insertBmember</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div id="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增後台會員</h3>
		<form action="/YunHotel/bmember/InsertBmemberBM" method="POST" id="container">
			<div>
				<label>帳號</label> <input name="bs_account" id="requestCn" />
			</div>
			<div>
				<label>密碼</label> <input name="bs_password" id="requestMp" />
			</div>
			<div>
				<label>信箱</label> <input name=" bs_email" id="requestMp" />
			</div>
			<div>
				<label>設定使用者權限</label> <input name="authority" id="requestMp" />
			</div>
			<div>
				<label>暱稱</label> <input name=" user_id" id="requestMp" />
			</div>
			<div>
				<input value="新增" type="submit">
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">

	</script>
</body>
</html>