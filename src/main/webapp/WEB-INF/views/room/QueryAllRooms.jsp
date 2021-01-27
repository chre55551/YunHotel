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
<title>Query All Rooms</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
<div align='center'>

		<table class="container" border='1' cellpadding="3" cellspacing="1" >
			<tr>
			   
			   <th width='130' height='20'>房型名稱</th>
			   <th width='130' height='20'>房價</th>
			   <th width='130' height='20'>房型總數</th>
			   <th width='180' height='20'>房型圖片</th>
			   <th colspan='2' height='20'>維護</th>
			</tr>
			<c:forEach var='rom' items='${roomTypeList}'>
				<tr>
					
					<td style="text-align:center">${rom.room_type}</td>
					<td style="text-align:center">${rom.room_price}</td>
					<td style="text-align:center">${rom.room_stock}</td>
					<td style="text-align:center">${rom.room_image}</td>
					
					 <td><a
                        href="${pageContext.request.contextPath}/room/update/${rom.room_typeid}">編輯</a></td>
                    <td><a
                        href="${pageContext.request.contextPath}/room/DeleteNew/${rom.room_typeid}">刪除</a></td>
				</tr>
			</c:forEach>
		
		</table>
<hr>
</div>
<script type='text/javascript'>
    $(document).ready(function() {
        $('.deletelink').click(function() {
        	if (confirm('確定刪除? ')) {
        		var href = $(this).attr('href');
                $('form').attr('action', href).submit();
        	} 
        	return false;
            
        });
    })
</script>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>