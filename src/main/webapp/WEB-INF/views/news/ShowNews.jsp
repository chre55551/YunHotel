<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowNews</title>
</head>
<body>
	<h3>全部消息</h3>
	<p>編號: ${NWS.news_id}</p>
	<p>上傳時間: ${NWS.news_date}</p>
	<p>更新時間: ${NWS.news_updated_date}</p>
	<p>消息內容: ${NWS.news_content}</p>
</body>
</html>