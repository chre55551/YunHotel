<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/backstage.css'
	type="text/css" />
<title>UpdateOrdered</title>
<script type="text/javascript">
	var table_number = "" //後端抓的資料
	var room_number = ""
	var note = ""
	if (table_number == 0) {
		table_number = "未定位"
	} else if (room_number == 0) {
		room_number = "未定房"
	} else if (note == "null") {
		note = "無"
	}
</script>
</head>
<body>

	<%@ include file="../CommonTemplates/header.jsp"%>


	<div class="main">
		<%@ include file="../CommonTemplates/leftmenu.jsp"%>
		<h3>修改訂單</h3>
		<form action="../updatecheck/${updateOdered.ordered_number}"
			method="POST" class="container">
			<p>欲修改的 ${updateOdered.customer.chinese_name}, 訂單編號:
				${updateOdered.ordered_number}</p>
			<c:choose>
				<c:when test="${not empty OTR}">
					<div>
						<label>生日: </label> <input name="birthday" type="date"
							value="${updateOdered.customer.birthday}" />
					</div>
				</c:when>
				<c:otherwise>
<!-- 					<label>生日: </label> -->
<!-- 					<input name="birthday" type="date" /> -->
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty OTR}">
					<div>
						<label>身分證字號: </label> <input name="idcard_number" type="text"
							value="${updateOdered.customer.idcard_number}" />
					</div>
				</c:when>
				<c:otherwise>
<!-- 					<label>身分證字號: </label> -->
<!-- 					<input name="idcard_number" type="text" /> -->
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty OTR}">
					<div>
						<label>地址: </label> <input name="address" type="text"
							value="${updateOdered.customer.address}" />
					</div>
				</c:when>
				<c:otherwise>
<!-- 					<label>地址: </label> -->
<!-- 					<input name="address" type="text" /> -->
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${roomType.room_type=='豪華兩人房'}">
					<div>
						<label>房型</label> 
						<select name="room_type" id="room_type" >
   							<option disabled>請選擇欲訂的房型</option>
   							<option>普通兩人房</option>
   							<option selected>豪華兩人房</option>
   							<option>普通四人房</option>
 							<option>豪華四人房</option>
    						<option>副總統套房</option>
    						<option>總統套房</option>
						</select>
					</div>
				</c:when>
				<c:when test="${roomType.room_type=='普通四人房'}">
					<div>
						<label>房型</label> 
						<select name="room_type" id="room_type" >
   							<option disabled>請選擇欲訂的房型</option>
   							<option>普通兩人房</option>
   							<option>豪華兩人房</option>
   							<option selected>普通四人房</option>
 							<option>豪華四人房</option>
    						<option>副總統套房</option>
    						<option>總統套房</option>
						</select>
					</div>
				</c:when>
				<c:when test="${roomType.room_type=='豪華四人房'}">
					<div>
						<label>房型</label> 
						<select name="room_type" id="room_type" >
   							<option disabled>請選擇欲訂的房型</option>
   							<option>普通兩人房</option>
   							<option>豪華兩人房</option>
   							<option>普通四人房</option>
 							<option selected>豪華四人房</option>
    						<option>副總統套房</option>
    						<option>總統套房</option>
						</select>
					</div>
				</c:when>
				<c:when test="${roomType.room_type=='副總統套房'}">
					<div>
						<label>房型</label> 
						<select name="room_type" id="room_type" >
   							<option disabled>請選擇欲訂的房型</option>
   							<option>普通兩人房</option>
   							<option>豪華兩人房</option>
   							<option>普通四人房</option>
 							<option>豪華四人房</option>
    						<option selected>副總統套房</option>
    						<option>總統套房</option>
						</select>
					</div>
				</c:when>
				<c:when test="${roomType.room_type=='總統套房'}">
					<div>
						<label>房型</label> 
						<select name="room_type" id="room_type" >
   							<option disabled>請選擇欲訂的房型</option>
   							<option>普通兩人房</option>
   							<option>豪華兩人房</option>
   							<option>普通四人房</option>
 							<option>豪華四人房</option>
    						<option>副總統套房</option>
    						<option selected>總統套房</option>
						</select>
					</div>
				</c:when>

				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty OTR}">
					<label>欲入住日期: </label>
					<div>
						<input name="rdate" type="date" id="rdate"
							value="${firstDay}" />
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${not empty OTR}">
					<label>欲退房日期: </label>
					<div>
						<input name="rdateEnd" type="date" id="rdateEnd"
							value="${lastDay}" />
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${not empty OTR}">
					<div>
						<div>
							<div id="roomnum"></div>
						</div>
						<button id="zzz" type="button">查詢</button>
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty OTM}">
					<div>
						<label>用餐人數: </label> <input name="mealsnum_of_people"
							value="${updateOdered.orderedToMeals.mealsnum_of_people}" />
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${not empty OTM}">
					<div>
						<label>用餐日期: </label> <input name="mdate" type="date"
							value="${Mdate.mdate}" />
					</div>
				</c:when>
				<c:otherwise>
