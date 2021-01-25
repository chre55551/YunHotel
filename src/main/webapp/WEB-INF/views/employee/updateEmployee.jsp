<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>UpdateEmployee</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>修改資料</h3>
		<form action="/YunHotel/employee/updateEmployee" method="POST"
			class="container">
			<div>
				<label>姓名</label> <input name="employee_name" class="requestCn" />
			</div>
			<div>
				<label>部門</label> <input name="employee_department" class="requestMp" />
			</div>
			<div>
				<label>職位</label> <input name="employee_position" class="requestMp" />
			</div>		
			<div>
				<label>年資</label> <input name="employee_workyears" class="requestMp"
					/>
			</div>			
			<div>
				<label>薪水</label> <input name="employee_salary" class="requestMp"
					 />
			</div>					
			<div>
				<label>性別</label> <input name="employee_gender" class="requestMp"
					 />
			</div>			
			<div>
				<label>年齡</label> <input name="employee_age" class="requestMp"
					 />
			</div>			
			<div>
				<label>地址</label> <input name="employee_address" class="requestMp"
					 />
			</div>			
			<div>
				<label>手機</label> <input name="employee_mobile" class="requestMp"
					 />
			</div>			
			<div>
				<label>電話</label> <input name="employee_phone" class="requestMp"
					 />
			</div>			
			<div>
				<label>電子信箱</label> <input name="employee_email" class="requestMp"
					 />
			</div>			
			<div>
				<label>緊急聯絡人</label> <input name="emergency_contact" class="requestMp"
					 />
			</div>			
			<div>
				<label>大頭照</label> 
				 <input type="file"name="employee_image" class="requestRoomImage" onchange="fileShow();" accept="image/*">
			</div>		

			<div>
				<input value="修改" type="submit">
				<input value="清除" type="reset">
				<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">

	</script>
</body>
</html>