<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>GetaNew</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	

<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">查詢消息</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle"  style="margin-left: 350px;">
        		
	<h3>查詢第${NWS.news_id}則的消息</h3>
	<p>編號: ${NWS.news_id}</p>
	<p>上傳時間: ${NWS.news_date}</p>
	<p>更新時間: ${NWS.news_updated_date}</p>
	<p>消息內容: ${NWS.news_content}</p>
		<a href="<c:url value='newsindex'/> ">回上一頁</a>
		<a href="<c:url value='update/${NWS.news_id}'/> ">修改消息</a>
				</div>
        </div>
        	
     </div>

</div>

<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>