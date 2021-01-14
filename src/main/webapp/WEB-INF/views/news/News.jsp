<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>消息</title>
</head>
<body>
<div align='center'>
		<h3>消息</h3>
		<hr>
		<table border='1'>
			<tr>
				<th width='60'>時間</th>
				<th width='160'>消息內容</th>
			</tr>
			<c:choose>
<%-- 				<c:when test="${not empty customerBeanList}"> --%>
					<c:forEach var='news' items="${NewsList}">
						<tr>
							<td align='center'><a
								href='modifyNews/${news.news_id}'>${news.news_updated_date}</a></td>
							<td>${news.news_content}</td>
						</tr>
					</c:forEach>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<!-- 				查無Customer資料 -->
<%-- 			</c:otherwise> --%>
			</c:choose>
		</table>
		<br> <a href="<c:url value='../index' />">回首頁</a>
	</div>
</body>
</html>