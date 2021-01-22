<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Show Blank Room form</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

       
         
           
          		<h3>新增房間</h3>
		<form:form action="/room/InsertRoom" method="POST" id="container" modelAttribute="roo" >
			<div>
				<label>房型名稱</label> <input name="room_type" id="requestRoomType" />
			</div>
			<div>
				<label>房價</label> <input name="room_price" id="requestRoomPrice" />
			</div>
			<div>
				<label>房型總數</label> <input name="room_stock" id="requestRoomStock" />
			</div>
			<div>
				<label>房型圖片</label> 
				 <input type="file"name="room_image" id="requestRoomImage" onchange="fileShow();" accept="image/*">
			</div>
			
	
			<div>
				<input value="新增" type="submit">
                 <input value="清除" type="reset" >

            
            
            	</div>
		</form:form>
            
            

           
        </div>
    

  <%@ include file="../CommonTemplates/footer.jsp"%>

</body>
</html>