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
	<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>訂單結帳資訊</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">查詢房務結帳資訊</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
		<form action="/YunHotel/checkout/checkoutUpdate"
			method="POST" style="margin-left:350px;">

			<input type="hidden" name="ordered_number" value="${od.ordered_number}">
			<c:choose>
				<c:when test="${not empty room.room_name}">
					<div class="bormm">
						<label class="bormt">房號 :</label><p>${room.room_name}</p>
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

				<c:choose>
					<c:when test="${not empty rdates}">
						<p class="ormt2 bormt">訂房日期:</p>
						<c:forEach var="rdate" items="${rdates}">
							<p>${rdate.rdate}</p>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>


<%-- 			<c:choose> --%>
<%-- 				<c:when test="${not empty rdateEnd}"> --%>
<!-- 					<div> -->
<!-- 						<label>退房日期: </label> <input name="rdateEnd" type="date" -->
<%-- 							value="${rdateEnd}" /> --%>
<!-- 					</div> -->
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<!-- 					<label>退房日期: </label> -->
<!-- 					<input name="rdateEnd" type="date" /> -->
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>


			<c:choose>
				<c:when test="${not empty room_accounts}">
					<div class="bormm">
						<label class="bormt">總價: </label> <p>${room_accounts}</p>
					</div>
				</c:when>
			</c:choose>

			<div>
				<label class="bormt">付款方式: </label> <select name="bill_status">
					<option selected>請選擇付款方式</option>
					<option value="現金">現金</option>
					<option value="信用卡">信用卡</option>
				</select>
			</div>
			
			<div>
				<label class="bormt">住房人數: </label><input type="text" name="roomnum_of_people" class="bodsm">
			</div>

			<div>
<!-- 				onclick="location.href='http://localhost:8080/YunHotel/ordered/room/checkoutUpdate'" -->
				<button type ="submit" class="bormb">結帳</button>
			</div>

			<%-- 			<c:choose> --%>
			<%-- 				<c:when test="${not empty ${ordered_status}"> --%>
			<!-- 					<div> -->
			<!-- 						<label>訂單狀態: </label> <select name="ordered_status"> -->
			<!-- 							<option disabled>請選擇訂單狀態</option> -->
			<!-- 							<option value="已成立">已成立</option> -->
			<!-- 							<option value="已結單">已結單</option> -->
			<!-- 						</select> -->
			<!-- 					</div> -->
			<%-- 				</c:when> --%>
			<%-- 				<c:otherwise> --%>
			<%-- 				</c:otherwise> --%>
			<%-- 			</c:choose> --%>


		</form>
			</div>
        </div>
        	
     </div>

</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>