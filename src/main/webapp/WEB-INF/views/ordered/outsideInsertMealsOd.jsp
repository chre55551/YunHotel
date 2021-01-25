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
<title>insertMealsOrdered</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>

	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增餐點訂單</h3>
		<form action="/YunHotel/ordered/insertMealsOrdered" method="POST"
			class="container">
			<div>
				<label>姓名</label> <input name="chinese_name" id="requestCn" />
			</div>
			<div>
				<label>手機</label> <input name="mobile_phone" id="requestMp" />
			</div>
			<div>
				<label>人數</label> <input name="mealsnum_of_people" id="requestMp" />
			</div>
			<div>
				<label>用餐日期</label> <input name="mdate" id="requestMp" type="date" />
			</div>
			<div>
				<label>用餐時段</label> <select name="time_period">
					<option value="11:00~13:00">上午十一點</option>
					<option value="13:00~15:00">下午一點</option>
					<option value="15:00~17:00">下午三點</option>
					<option value="17:00~19:00">下午五點</option>
					<option value="19:00~21:00">晚上七點</option>
				</select>
			</div>
			<div>
				<label>備註</label> <input name="note" id="requestNote" />
			</div>
			<div>
				<input value="新增" type="submit"> <input value="清除"
					type="reset">
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>