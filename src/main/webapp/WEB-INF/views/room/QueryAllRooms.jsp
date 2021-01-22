<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Query All Rooms</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<table class="mytable" id="container">
			<%@ include file="../CommonTemplates/leftmenu.jsp"%>
			<thead>
				<tr>
					<th>姓名</th>
					<td><input id="name" type="text">
					<th>電話</th>
					<td><input id="phone" type="text">
						<button></button></td>
					<td><input type="radio" name="r" id="status1" value="1">
						<label for="status1"> 已成立 </label> <input type="radio" name="r"
						id="status2" value="2"> <label for="status2"> 已結單
					</label> <input type="radio" name="r" id="status3" value="3"> <label
						for="status3"> 全部 </label></td>
				</tr>
				<tr>
					<td>
						<div class="mycenter">
							<button id="peko">查詢</button>
							
						</div>
					</td>
				</tr>
				<c:forEach var="xx" items="rom" >
				<tr>
　					<td>${xx.}</td>
　					<td>這裡可以放表格內容</td>
　					<td>這裡可以放表格內容</td>
　					<td>這裡可以放表格內容</td>
　					<td>這裡可以放表格內容</td>
　				</tr>
				</c:forEach>
			</thead>
		</table>
    </div>

  <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>