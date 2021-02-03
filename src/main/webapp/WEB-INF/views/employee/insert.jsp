<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>Insert</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>

<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">新增員工資料</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        <divstyle="text-align:center;">
            <ul class="ALLdiamond">
                
            <li class="diamond" >
                <a href="insertEmp" class="diamondtxt" >員工資料</a>
            </li>
<!--             <li class="diamond"> -->
<!--               <a href="insertSch" class="diamondtxt">排班</a> -->
<!--             </li> -->
            </ul>
				</div>
        </div>
        	
     </div>

</div>
    <%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>