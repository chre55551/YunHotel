<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css' type="text/css" />
<title>後台</title>
</head>
<body>
<%@ include file="CommonTemplates/header.jsp"%>

<div class="main">
	<%@ include file="CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">首頁</p>
        <p class="hr"></p>
        		
        <div class="allcontent">
        	<div class="litletitle">	
        	</div>
        	
        	
        	<ul class="ALLdiamond">

				<li class="diamond">
					<a href="${pageContext.request.contextPath}/bmember/IndexMember" class="diamondtxt">&ensp;會員</a>
				</li>
				<li class="diamond">
					<a href="${pageContext.request.contextPath}/ordered/indexOrdered" class="diamondtxt">&ensp;訂單</a>
				</li>
				<li class="diamond">
					<a href="${pageContext.request.contextPath}/employee/empindex"  class="diamondtxt">&ensp;員工</a>
				</li>
				<li class="diamond">
					<a href="${pageContext.request.contextPath}/meals2/IndexMeals2" class="diamondtxt">&ensp;餐點</a>
				</li>
				<li class="diamond">
					<a href="${pageContext.request.contextPath}/room/IndexRoom" class="diamondtxt">&ensp;房間</a>
				</li>
				<p style="width:150px;height:80px; "></p>
				<li class="diamond">
					<a href="${pageContext.request.contextPath}/news/newsindex" class="diamondtxt">&ensp;消息</a>
				</li>
				<li class="diamond">
					<a href="${pageContext.request.contextPath}/ordered/checkoutIndex" class="diamondtxt">&ensp;結帳</a>
				</li>
			


            </ul>
            
        </div>
        	
     </div>

</div>
<%@ include file="CommonTemplates/footer.jsp"%>
</body>
</html>