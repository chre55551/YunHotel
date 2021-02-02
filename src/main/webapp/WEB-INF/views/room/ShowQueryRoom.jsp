<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>Show Query Room</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>


	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
			<h3>查詢第${rom.room_typeid}的房型</h3>
			<p>編號: ${rom.room_typeid}</p>
			<p>房價: ${rom.room_price}</p>
			<p>庫存: ${rom.room_stock}</p>
<!-- 			<p id="myImg">房間圖片:</p> -->
<%-- 			<p>房間圖片名稱: ${rom.room_image_name}</p> --%>
			<a href="<c:url value='IndexRoom'/> ">回房務</a>
		</div>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
	<script>
	fetch('http://localhost:8080/YunHotel/room/getImg?room_typeid=${rom.room_typeid}')
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