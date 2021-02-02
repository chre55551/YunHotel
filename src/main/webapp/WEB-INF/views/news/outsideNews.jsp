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
	href='${pageContext.request.contextPath}/css/news.css'
	type="text/css" />
<title>最新消息</title>
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

	<div class="BG">
		<div class="main">
		<div class="newsdiv">
		
		<table class="newsF_pos" border='1' cellpadding="3" cellspacing="1" >
			<tr>
			   <th class="newsF">時間</th>
			   <th class="newsFC">消息內容</th>
			</tr>
			<c:forEach var='NWS' items='${newsList}'>
				<tr>
					<td class="newsF">${NWS.news_updated_date}</td>
					<td class="newsFC">${NWS.news_content}</td>
				</tr>
			</c:forEach>
		
		</table>
		
		</div>
		</div>
		
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>


	<script
		src="${pageContext.request.contextPath}/js/Yun_js/SharedFunctions.js"></script>

</body>
</html>