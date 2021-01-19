<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增消息</title>
</head>
<body>
<div align='center'>
		<h3>消息</h3>
		<hr>
		<form action="showinsertNews" method="get" modelAttribute="nws"
				id="nwsid">
        	消息編號：<input type="text" name="news_id"/> <br><br>
            消息上傳時間：<input type="text" name="news_date"/> <br><br>
            消息更新時間：<input type="text" name="news_updated_date"/> <br><br>
            消息內容：<input type="text" name="news_content"/> <br><br>

			<input type="submit" value="提交"/>
		</form>
		
		<br> <a href="<c:url value='../index' />">回首頁</a>
	</div>
</body>
</html>