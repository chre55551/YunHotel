<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>GetaBmember</title>

<script type="text/javascript">
	function confirmDelete(id) {
		var result = confirm("確定刪除此筆記錄(帳號:" + id.trim() + ")?");
		if (result) {
			document.forms[0].putOrDelete.name = "_method";
			document.forms[0].putOrDelete.value = "DELETE";
			return true;
		}
		return false;
	}
	function confirmUpdate(id) {
		var result = confirm("確定送出此筆記錄(帳號:" + id.trim() + ")?");
		if (result) {
			// 		  document.forms[0].putOrDelete.name = "_method";
			// 		  document.forms[0].putOrDelete.value = "PUT";
			return true;
		}
		return false;
	}
</script>

</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
		<form:form method='POST' modelAttribute="BmemberBean">
		<input type="hidden" name="noname"  id='putOrDelete'   value="" >
    		<c:if test='${BmemberBean.bs_id != null}'>
               <form:hidden path="bs_id" /><br>&nbsp;
			</c:if>
<!-- 隱藏我的ID  -->
		
				<legend>客戶資料</legend>
				<table>
					<tr>
						<td>帳號</td>
						<td><form:input path="bs_account"/></td>

					</tr>
					<tr>
						<td>密碼</td>
						<td><form:input path="bs_password" /></td>

					</tr>
					<tr>
						<td>信箱</td>
						<td><form:input path="bs_email" /></td>

					</tr>
					<tr>
						<td>權限</td>
						<td><form:input path="authority" /></td>

					</tr>
					<tr>
						<td>使用者名稱</td>
						<td><form:input path="user_id" /></td>

					</tr>


					<tr>
						<td colspan='2' align='center'><input type='submit'
							value='修改' name='updateBtn'
							onclick="return confirmUpdate('${BmemberBean.bs_id}');">&nbsp;
							<input type='submit' value='刪除' name='deleteBtn'
							onclick="return confirmDelete('${BmemberBean.bs_id}');">
						</td>
					</tr>

				</table>
	
		</form:form>
		<a href="<c:url value='/' />">回首頁</a>
	</div>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>