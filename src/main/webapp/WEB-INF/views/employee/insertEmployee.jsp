<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>Insert Employee</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>


	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增餐點訂單</h3>
		<form action="/YunHotel/employee/insertEmployee" method="POST"
			id="container">
			<div>
				<label>姓名</label> <input name="employee_name" id="requestCn" />
			</div>
			<div>
				<label>部門</label> <input name="employee_department" id="requestMp" />
			</div>
			<div>
				<label>職位</label> <input name="employee_position" id="requestMp" />
			</div>		
			<div>
				<label>年資</label> <input name="employee_workyears" id="requestMp"
					/>
			</div>			
			<div>
				<label>薪水</label> <input name="employee_salary" id="requestMp"
					 />
			</div>			
			<div>
				<label>工作時數</label> <input name="working_hours" id="requestMp"
					 />
			</div>			
			<div>
				<label>休假時數</label> <input name="holiday_hours" id="requestMp"
					 />
			</div>			
			<div>
				<label>性別</label> <input name="employee_gender" id="requestMp"
					 />
			</div>			
			<div>
				<label>年齡</label> <input name="employee_age" id="requestMp"
					 />
			</div>			
			<div>
				<label>地址</label> <input name="employee_address" id="requestMp"
					 />
			</div>			
			<div>
				<label>手機</label> <input name="employee_mobile" id="requestMp"
					 />
			</div>			
			<div>
				<label>電話</label> <input name="employee_phone" id="requestMp"
					 />
			</div>			
			<div>
				<label>電子信箱</label> <input name="employee_email" id="requestMp"
					 />
			</div>			
			<div>
				<label>緊急聯絡人</label> <input name="emergency_contact" id="requestMp"
					 />
			</div>			
			<div>
				<label>大頭照</label> 
				 <input type="file"name="employee_image" id="requestRoomImage" onchange="fileShow();" accept="image/*">
			</div>		
			<div>
				<label>職位狀態</label> <input name="employee_status" id="requestMp"
					 />
			</div>
			<div>
				<input value="新增" type="submit">
				<input value="清除" type="reset">
				<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
	
</body>
</html>