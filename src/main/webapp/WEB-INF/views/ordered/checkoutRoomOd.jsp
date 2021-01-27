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
<title>輸入退房結帳資訊</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<form
			action="/YunHotel/ordered/thisCheckoutRoomOd/${updateOdered.ordered_number}"
			method="POST" class="container">

			<c:choose>
				<c:when test="${not empty ${room_name}">
					<div>
						<label>房號 : </label> <input name="room_name" type="text"
							value="${room_name}" />
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ${rdate}">
					<div>
						<label>入住日期: </label> <input name="rdate" type="date"
							value="${rdate}" />
					</div>
				</c:when>
				<c:otherwise>
					<label>入住日期: </label>
					<input name="rdate" type="date" />
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ${rdateEnd}">
					<div>
						<label>退房日期: </label> <input name="rdateEnd" type="date"
							value="${rdateEnd}" />
					</div>
				</c:when>
				<c:otherwise>
					<label>退房日期: </label>
					<input name="rdateEnd" type="date" />
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${not empty ${room_accounts}">
					<div>
						<label>總價: </label> <input name="room_accounts " type="text"
							value="${room_accounts}" />
					</div>
				</c:when>
				<c:otherwise>
					<label>總價: </label>
					<input name="room_accounts " type="text" />
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ${payment_status}">
					<div>
						<label>付款方式: </label> <select name="payment_status">
							<option disabled>請選擇付款方式</option>
							<option value="現金">現金</option>
							<option value="信用卡">信用卡</option>
						</select>
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${not empty ${ordered_status}">
					<div>
						<label>訂單狀態: </label> <select name="ordered_status">
							<option disabled>請選擇訂單狀態</option>
							<option value="已成立">已成立</option>
							<option value="已結單">已結單</option>
						</select>
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>


		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>