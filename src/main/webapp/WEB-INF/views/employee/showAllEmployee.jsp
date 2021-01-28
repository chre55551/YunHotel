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
<title>showAllEmployee</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
<div align='center'>
<h3>全部員工資料</h3>
		<table class="container" border='1' cellpadding="3" cellspacing="1" >
			<tr>
			   <th width='56' height='20'>員工編號</th>
			   <th width='80' height='20'>姓名</th>
			   <th width='110' height='20'>部門</th>
			   <th width='110' height='20'>職位</th>
			   <th width='56' height='20'>年資</th>
			   <th width='90' height='20'>薪水</th>
<!-- 			   <th width='80' height='20'>工作時數</th> -->
<!-- 			   <th width='80' height='20'>休假時數</th> -->
			   <th width='56' height='20'>性別</th>
			   <th width='56' height='20'>年齡</th>
			   <th width='160' height='20'>住址</th>
			   <th width='100' height='20'>手機</th>
			   <th width='120' height='20'>電話</th>
			   <th width='120' height='20'>電子信箱</th>
			   <th width='70' height='20'>緊急聯絡人</th>
<!-- 			   <th width='100' height='100'>員工大頭照</th> -->
			   <th width='90' height='20'>職位狀態</th>
			   <th colspan='2' height='20'>維護</th>
			</tr>
			<c:forEach var='emb' items='${embs}'>
<%-- 			<c:forEach var='emw' items='${employee_workList}'> --%>
<%-- 			<c:forEach var='emi' items='${employee_infoList}'> --%>
<%-- 			<c:forEach var='ems' items='${employee_statusList}'> --%>
				<tr>
					<td style="text-align:center">${emb.employee_id}</td>
					<td style="text-align:center">${emb.employee_name}</td>
					<td style="text-align:center">${emb.employee_department}</td>
					<td style="text-align:center">${emb.employee_position}</td>
					<td style="text-align:center">${emb.employee_work.employee_workyears}</td>
					<td style="text-align:center">${emb.employee_work.employee_salary}</td>
<%-- 					<td style="text-align:center">${emb.employee_work.working_hours}</td> --%>
<%-- 					<td style="text-align:center">${emb.employee_work.holiday_hours}</td> --%>
					<td style="text-align:center">${emb.employee_info.employee_gender}</td>
					<td style="text-align:center">${emb.employee_info.employee_age}</td>
					<td style="text-align:center">${emb.employee_info.employee_address}</td>
					<td style="text-align:center">${emb.employee_info.employee_mobile}</td>
					<td style="text-align:center">${emb.employee_info.employee_phone}</td>
					<td style="text-align:center">${emb.employee_info.employee_email}</td>
					<td style="text-align:center">${emb.employee_info.emergency_contact}</td>
<%-- 					<td style="text-align:center">${emb.employee_info.employee_image}</td> --%>
					<td style="text-align:center">${emb.employee_status.employee_status}</td>
					<td align='center'><a href='updateEmployee/${emb.employee_id}'>編輯</a></td>
<!-- 					 <td><a -->
<%--                         href="${pageContext.request.contextPath}/employee/updateEmployee/${emb.employee_id}">編輯</a></td> --%>
                    <td><a
                        href="${pageContext.request.contextPath}/employee/deleteEmployee/${emb.employee_id}">刪除</a></td>
				</tr>
<%-- 			</c:forEach> --%>
<%-- 			</c:forEach> --%>
<%-- 			</c:forEach> --%>
			</c:forEach>
		</table>
<hr>
</div>
<script type='text/javascript'>
    $(document).ready(function() {
        $('.deletelink').click(function() {
        	if (confirm('確定刪除? ')) {
        		var href = $(this).attr('href');
                $('form').attr('action', href).submit();
        	} 
        	return false;
            
        });
    })
</script>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>