<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ThisOrdered</title>
</head>
<body>
	<h3>詳細訂單</h3>
	<p>訂單編號: ${ordered.ordered_number}</p>
	<p>顧客編號: ${ordered.customer_id}</p>
	<p>餐點訂單: ${ordered.ordered_tomeals_id}</p>
	<p>房間訂單: ${ordered.ordered_toroom_id}</p>
	<p>訂單狀態: ${ordered_status}</p>
	<p>付款方式: ${payment_status}</p>
	<p>訂單總價: ${ordered.ordered_accounts}</p>
	<p>訂單日期: ${ordered.ordered_date}</p>
	<p>備註: ${ordered.note}</p>
</body>
</html>