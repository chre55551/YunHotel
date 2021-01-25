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
<title>依日期查詢</title>
</head>
  <body>
    <%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<table class="mytable" class="container">
			<%@ include file="../CommonTemplates/leftmenu.jsp"%>
			<thead>
				<tr>
					<th>日期</th>
					<td><input id="phone" type="date">
				</tr>
				<tr>
					<td>
						<div class="mycenter">
							<button id="peko">查詢</button>
						</div>
					</td>
				</tr>
			</thead>
		</table>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>

 
  </body>
</html>