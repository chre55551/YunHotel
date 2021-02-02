<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Show Blank Query Meals Form</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	

	<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>查詢</h3>
		<form action="/YunHotel/room/ShowMealsRoom" method="Post" class="container">
			<div>
				<label>餐點ID</label> <input name="meals_id"/>
			</div>
			
						<div>
				<input value="查詢" type="submit">
                 <input value="清除" type="reset" >

            
            
            	</div>
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			
		</form>
	</div>
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">



	</script>
</body>
</html>