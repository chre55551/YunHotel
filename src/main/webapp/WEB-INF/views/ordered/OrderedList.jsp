<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂單後台列表</title>
<style type="text/css">
#borderA {
   border:1px solid black;
}
</style>
</head>
<body>
<c:set var="Ordered" value="ORD" scope="session"/>

<!-- 	<!-- 引入共同的頁首 --> -->
<%-- 	<jsp:include page="" /> --%>
	<table style="margin-left:auto; margin-right:auto; width:810; background:#F5EBFF; border:2px solid blue; border-style: outset; ">

		<tr id='borderA' height='50' >
			<th id='borderA'  colspan="4" align="center">${ordered_number}的訂單明細</th>
		</tr>
		<tr id='borderA' height='36' >
			<th id='borderA'>訂單編號</th>
			<th id='borderA'>顧客編號</th>
			<th id='borderA'>餐點訂單編號</th>
			<th id='borderA'>房間訂單編號</th>
			<th id='borderA'>訂單狀態</th>
			<th id='borderA'>付款狀態</th>
			<th id='borderA'>訂單總價</th>
			<th id='borderA'>訂單日期</th>
			<th id='borderA'>發票編號</th>
			<th id='borderA'>備註</th>
		</tr>
<%-- 		<c:forEach var="Ordered" varStatus="stat" items="${memberOrders}"> --%>
<!-- 			<TR id='borderA' height='30'> -->
<!-- 			<TD id='borderA' width="86" align="center"> -->
<%-- 			    <a  href='<c:url value='orderDetail?memberId=${LoginOK.memberId}&orderNo=${anOrderBean.orderNo}' />'> --%>
<%-- 				    ${anOrderBean.orderNo} --%>
<!-- 			    </a> -->
<!-- 			</TD> -->
<%-- 			<TD id='borderA' width="100" align="center">${anOrderBean.orderDate}</TD> --%>
<%-- 			<TD id='borderA' width="80" align="right">${anOrderBean.totalAmount}</TD> --%>
<%-- 			<TD id='borderA' width="400" align="left">&nbsp;${anOrderBean.shippingAddress}</TD> --%>
							
<!-- 		</TR> -->
<%-- 		</c:forEach> --%>
<!-- 		<tr height='36' id='borderA'> -->
<%-- 			<td id='borderA' align="center" colspan="4"><a href="<c:url value='/' />">回首頁</a></td> --%>
<!-- 		</tr> -->
	</TABLE>
</body>
</html>