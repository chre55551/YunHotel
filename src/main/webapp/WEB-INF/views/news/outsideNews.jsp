<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>訂位</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="../CommonTemplates/Indexheader.jsp"%>

		<div class="main">
		
		
	<table border='1' cellpadding="3" cellspacing="1" >
			<tr>
			   <th width='56' height='20'>編號</th>
			   <th width='130' height='20'>上傳時間</th>
			   <th width='130' height='20'>更新時間</th>
			   <th width='180' height='20'>消息內容</th>
			   <th colspan='2' height='20'>維護</th>
			</tr>
			<c:forEach var='NWS' items='${newsList}'>
				<tr>
					<td style="text-align:center">${NWS.news_id}</td>
					<td style="text-align:center">${NWS.news_date}</td>
					<td style="text-align:center">${NWS.news_updated_date}</td>
					<td style="text-align:center">${NWS.news_content}</td>
					
					 <td><a
                        href="${pageContext.request.contextPath}/news/update/${NWS.news_id}">編輯</a></td>
                    <td><a
                        href="${pageContext.request.contextPath}/news/DeleteNew/${NWS.news_id}">刪除</a></td>
				</tr>
			</c:forEach>
		
		</table>
		
		
			<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
		</div>
		<%@ include file="../CommonTemplates/footer.jsp"%>


	<script
		src="${pageContext.request.contextPath}/js/Yun_js/SharedFunctions.js"></script>

</body>
</html>