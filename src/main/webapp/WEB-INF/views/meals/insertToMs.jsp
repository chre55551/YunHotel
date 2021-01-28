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
<title>insert To Ms</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
          	<h3>新增餐點</h3>
		<form action="/YunHotel/meals/InsertMeals" method="POST" class="container" enctype="multipart/form-data" >
			<div>
				<label>餐點名稱</label> <input name="meals_name" id="requestMealsName" />
			</div>
			<div>
				<label>餐點價格</label> <input name="meals_price" id="requestMealsPrice" />
			</div>
			<div>
				<label>餐點總數</label> <input name="meals_stock" id="requestMealsStock" />
			</div>
			<div>
				<label>餐點圖片</label> 
				 <input type="file" name="meals_image" id="requestMealsImage" onchange="">
			</div>
			
	
			<div>
				<input value="新增" type="submit">
                 <input value="清除" type="reset" >                       
            </div>
	   </form>                    
            </div>
    

  <%@ include file="../CommonTemplates/footer.jsp"%>

</body>
</html>