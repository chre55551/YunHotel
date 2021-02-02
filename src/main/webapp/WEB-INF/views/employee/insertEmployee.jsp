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


	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增員工資料</h3>
		<form action="/YunHotel/employee/insertEmployee" method="POST"
			class="container">
			<div>
				<label>姓名</label> <input name="employee_name" class="requestCn" 
					value="張凱翔"/>
			</div>
			<div>
				<label>部門</label> <input name="employee_department" class="requestMp" 
				value="房務部"/>
			</div>
			<div>
				<label>職位</label> <input name="employee_position" class="requestMp"
				value="房務人員" />
			</div>		
			<div>
				<label>年資</label> <input name="employee_workyears" class="requestMp"
					value="5"/>
			</div>			
			<div>
				<label>薪水</label> <input name="employee_salary" class="requestMp"
					 value="35000"/>
			</div>					
			<div>
				<label>性別</label> <input name="employee_gender" class="requestMp"
					 value="男"/>
			</div>			
			<div>
				<label>年齡</label> <input name="employee_age" class="requestMp"
					 value="30"/>
			</div>			
			<div>
				<label>地址</label> <input name="employee_address" class="requestMp"
					 value="台北市松山區"/>
			</div>			
			<div>
				<label>手機</label> <input name="employee_mobile" class="requestMp"
					 value="0911245123"/>
			</div>			
			<div>
				<label>電話</label> <input name="employee_phone" class="requestMp"
					value="02-25664789" />
			</div>			
			<div>
				<label>電子信箱</label> <input name="employee_email" class="requestMp"
					 value="pop@gmail.com"/>
			</div>			
			<div>
				<label>緊急聯絡人</label> <input name="emergency_contact" class="requestMp"
					value="張君雅" />
			</div>			
<!-- 			<div> -->
<!-- 				<label>大頭照</label>  -->
<!-- 				 <input type="file"name="employee_image" class="requestRoomImage" onchange="fileShow();" accept="image/*"> -->
<!-- 			</div>		 -->

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