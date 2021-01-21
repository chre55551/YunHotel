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

    <div id="main">
        	<%@ include file="../CommonTemplates/leftmenu.jsp"%>

        <div id="container">
            <ul id="ALLdiamond">
            
            
                
  
            <li id="diamond">
                <a href="" class="diamondtxt">所有餐點</a>
            </li>
            <li id="diamond">
                <a href="insertRoom" class="diamondtxt">新增餐點</a>
            </li>
            <li id="diamond">
                <a href="" class="diamondtxt">查詢餐點</a>
            </li>
            <li id="diamond">
                <a href="" class="diamondtxt">修改餐點</a>
            </li>
            <li id="diamond">
                <a href="" class="diamondtxt">刪除餐點</a>
            </li>
            
            
            
            
            

            </ul>
        </div>
    </div>

  <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>