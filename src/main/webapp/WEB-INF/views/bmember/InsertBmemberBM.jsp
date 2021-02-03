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
	
    <div class="right">
        <p class="title">新增後台會員資料</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle" style="margin-left:350px;">
				<table>
				<form:form action="insertbmemberbb" method="post" modelAttribute="bb">
					<div class="labelpos">
						<label>帳號</label>
						<form:input class="input" path="bs_account" id="bsac" />
					</div>
					<div class="labelpos">
						<label>密碼</label>
						<form:input class="input" type="password" path="bs_password" id="bspwd" /></td>
					</div>
					<div class="labelpos">
						<label>信箱</label>
						<form:input class="input" path="bs_email" id="bsemail" />
					</div>
					<div class="labelpos">
						<label>權限</label>
						<form:input class="input" path="authority" id="bsau" />
					</div>
					<div class="labelpos">
						<label>使用者名稱</label>
						<form:input class="input" path="user_id" id="bsuser" />
					</div>
					<div class="labelpos">
						<a href="<c:url value='/'/> ">回首頁</a>
						<input class="backbtn" value="新增" type="submit">
					</div>
				
				</form:form>
			</table>
			</div>
			
        </div>
        	
     </div>

</div>
			<script>
				//抓與按鈕
				let myBtn = document.getElementById("btn");
				//設定點擊事件
				myBtn.addEventListener("click", function() {
					//設定預先輸入的值
					let defaultAccount = "chris";
					let defaultPwd = "12345";
					let defaultEmail = "12345@gmail.com";
					let defaultbsau = "經理";
					let defaultbsuser = "億勳";

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
										let defaultAccount = "chris";
										let defaultPwd = "12345";
										let defaultEmail = "12345@gmail.com";
										let defaultbsau = "經理";
										let defaultbsuser = "億勳";

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