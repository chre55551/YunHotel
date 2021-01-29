<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../CommonTemplates/Indexheader.jsp"%>
	<div class="ckeckinBG">
		<div class="main">
			<div class="orm3">
				<form action="/YunHotel/ordered/insertRoomOrdered" method="POST">
					<h4 class="ormt">新增房間訂單</h4>
					<div class="ormt">
						<label>房型</label> <select name="room_type" id="room_type"
							class="odsm">
							<option selected>請選擇欲訂的房型</option>
							<option>普通兩人房</option>
							<option>豪華兩人房</option>
							<option>普通四人房</option>
							<option>豪華四人房</option>
							<option>副總統套房</option>
							<option>總統套房</option>
						</select>
					</div>
					<div id="QQQ">
						<label>欲入住日期</label> <input name="rdate" type="date" id="rdate" value="${rdate}"/>
						<br /> <label>欲退房日期</label> <input name="rdateEnd" type="date" value="${rdateEnd}"
							id="rdateEnd" />
					</div>
					<div>
						<div class="ormt">
							<div id="roomnum" class="odsm"></div>
						</div>
						<button id="zzz" type="button" class="ormBtn">查詢</button>
					</div>
					<div class="ormt">
						<label>備註</label> <input name="note" id="requestNote" class="odsm" />
					</div>

					<div>
						<input value="新增" type="submit" class="ormBtn"> <input
							value="清除" type="reset" class="ormBtn">
					</div>
				</form>
			</div>
		</div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>
	<script>
// 	' + room.room_name + '
		$('#room_type').change(function(){
			$.ajax({
					url: 'http://localhost:8080/YunHotel/ordered/roomtype/to/allrooms',
					dataType: 'json',
					data:{
						room_type :$("#room_type").val()
					},
					type:'Get',
					success: function (data){
						let fk = data
						var this_data = '';
						this_data += '<label>房號</label> <select name="room_name"><option selected>請選擇房號</option>';
						for(let room of fk){
							this_data += '<option>' + room.room_name + '</option>' ;
						};
						this_data += '</select>';
						$('#roomnum').html(this_data);
					},
					error: function (d) {
			              alert('查無資料');
			            },
			})
			
		})
		
		$('#zzz').click(function(){
			$.ajax({
				url: 'http://localhost:8080/YunHotel/ordered/roomtype/to/availablerooms',
				dataType: 'json',
				type : 'POST',
				data:{
					room_type : $("#room_type").val(),
					rdate : $("#rdate").val(),
					rdateEnd : $("#rdateEnd").val()
 					},
					success: function (data){
						let fk = data
						var this_data = '';
						this_data += '<label>房號</label> <select name="room_name"><option selected>請選擇房號</option>';
						for(let room of fk){
							this_data += '<option>' + room.room_name + '</option>' ;
						};
						this_data += '</select>';
						$('#roomnum').html(this_data);
					},
					error: function (d) {
			              alert('查無資料');
			            },
				
			})
		})
		
//     	$('#QQQ').blur(function () {
//     		 $.ajax({
//     	            url: 'http://localhost:8080/YunHotel/ordered/roomtype/to/availablerooms',
//     	            dataType: 'json',
//     	            data: {chinese_name : $("#name").val(), 
//     	               mobile_phone : $("#phone").val(),
//     	               ordered_status : "已成立",
//     	            },
//     	            success:
//     		}
//     	}
	
	</script>
</body>
</html>