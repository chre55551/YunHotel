<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>輸入退房結帳資訊</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<form action="/YunHotel/ordered/thisCheckoutRoomOd" method="POST"
			class="container">
			<div>
				<label>房號: </label> <select name="room_name">
					<option>請選擇用餐時間</option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>
				</select>
			</div>
			<div>
				<label>入住日期: </label> <input name="rdate" type="date" /> <br />
			</div>
			<div>
				<label>退房日期: </label> <input name="rdateEnd" type="date" />
			</div>
			<div>
				<label>總價: </label> <input name="room_accounts " type="text" />
			</div>
			<div>
				<label>付款方式: </label> <select name="payment_status" id="requestPS">
					<option value="">請選擇付款方式</option>
					<option value="現金" selected>現金</option>
					<option value="信用卡">信用卡</option>
				</select>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>