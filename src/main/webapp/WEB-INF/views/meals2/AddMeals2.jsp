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
<title>AddMeals2</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">新增餐點</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        		
		<form action="/YunHotel/meals2/insertMeals2" method="POST" style="margin-left: 350px;">
<!-- 			<div> -->
<!-- 				<label>編號：</label> <input name="news_id"/> -->
<!-- 			</div> -->
			<div class="labelpos">
				<label>餐點類型：</label> <input class="input" name="meals2_type" />
			</div>
			<div class="labelpos">
				<label>餐點名稱：</label> <input class="input" name="meals2_name"/>
			</div>
			<div class="labelpos">
				<label>餐點價格：</label> <input class="input" name="meals2_price"/>
			</div>
			<div class="labelpos">
				<label>餐點庫存：</label> <input class="input" name="meals2_stock"/>
			</div>
			
			
			
			
			<div class="labelpos">
				<input class="backbtn" value="新增" type="submit">
				<input class="backbtn" value="清除" type="reset" >
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
		</div>
        </div>
        	
     </div>

</div>
	
	
	    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>