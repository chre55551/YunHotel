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
<title>Insert Meals</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
	
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<div class="container">
		<h2>新增完成</h2><hr/>
		<h3>餐點名稱：${mes.room_type}</h3>
		<h3>餐點價格: ${mes.room_price}</h3>
		<h3 id="myImg">房間圖片:</h3>
		<h3>餐點圖片名稱: ${mes.room_image_name}</h3>
		<a href="<c:url value='IndexMeals'/> ">回餐點</a>
		</div>
	</div>
<%@ include file="../CommonTemplates/footer.jsp"%>

	<script>
	fetch('http://localhost:8080/YunHotel/meals/getImg?meals_id=${mes.meals_id}')
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