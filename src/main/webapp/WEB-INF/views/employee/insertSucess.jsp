<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>InsertSucess</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
		<h2>新增成功</h2><hr/>
		<p>員工編號:${NBbeans.employee_id}</p>
		<p>姓名：${NBbeans.employee_name}</p>
		<p>部門: ${NBbeans.employee_department}</p>
		<p>職位: ${NBbeans.employee_position}</p>
		<p>年資: ${NWbeans.employee_workyears}</p>
		<p>薪水: ${NWbeans.employee_salary}</p>
		<p>性別: ${NIbeans.employee_gender}</p>
		<p>年齡: ${NIbeans.employee_age}</p>
		<p>地址: ${NIbeans.employee_address}</p>
		<p>手機: ${NIbeans.employee_mobile}</p>
		<p>電話: ${NIbeans.employee_phone}</p>
		<p>電子信箱: ${NIbeans.employee_email}</p>
		<p>緊急聯絡人: ${NIbeans.emergency_contact}</p>
		<p>大頭照: ${NIbeans.employee_image}</p>

		<a href="<c:url value='insertEmp'/> ">回新增</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>