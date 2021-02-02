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
<title>GetaBmember</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>


	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
			<h3>新增會員</h3>
			<a href="<c:url value='/'/> ">回首頁</a>
			<table>
				<form:form action="insertbmemberbb" method="post"
					modelAttribute="bb">
					<tr>
						<td>帳號</td>
						<td><form:input path="bs_account" id="bsac" /></td>

					</tr>
					<tr>
						<td>密碼</td>
						<td><form:input type="password" path="bs_password" id="bspwd" /></td>

					</tr>
					<tr>
						<td>信箱</td>
						<td><form:input path="bs_email" id="bsemail" /></td>

					</tr>
					<tr>
						<td>權限</td>
						<td><form:input path="authority" id="bsau" /></td>

					</tr>
					<tr>
						<td>使用者名稱</td>
						<td><form:input path="user_id" id="bsuser" /></td>

					</tr>

					<div>
						<input value="新增" type="submit">
					</div>
				</form:form>

			</table>
			<div>
				<button id="btn"></button>
			</div>
			<script>
				//抓與按鈕
				let myBtn = document.getElementById("btn");
				//設定點擊事件
				myBtn.addEventListener("click", function() {
					//設定預先輸入的值
					let defaultAccount = "poky";
					let defaultPwd = "12345";
					let defaultEmail = "123@gmail.com";
					let defaultbsau = "經理";
					let defaultbsuser = "小魏";

					//抓取目標input並填入值
					document.getElementById("bsac").value = defaultAccount;
					document.getElementById("bspwd").value = defaultPwd;
					document.getElementById("bsemail").value = defaultEmail;
					document.getElementById("bsau").value = defaultbsau;
					document.getElementById("bsuser").value = defaultbsuser;

				})

				//增加鍵盤敲擊事件
				document
						.addEventListener(
								"keydown",
								function(event) {
									if (event.key == "f") { //如果按下的鍵為f鍵
										//設定預先輸入的值
										let defaultAccount = "poky";
										let defaultPwd = "12345";
										let defaultEmail = "123@gmail.com";
										let defaultbsau = "經理";
										let defaultbsuser = "小魏";

										//抓取目標input並填入值
										document.getElementById("bsac").value = defaultAccount;
										document.getElementById("bspwd").value = defaultPwd;
										document.getElementById("bsemail").value = defaultEmail;
										document.getElementById("bsau").value = defaultbsau;
										document.getElementById("bsuser").value = defaultbsuser;
									}
								})
			</script>
</body>
</html>