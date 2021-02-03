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
<title>ThisOrdered</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">詳細訂單</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">

			<p>訂單編號: ${ordered.ordered_number}</p>
			<p>姓名: ${ordered.customer.chinese_name}</p>
			<p>電話: ${ordered.customer.mobile_phone}</p>

			<c:choose>
				<c:when test="${not empty ordered.customer.birthday}">
					<p>生日: ${ordered.customer.birthday}</p>
				</c:when>
				<c:otherwise>
    				生日: 無
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered.customer.idcard_number}">
					<p>身分證字號: ${ordered.customer.idcard_number}</p>
				</c:when>
				<c:otherwise>
    				身分證字號: 無
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered.customer.address}">
					<p>地址: ${ordered.customer.address}</p>
				</c:when>
				<c:otherwise>
    				地址: 無
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered.orderedStatus.ordered_status}">
					<p>訂單狀態: ${ordered.orderedStatus.ordered_status}</p>
				</c:when>
				<c:otherwise>
    				訂單狀態: 無
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered.orderedPayment.bill_status}">
					<p>付款方式: ${ordered.orderedPayment.bill_status}</p>
				</c:when>
				<c:otherwise>
    				付款方式: 無
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when
					test="${not empty ordered.orderedToMeals.mealsnum_of_people}">
					<p>用餐人數: ${ordered.orderedToMeals.mealsnum_of_people}</p>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty mdate.mdate}">
					<p>用餐日期: ${mdate.mdate}</p>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty mdate.time_period}">
					<p>用餐時段: ${mdate.time_period}</p>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty room.room_name}">
					<p>房號: ${room.room_name}</p>
				</c:when>
				<c:otherwise>
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty roomType.room_type}">
					<p>房型: ${roomType.room_type}</p>
				</c:when>
				<c:otherwise>
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty rdates}">
					<p>欲訂房日期:</p>
					<c:forEach var="rdate" items="${rdates}">
						<p>${rdate.rdate}</p>
					</c:forEach>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered.ordered_accounts}">
					<p>訂單總價: ${ordered.ordered_accounts}</p>
				</c:when>
				<c:otherwise>
    				訂單總價: 無
   				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered.ordered_date}">
					<p>訂單成立時間: ${ordered.ordered_date}</p>
				</c:when>
				<c:otherwise>
					<!--     				訂單成立時間: 無 -->
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered_last_update}">
					<p>訂單修改時間: ${ordered.ordered_last_update}</p>
				</c:when>
				<c:otherwise>
					<!--     				訂單修改時間: 無 -->
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty ordered.note}">
					<p>備註: ${ordered.note}</p>
				</c:when>
				<c:otherwise>
    				備註: 無
   				</c:otherwise>
			</c:choose>

			<br> <input class="backbtn" type="button" value="修改" id="uuu"> 
			<input  class="backbtn" type="button" value="刪除" id="xxx"> 
			<input  class="backbtn" type="button" value="回查詢" onclick="location.href='../customerToOrdered'">
			<%-- 			<a href="<c:url value='../customerToOrdered'/> ">回查詢</a> --%>

				</div>
        </div>
        	
     </div>

</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>

	<script type="text/javascript">
		$('#uuu').click(function() {
			location.href = '../update/' + ${ordered.ordered_number}
		})

		$('#xxx').click(function() {
			location.href = '../DeleteOrdred/' + ${ordered.ordered_number}
		})
	</script>
</body>
</html>