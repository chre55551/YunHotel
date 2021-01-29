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
<title>Update Room</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>修改房型</h3>
		<form  method="POST" class="container">
		
		
		
		
			<div>
				<label>房型名稱：</label> <input name="room_type_room_type" value="${Rtype}"/>
			</div>
			<div>
				<label>房價：</label> <input name="room_type_room_price" value="${Rprice}"/>
			</div>
			<div>
				<label>房型總數：</label> <input name="room_type_room_stock" value="${Rstock}"/>
			</div>
			<p id="myImg">房間圖片:</p>
			<div>
				<label>房型圖片</label> 
				 <input type="file" name="room_type_room_Image"  onchange="">
			</div>
			<div>
				<input value="修改" type="submit">
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script>
	fetch('http://localhost:8080/YunHotel/room/getImg?room_typeid=${Rid}')
	  .then(function(response) {
	    return response.blob();
	  })
	  .then(function(data) {
		  let img = document.createElement('IMG')
			img.src = URL.createObjectURL(data); //創立一個暫時的圖片路徑

			document.querySelector('#myImg').appendChild(img);
	  });

	
	</script>
</body>
</html>