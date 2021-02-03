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
<title>UpdateNew</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	

<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">修改消息</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        		
		<form  method="POST"  style="margin-left: 350px;">
			<div class="labelpos">
				<label>消息更新時間：</label> <input class="input" name="news_updated_date" type="date"/>
			</div>
			<div class="labelpos">
				<label>消息內容：</label> <input class="input" name="news_content" value="${Ncon}" id="News"/>
			</div>
			<div class="labelpos">
				<input class="backbtn" value="修改" type="submit">
<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
				</div>
        </div>
        	
     </div>

</div>
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	    <button id="btn"></button>
	<script type="text/javascript">
	
	
	
		//抓與按鈕
		let myBtn = document.getElementById("btn");
		//設定點擊事件
		myBtn
				.addEventListener(
						"click",
						function() {
							//設定預先輸入的值
							let defaultType = "2020/12/01起，入住本飯店或用餐之賓客一律配戴口罩進場以及取餐，謝謝您的配合，如造成不便，敬請見諒。";
			
					

							//抓取目標input並填入值
							document.getElementById("News").value = defaultType;
		
						})

		//增加鍵盤敲擊事件
		document
				.addEventListener(
						"keydown",
						function(event) {
							if (event.key == "x") { //如果按下的鍵為x鍵
								//設定預先輸入的值
						    let defaultType = "2020/12/01起，入住本飯店或用餐之賓客一律配戴口罩進場以及取餐，謝謝您的配合，如造成不便，敬請見諒。";
				
					

								//抓取目標input並填入值
							document.getElementById("News").value = defaultType;
					
							}
						})
					
			
	</script>
	
</body>
</html>