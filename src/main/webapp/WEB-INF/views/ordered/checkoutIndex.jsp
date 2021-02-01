<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>選擇結帳類型</title>
</head>
<body>
<body>
 
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
        	
    <div class="right">
        <p class="title">結帳</p>
        <p class="hr"></p>
        
     <div class="litlte_allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        	
            <ul class="ALLdiamond">             
            <li class="diamond">
              <a href="../checkoutMealsOd" class="diamondtxt">餐廳結帳</a>
            </li>
            <li class="diamond">
                 <a href="../checkout/checkoutQueryRoomOd" class="diamondtxt">房務結帳</a>
            </li>
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</body>
</html>