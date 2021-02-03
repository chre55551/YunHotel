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
<title>Show Insert Room</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">新增完成</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">

		<h3>房型名稱：${rom.room_type}</h3>
		<h3>房價: ${rom.room_price}</h3>
		<h3>房間數量: ${rom.room_stock}</h3>
<!-- 		<h3 id="myImg">房間圖片:</h3> -->
<%-- 		<h3>房間圖片名稱: ${rom.room_image_name}</h3> --%>
		<a href="<c:url value='IndexRoom'/> ">回房間</a>
				</div>
        </div>
        	
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