<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>新增房間訂單</h3>
		<form action="/YunHotel/ordered/insertRoomOrdered" method="POST"
			class="container">
			<div id="basic">
				<div class="bormm2">
					<label class="bormt">姓名</label> <input name="chinese_name" class="bodsm" style="margin:auto"/>
					<label class="bormt">手機</label> <input name="mobile_phone" class="bodsm" style="margin:auto"/>
				</div>
			</div>
			<div class="bormm2">
				<label class="bormt">身分證</label> <input name="idcard_number" class="bodsm" style="margin:auto"/>
				<label class="bormt">生日</label> <input name="birthday" type="date" class="bodsm" style="margin:auto"/>
			</div>
			<div class="bormm2">
				<label class="bormt">地址</label> <input name="address" class="bodsm" style="margin:auto"/>
				<label class="bormt">房型</label> <select name="room_type" id="room_type" class="bodsm" style="margin:auto">
					<option selected>請選擇欲訂的房型</option>
					<option>普通兩人房</option>
					<option>豪華兩人房</option>
					<option>普通四人房</option>
					<option>豪華四人房</option>
					<option>副總統套房</option>
					<option>總統套房</option>
				</select>
			</div>
			<div id="QQQ" class="bormm2">
				<label class="bormt">欲入住日期</label> <input name="rdate" type="date" id="rdate" class="bodsm"/>
				<br /> <label class="bormt">欲退房日期</label> <input name="rdateEnd" type="date"
					id="rdateEnd" class="bodsm"/>
			</div>
			<div class="bormm2">
				<div>
					<div id="roomnum" class="bodsm"></div>
				</div>
				<button id="zzz" type="button" class="bormb">查詢</button>
			</div>
			<div class="bormm">
				<label class="bormt">備註</label> <input name="note" id="requestNote" class="bodsm"/>
			</div>
			<br>

			<div>
				<input value="新增" type="submit" class="bormb" style="margin-right: 20px"> <input value="清除"
					type="reset" class="bormb">
				<%-- 				<a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
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