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
<title>customerMealsOrdered</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div id="container">
		<h2>新增成功</h2><hr/>
<%-- 		<h3>這是${bb.BmemberBean.bs_id}的訂單</h3> --%>
		<p>帳號: ${bb.BmemberBean.bs_account}</p>
		<p>密碼: ${bb.BmemberBean.bs_password}</p>
		<p>信箱: ${bb.BmemberBean.bs_email}</p>
		<p>權限: ${bb.BmemberBean.authority}</p>
		<p>使用者名稱: ${bb.BmemberBean.user_id}</p>
		<a href="<c:url value='InsertBmemberBM'/> ">回新增</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>