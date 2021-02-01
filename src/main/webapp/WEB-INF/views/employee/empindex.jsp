<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css' type="text/css" />
<title>Employee</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

    <div class="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
        	
        <div class="right">
        <p class="title">員工</p>
        <p class="hr"></p>
        
     <div class="litlte_allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        	
            <ul class="ALLdiamond">             
            <li class="diamond_M">
              <a href="insertEmployee" class="diamondtxt_M">&emsp;新增員工資料</a>
            </li>
            <li class="diamond_M">
                 <a href="queryEmployee" class="diamondtxt_M">&emsp;查詢員工資料</a>
            </li>
<!--             <li class="diamond"> -->
<!--                 <div class="diamondtxt">修改員工資料</div> -->
<!--             </li> -->
<!--             <li class="diamond"> -->
<!--                 <div class="diamondtxt">刪除員工資料</div> -->
<!--             </li> -->
            </ul>
        </div>
    </div>

    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>