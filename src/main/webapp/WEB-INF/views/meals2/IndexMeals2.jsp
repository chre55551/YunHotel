<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Index Meals</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
    
     <div class="right">
     <p class="title">餐點</p>
     <p class="hr"></p>
        
     <div class="litlte_allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        	
            <ul class="ALLdiamond">
           
            <li class="diamond">
                <a href="ShowMeals2" class="diamondtxt">所有餐點</a>
            </li>
            <li class="diamond">
                <a href="AddMeals2" class="diamondtxt">新增餐點</a>
            </li>
            <li class="diamond">
                <a href="ShowBlankQueryMealsForm" class="diamondtxt">查詢餐點</a>
          
            
            
            
            
            

            </ul>
            </div>
        </div>
    </div>

  <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>