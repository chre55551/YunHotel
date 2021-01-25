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
		<div class="container">
			<h3>詳細訂單</h3>
			<p>訂單編號: ${ordered.ordered_number}</p>
			<p>姓名: ${ordered.customer.chinese_name}</p>
			<p>電話: ${ordered.customer.mobile_phone}</p>
			<p>桌號: ${ordered.orderedToMeals.table_number}</p>
			<p>房號: ${ordered.orderedToRoom.room_number}</p>
			<p>訂單狀態: ${ordered.orderedStatus.ordered_status}</p>
			<p>付款方式: ${ordered.orderedPayment.payment_status}</p>
			<p>訂單總價: ${ordered.ordered_accounts}</p>
			<p>訂單成立時間: ${ordered.ordered_date}</p>
			<p>備註: ${ordered.note}</p>
			<br> <input type="button" value="修改" id="uuu"> 
				<input type="button" value="刪除" id ="xxx">
			<input type="button" value="回查詢"
				onclick="location.href='../customerToOrdered'">
			<%-- 			<a href="<c:url value='../customerToOrdered'/> ">回查詢</a> --%>

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