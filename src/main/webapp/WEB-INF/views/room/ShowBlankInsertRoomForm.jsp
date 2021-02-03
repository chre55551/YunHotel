<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/backstage.css'  type="text/css"/>
<title>Show Blank Insert Room Form</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">新增房間</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        		
		<form action="/YunHotel/room/InsertRoom" method="POST" enctype="multipart/form-data"  style="margin-left: 350px;" >
			<div class="labelpos">
				<label>房型名稱</label> <input class="input" name="room_type" id="rType" />
			</div>
			<div class="labelpos">
				<label>房價</label> <input class="input" name="room_price" id="rPrice" />
			</div>
			<div class="labelpos">
				<label>房型總數</label> <input class="input" name="room_stock" id="rStock" />
			</div>
<!-- 			<div> -->
<!-- 				<label>房型圖片</label>  -->
<!-- 				 <input type="file" name="room_image" id="requestRoomImage" onchange=""> -->
<!-- 			</div> -->
			
	
			<div class="labelpos">
				<input class="backbtn" value="新增" type="submit">
                 <input class="backbtn" value="清除" type="reset" >                       
            </div>
	   </form>                    
				</div>
        </div>
        	
     </div>

</div>
    

  <%@ include file="../CommonTemplates/footer.jsp"%>
	    			<button id="btn"></button>
				
	    		<script>
					//抓與按鈕
					let myBtn = document.getElementById("btn");
					//設定點擊事件
					myBtn
							.addEventListener(
									"click",
									function() {
										//設定預先輸入的值
										let defaultType = "豪華三人房";				
										let defaultPrice = "7600";
										let defaultStock = "30";
								

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
										let defaultType = "豪華三人房";				
										let defaultPrice = "7600";
										let defaultStock = "30";
								

											//抓取目標input並填入值
										document.getElementById("rType").value = defaultType;
										document.getElementById("rPrice").value = defaultPrice;
										document.getElementById("rStock").value = defaultStock;
										}
									})
								
						
				</script>
</body>
</html>