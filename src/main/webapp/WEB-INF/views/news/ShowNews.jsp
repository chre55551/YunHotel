<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/indexcss.css'  type="text/css"/>
<title>消息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
    <!-- Bootstrapt插件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div align='center'>
		<h3>消息</h3>
		<hr>
		<table border='1'>
			<tr>
				<th width='30'>no.</th>
				<th width='60'>上傳時間</th>
        		<th width='60'>更新時間</th>
        		<th width='160'>消息內容</th>
			</tr>
			<c:choose>

					<c:forEach var='news' items="${NewsList}">
						<tr>
							<td align='center'>
							<a href='GetAllNews/${NWS.news_id}'>
							${NWS.news_id}</a></td>
							<td>${NWS.news_date}</td>
							<td>${NWS.news_updated_date}</td>
							<td>${NWS.news_content}</td>
						</tr>
					</c:forEach>

			</c:choose>
		</table>
		<br> <a href="<c:url value='../index' />">回首頁</a>
	</div>
</body>
</html>