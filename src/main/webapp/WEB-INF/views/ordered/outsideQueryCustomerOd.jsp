<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>訂單查詢</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="../CommonTemplates/Indexheader.jsp"%>

	<div class="queryODBG">
		<input type="hidden" id="${odl}" value="${odl}">
		<c:forEach var="od" items="${odl}">
			<input type="hidden" id="${od.ordered_number}" value="${od}">
		</c:forEach>
		<div class="main">
			<div class="orm4">
				<table>
					<thead class="ormt2">
						<tr>
							<th>您的所有訂單</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th class="orthpos">訂單編號</th>
							<th class="orthpos">訂單類型</th>
							<th class="orthpos">訂單狀態</th>
							<th class="orthpos">成立時間</th>
						</tr>
						<c:forEach var="od" items="${odl}" varStatus="state">
							<tr>
								<td>${od.ordered_number}</td>
								<c:choose>
									<c:when test="${not empty od.orderedToMeals}">
										<td>餐廳訂單</td>
										<%-- 										<td>${otms[state.count-1].mealsnum_of_people}</td> --%>
										<%-- 										<td>${mdates[state.count-1].mdate}</td> --%>
										<%-- 										<td>${mdates[state.count-1].time_period}</td> --%>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${not empty od.orderedToRoom}">
										<td>房間訂單</td>
										<%-- 										<td>${room[state.count-1].room_name}</td> --%>
										<%-- 										<td>${room[state.count-1].roomType.room_type}</td> --%>
										<%-- 										<td>${rdate[state.count-1].rdate}</td> --%>
									</c:when>
								</c:choose>
								<%-- 								<td>${od.orderedPayment.bill_status}</td> --%>
								<td>${od.orderedStatus.ordered_status}</td>
								<td>${od.ordered_date}</td>
								<td><button  class="ormBtn" onclick="location.href='/YunHotel/ordered/outsidethisOrdered/${od.ordered_number}'">查詢</button></td>
								<td><button  class="ormBtn" id="cancel">取消訂單</button></td>
							</tr>
						</c:forEach>
					</tbody>
					<%-- 				<p>訂單編號: ${onum}</p> --%>
					<%-- 				<p>姓名: ${name}</p> --%>
					<%-- 				<p>手機: ${phone}</p> --%>
					<%-- 				<p>訂單時間: ${odate}</p> --%>
					<%-- 				<p>訂單狀態: ${ostatus}</p> --%>
					<%-- 				<p>付款方式: ${oBill}</p> --%>
					<!-- 				<br> <input class="ormBtn" type="button" value="回官網" -->
					<!-- 					onclick="location.href='http://localhost:8080/YunHotel/YunPage'"> -->
				</table>
			</div>
		</div>
	</div>

	<div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>

	<script type="text/javascript">
	$('#cancel').click(function(){
		$.ajax({
			url:'http://localhost:8080/YunHotel/ordered/outsideQueryCustomerOd/cancelOrdered'
			type:'POST'
			dataType:'json'
			success:function(data){
				$("#success").tml(data.msg);
			},
			error:function(){
				alert("不可修改");
			}
		})
	})
	</script>
</body>
</html>