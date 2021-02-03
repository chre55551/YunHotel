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
<title>UpdateNew</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>修改員工</h3>
		<form method="POST" class="container">
			<div>
				<label>姓名：</label> <input name="employee_name" value="縣春"/>
			</div>
			<div>
				<label>部門：</label> <input name="employee_department"value="餐飲部"/>
			</div>
			<div>
				<label>職位：</label> <input name="employee_position"value="經理"/>
			</div>
			<div>
				<label>年資：</label> <input name="employee_workyears"value="10"/>
			</div>
			<div>
				<label>薪水：</label> <input name="employee_salary"value="38000"/>
			</div>
			<div>
				<label>性別：</label> <input name="employee_gender"value="男"/>
			</div>
			<div>
				<label>年齡：</label> <input name="employee_age"value="60"/>
			</div>
			<div>
				<label>住址：</label> <input name="employee_address"value="台北市大安區"/>
			</div>
			<div>
				<label>手機：</label> <input name="employee_mobile"value="0937234567"/>
			</div>
			<div>
				<label>電話：</label> <input name="employee_phone"value="02-25669785"/>
			</div>
			<div>
				<label>電子信箱：</label> <input name="employee_email"value="zzz@yahoo.com.tw	"/>
			</div>
			<div>
				<label>緊急聯絡人：</label> <input name="emergency_contact"value="一兆"/>
			</div>
<!-- 			<div> -->
<!-- 				<label>職位狀態：</label> <input name="news_content"value=""/> -->
<!-- 			</div> -->

																																				
			<div>
				<input value="修改" type="submit" >
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">

	</script>
</body>
</html>