<!-- 					<label>用餐日期: </label> -->
<!-- 					<input name="mdate" type="date" /> -->
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${time_period=='11:00~13:00'}">
					<div>
						<label>用餐時段: </label> <select name="time_period">
							<option disabled="disabled">請選擇用餐時段</option>
							<option value="11:00~13:00" selected="selected">11:00~13:00</option>
							<option value="13:00~15:00">13:00~15:00</option>
							<option value="15:00~17:00">15:00~17:00</option>
							<option value="17:00~19:00">17:00~19:00</option>
							<option value="19:00~21:00">19:00~21:00</option>
						</select>
					</div>
				</c:when>
				<c:when test="${time_period=='13:00~15:00'}">
					<div>
						<label>用餐時段: </label> <select name="time_period">
							<option disabled="disabled">請選擇用餐時段</option>
							<option value="11:00~13:00">11:00~13:00</option>
							<option value="13:00~15:00" selected="selected">13:00~15:00</option>
							<option value="15:00~17:00">15:00~17:00</option>
							<option value="17:00~19:00">17:00~19:00</option>
							<option value="19:00~21:00">19:00~21:00</option>
						</select>
					</div>
				</c:when>
				<c:when test="${time_period=='15:00~17:00'}">
					<div>
						<label>用餐時段: </label> <select name="time_period">
							<option disabled="disabled">請選擇用餐時段</option>
							<option value="11:00~13:00">11:00~13:00</option>
							<option value="13:00~15:00">13:00~15:00</option>
							<option value="15:00~17:00" selected="selected">15:00~17:00</option>
							<option value="17:00~19:00">17:00~19:00</option>
							<option value="19:00~21:00">19:00~21:00</option>
						</select>
					</div>
				</c:when>
				<c:when test="${time_period=='17:00~19:00'}">
					<div>
						<label>用餐時段: </label> <select name="time_period">
							<option disabled="disabled">請選擇用餐時段</option>
							<option value="11:00~13:00">11:00~13:00</option>
							<option value="13:00~15:00">13:00~15:00</option>
							<option value="15:00~17:00">15:00~17:00</option>
							<option value="17:00~19:00" selected="selected">17:00~19:00</option>
							<option value="19:00~21:00">19:00~21:00</option>
						</select>
					</div>
				</c:when>
				<c:when test="${time_period=='19:00~21:00'}">
					<div>
						<label>用餐時段: </label> <select name="time_period">
							<option disabled="disabled">請選擇用餐時段</option>
							<option value="11:00~13:00">11:00~13:00</option>
							<option value="13:00~15:00">13:00~15:00</option>
							<option value="15:00~17:00">15:00~17:00</option>
							<option value="17:00~19:00">17:00~19:00</option>
							<option value="19:00~21:00" selected="selected">19:00~21:00</option>
						</select>
					</div>
				</c:when>
				
				<c:otherwise>
				</c:otherwise>
			</c:choose>


					<div>
						<label>訂單狀態: </label>
						<!-- 				<input name="ordered_status" id="requestMp" /> -->
						<select name="ordered_status" id="requestOs">
							<option disabled>請選擇訂單狀態</option>
							<option value="已成立" selected>已成立</option>
							<option value="已結單">已結單</option>
							<option>已取消</option>
						</select>
					</div>


					<div>
						<label>付款方式: </label> <select name="bill_status" id="requestPS">
							<option disabled>請選擇付款方式</option>
							<option selected>現金</option>
							<option>信用卡</option>
						</select>
					</div>


			<c:choose>
				<c:when test="${not empty updateOdered.note}">
					<div>
						<label>備註</label> <input name="note" id="requestNote" type="text"
							${updateOdered.note} />
					</div>
				</c:when>
				<c:otherwise>
					<label>備註</label>
					<input name="note" id="requestNote" />
				</c:otherwise>
			</c:choose>

			<div>
				<input type="submit" value="修改"> <input value="清除"
					type="reset">
				<%-- <a href="<c:url value='indexOrdered'/> ">返回</a> --%>
			</div>
		</form>
	</div>

	<%@ include file="../CommonTemplates/footer.jsp"%>
	<script>
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
					this_data += '<label>房號</label> <select name="room_name"><option disabled>請選擇房號</option>';
					for(let room of fk){
						this_data += '<option value="">' + room.room_name + '</option>' ;
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
	</script>
</body>
</html>