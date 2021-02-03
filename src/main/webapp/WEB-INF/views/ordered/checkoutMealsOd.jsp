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
<title>確認餐點結帳內容</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>

<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">確認餐點結帳內容</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        		
		<form action="../checkoutMealsOd/${updateOdered.ordered_number}"
			method="POST" style="margin-left:350px">

			<c:choose>
				<c:when test="${not empty ${meals_accounts}">
					<div>
						<label>總價: </label> <input name="meals_accounts " type="text"
							value="${room_accounts}" />
					</div>
				</c:when>
				<c:otherwise>
					<label>總價: </label>
					<input name="meals_accounts " type="text" />
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
        </div>
        	
     </div>

</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>