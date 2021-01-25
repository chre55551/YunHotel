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

        <div class="container">
            <ul class="ALLdiamond">
            
            
                
  
            <li class="diamond">
                <a href="ShowBmember" class="diamondtxt">顯示所有會員</a>
            </li>
            <li class="diamond">
                <a href="InsertBmemberBM" class="diamondtxt">新增會員</a>
            </li>
            <li class="diamond">
                <a href="QueryBmember" class="diamondtxt">查詢會員</a>
            </li>
           
            
            
            

            </ul>
        </div>
    </div>

  <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>