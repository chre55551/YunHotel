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
<script type="text/javascript">
	var table_number = "" //後端抓的資料
	var room_number = ""
	var note = ""
	if (table_number == 0) {
		table_number = "未定位"
	} else if (room_number == 0) {
		room_number = "未定房"
	} else if (note == "null") {
		note = "無"
	}
</script>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>


	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>修改訂單</h3>
		<form action="../updatecheck/${updateOdered.ordered_number}"
			method="POST" class="container">
			<p>欲修改的訂單編號: ${updateOdered.ordered_number}</p>
			<div>
				<label>生日: </label> <input name="birthday" />
			</div>
			<div>
				<label>身分證字號: </label> <input name="idcard_number" />
			</div>
			<div>
				<label>地址: </label> <input name="birthday" />
			</div>
			<div>
				<label>房號: </label> <input name="room_name" />
			</div>
			<div>
				<label>欲訂房日期: </label> <input name="rdate" />
			</div>
			<div>
				<label>用餐人數: </label> <input name="mealsnum_of_people" />
			</div>
			<div>
				<label>用餐日期: </label> <input name="mdate" />
			</div>
			<div>
				<label>用餐時段: </label> <select name="time_period">
					<option value="11:00~13:00">上午十一點</option>
					<option value="13:00~15:00">下午一點</option>
					<option value="15:00~17:00">下午三點</option>
					<option value="17:00~19:00">下午五點</option>
					<option value="19:00~21:00">晚上七點</option>
				</select>
			</div>
			<div>
				<label>總價: </label> <input name="ordered_accounts" />
			</div>
			<div>
				<label>訂單狀態: </label>
				<!-- 				<input name="ordered_status" id="requestMp" /> -->
				<select name="ordered_status" id="requestOs">
					<option value="">請選擇訂單狀態</option>
					<option value="已成立">已成立</option>
					<option value="已結單">已結單</option>
				</select>
			</div>
			<div>
				<label>付款方式: </label> <select name="payment_status" id="requestPS">
					<option value="">請選擇付款方式</option>
					<option value="現金">現金</option>
					<option value="信用卡">信用卡</option>
				</select>
			</div>
			<div>
				<label>訂單最後修改時間</label> <input name="ordered_last_update"
					id="requestOlu" type="date" />
			</div>
			<div>
				<label>備註</label> <input name="note" id="requestNote" />
			</div>
			<div>
				<input type="submit" value="修改"> <input value="清除"
					type="reset">
				<%-- <a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>