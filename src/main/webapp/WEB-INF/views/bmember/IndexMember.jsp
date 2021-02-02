<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>IndexMember</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">會員</p>
        <p class="hr"></p>
        
     <div class="litlte_allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        	
            <ul class="ALLdiamond">
            
            <li class="diamond_M">
                <a href="ShowBmember" class="diamondtxt_M">顯示後台所有會員</a>
            </li>
            <li class="diamond_M">
                <a href="InsertBmemberBM" class="diamondtxt_M">&emsp;新增後台會員</a>
            </li>
            <li class="diamond_M">
                <a href="QueryBmember" class="diamondtxt_M">&emsp;查詢後台會員</a>
            </li>
             <li class="diamond_M">
                <a href="ShowRMember" class="diamondtxt_M">&emsp;顯示顧客資料</a>
            </li>
           
            </ul>
        </div>
    </div>

  <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>