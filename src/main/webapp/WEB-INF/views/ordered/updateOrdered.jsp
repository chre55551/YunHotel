<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>UpdateOrdered</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>


	<div id="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>修改訂單</h3>
		<form action="/YunHotel/ordered/update" method="POST" id="container">
		<p>欲修改的訂單編號: ${updateOdered.ordered_number }</p>
			<div>
				<label>桌號: </label> <input name="table_number" id="requestTn" value="${updateOdered.table_number}"/>
			</div>	
			<div>
				<label>房號: </label> <input name="room_number" id="requestRn.table_number" />
			</div>
			<div>
				<label>訂單狀態: </label> 
<!-- 				<input name="ordered_status" id="requestMp" /> -->
				<select name="ordered_status" id="requestOs">
					<option>請選擇訂單狀態</option>
					<option>已成立</option>
					<option>已結單</option>
				</select>
			</div>
			<div>
				<label>付款方式: </label>
				<select name="payment_status" id="requestPS" >
					<option>請選擇付款方式</option>
					<option>現金</option>
					<option>信用卡</option>
				</select>
			</div>
			<div>
				<label>訂單總價</label> <input name="ordered_accounts" id="requestOa" />
			</div>
			<div>
				<label>訂單最後修改時間</label> <input name="ordered_last_update" id="requestOlu" type="date" />
			</div>
			<div>
				<label>備註</label> <input name="note" id="requestNote" />
			</div>
			<div>
			<input type="button" value="修改" onclick="location.href='../updateCustomerOd'" >
			<input value="清除"	type="reset">
				<%-- <a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>