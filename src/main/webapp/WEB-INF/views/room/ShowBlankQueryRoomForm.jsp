<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Show Blank Query Room Form</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">查詢房間</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        		
		<form action="/YunHotel/room/ShowQueryRoom" method="Post" style="margin-left: 350px;">
			<div class="labelpos">
				<label>房型ID</label> <input class="input" name="room_typeid"/>
			</div>
			
				<div class="labelpos">
				<input class="backbtn" value="查詢" type="submit">
                 <input class="backbtn" value="清除" type="reset" >
            	</div>
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			
		</form>
				</div>
        </div>
        	
     </div>

</div>
    
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	<script type="text/javascript">



	</script>
</body>
</html>