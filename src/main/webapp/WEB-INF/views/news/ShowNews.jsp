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
<title>ShowNews</title>
</head>
<body>
<div align='center'>
<h3>全部消息</h3>
<form method='POST'>
	<input type='hidden' name='_method' value='DELETE'>
</form>

<c:choose>
	<c:when test="${empty NWS}">
	    沒有任何資料<br> 
	</c:when>
	<c:otherwise>
		<table border='1' cellpadding="3" cellspacing="1" >
			<tr>
			   <th width='56'>編號</th>
			   <th width='130'>上傳時間</th>
			   <th width='130'>更新時間</th>
			   <th width='180'>消息內容</th>
			</tr>
			<c:forEach var='news' items='${NWS}'>
				<tr>
					<td style="text-align:center">${NWS.news_id}</td>
					<td style="text-align:center">${NWS.news_date}</td>
					<td style="text-align:center">${NWS.news_updated_date}</td>
					<td style="text-align:center">${NWS.news_content}</td>
					
					 <td><a
                        href="${pageContext.request.contextPath}/news/${NWS.news_id}">編輯</a></td>
                    <td><a class='deletelink'
                        href="${pageContext.request.contextPath}/news/${NWS.news_id}">刪除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
<hr>
</div>
<script type='text/javascript'>
    $(document).ready(function() {
        $('.deletelink').click(function() {
        	if (confirm('確定刪除此筆紀錄? ')) {
        		var href = $(this).attr('href');
                $('form').attr('action', href).submit();
        	} 
        	return false;
            
        });
    })
</script>
</body>
</html>