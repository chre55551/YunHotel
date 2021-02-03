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
<title>Update Room</title>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>
	
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">修改房間</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        		
		<form  method="POST"  style="margin-left: 350px;">
		
			<div class="labelpos">
				<label>房型名稱：</label> <input class="input" name="room_type_room_type" value="${Rtype}" id="rType" />
			</div>
			<div class="labelpos">
				<label>房價：</label> <input  class="input" name="room_type_room_price" value="${Rprice}" id="rPrice"/>
			</div>
			<div class="labelpos">
				<label>房型總數：</label> <input class="input" name="room_type_room_stock" value="${Rstock}" id="rStock"/>
			</div>
<!-- 			<p id="myImg">房間圖片:</p> -->
<!-- 			<div> -->
<!-- 				<label>房型圖片</label>  -->
<!-- 				 <input type="file" name="room_type_room_Image"  onchange=""> -->
<!-- 			</div> -->
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
	<script>
// 	fetch('http://localhost:8080/YunHotel/room/getImg?room_typeid=${Rid}')
// 	  .then(function(response) {
// 	    return response.blob();
// 	  })
// 	  .then(function(data) {
// 		  let img = document.createElement('IMG')
// 			img.src = URL.createObjectURL(data); //創立一個暫時的圖片路徑

// 			document.querySelector('#myImg').appendChild(img);
// 	  });
  			
				
	    		
					//抓與按鈕
					let myBtn = document.getElementById("btn");
					//設定點擊事件
					myBtn
							.addEventListener(
									"click",
									function() {
										//設定預先輸入的值
										let defaultType = "高級套房";				
										let defaultPrice = "5800";
										let defaultStock = "50";
								

										//抓取目標input並填入值
										document.getElementById("rType").value = defaultType;	
										document.getElementById("rPrice").value = defaultPrice;
										document.getElementById("rStock").value = defaultStock;
										
									})

					//增加鍵盤敲擊事件
					document
							.addEventListener(
									"keydown",
									function(event) {
										if (event.key == "x") { //如果按下的鍵為x鍵
											//設定預先輸入的值
										let defaultType = "高級套房";				
										let defaultPrice = "5800";
										let defaultStock = "50";
								

											//抓取目標input並填入值
										document.getElementById("rType").value = defaultType;
										document.getElementById("rPrice").value = defaultPrice;
										document.getElementById("rStock").value = defaultStock;
										}
									})
								
						
				</script>
	
	
</body>
</html>