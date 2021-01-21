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
<title>依顧客查詢</title>
</head>
<body>
<%@ include file="../CommonTemplates/header.jsp"%>
	<div id="main">
    <table class="mytable" id="container">
    <%@ include file="../CommonTemplates/leftmenu.jsp"%>
      <thead>
        <tr>
          <th>姓名</th>
          <td>
          <input id="name" type="text">
          <button></button>
          </td>
          <th>電話</th>
          <td>
          <input id="phone" type="text">
          <button></button>
          </td>
          <td>
    		<input type="radio" name="r" id="status1" value="1" >
    			 <label for="status1"> 已成立 </label>
    		 <input type="radio" name="r" id="status2" value="2">
    			 <label for="status2"> 已結單 </label>
    		<input type="radio" name="r" id="status3" value="3">
    			 <label for="status3"> 全部 </label>
          </td>
        </tr>
        <tr>
        <td>
        <div id="mycenter">
        	<button id="peko" >查詢</button>
        </div>
        </td>
        </tr>
      </thead>
    </table>
    </div>
	    <%@ include file="../CommonTemplates/footer.jsp"%>
	    
	    
    <script>
    
    //已成立訂單的Ajax
      $(document).ready(function () {
        $('#peko').click(function () {
			if($("input[name='r']:checked").val()== 1){
          $.ajax({
            url: 'http://localhost:8080/YunHotel/customerToOrdered/orderedCreated',
            dataType: 'json',
            data:	{chinese_name : $("#name").val(), 
            		 mobile_phone : $("#phone").val(),
            		 ordered_status : "已成立",
            }
            type: 'Post',
            cache: false,
            success: function (data) {
              /*console.log(data);*/
              var event_data = '';
              $.each(data.results, function (index, ordered) {
                /*console.log(value);*/
                this_data += '<tr>';
                this_data += '<td>' + ordered.ordered_number + '</td>';//訂單編號
                this_data += '<td>' + ordered.customer.chinese_name + '</td>';//名字
                this_data += '<td>' + ordered.customer.mobile_phone + '</td>';//電話
                this_data += '<td>' + ordered.customer.idcard_number + '</td>';//身分證字號
                this_data += '<td>' + ordered.ordered_tomeals.table_number + '</td>';//桌號
                this_data += '<td>' + ordered.ordered_tomeals.meals_accounts + '</td>';//餐點總價
                this_data += '<td>' + ordered.ordered_toroom.room_number + '</td>';//房號
                this_data += '<td>' + ordered.ordered_toroom.room_accounts + '</td>';//房間總價
                this_data += '<td>' + ordered.ordered_status.ordered_status + '</td>';//訂單狀態
                this_data += '<td>' + ordered.ordered_accounts + '</td>';//訂單總價
                this_data += '<td>' + ordered.ordered_date + '</td>';//成立日期
                this_data += '<td>' + ordered.note + '</td>';//備註
                this_data += '</tr>';
              });
              $('#container').append(this_data);
            	}
            },
            error: function (d) {
              /*console.log("error");*/
              alert('錯誤');
            },
          });
        });
      });
    
    //已結單訂單的Ajax
      $(document).ready(function () {
        $('#status2').click(function () {
          var date = $(this).val();
          $.ajax({
            url: 'http://localhost:8080/YunHotel/customerToOrdered/orderedFinished',
            dataType: 'json',
            data:	{chinese_name : $("#name").val(), 
       		 mobile_phone : $("#phone").val(),
       		 ordered_status : "已結單",
       }
            type: 'Post',
            cache: false,
            success: function (data) {
              /*console.log(data);*/
              var event_data = '';
              $.each(data.results, function (index, ordered) {
                /*console.log(value);*/
                this_data += '<tr>';
                this_data += '<td>' + ordered.ordered_number + '</td>';//訂單編號
                this_data += '<td>' + ordered.customer.chinese_name + '</td>';//名字
                this_data += '<td>' + ordered.customer.mobile_phone + '</td>';//電話
                this_data += '<td>' + ordered.customer.idcard_number + '</td>';//身分證字號
                this_data += '<td>' + ordered.orderedToMeals.table_number + '</td>';//桌號
                this_data += '<td>' + ordered.orderedToMeals.meals_accounts + '</td>';//餐點總價
                this_data += '<td>' + ordered.orderedToRoom.room_number + '</td>';//房號
                this_data += '<td>' + ordered.orderedToRoom.room_accounts + '</td>';//房間總價
                this_data += '<td>' + ordered.orderedStatus.ordered_status + '</td>';//訂單狀態
                this_data += '<td>' + ordered.ordered_accounts + '</td>';//訂單總價
                this_data += '<td>' + ordered.ordered_date + '</td>';//訂單成立日期
                this_data += '<td>' + ordered.ordered_finish_date + '</td>';//訂單完成時間
                this_data += '<td>' + ordered.note + '</td>';//備註
                this_data += '</tr>';
              });
              $('#container').append(this_data);
            },
            error: function (d) {
              /*console.log("error");*/
              alert('錯誤');
            },
          });
        });
      });
    
      //全部訂單的Ajax
      $(document).ready(function () {
        $('#status3').click(function () {
          var date = $(this).val();
          $.ajax({
            url: 'http://localhost:8080/YunHotel/customerToOrdered/orderedAll',
            dataType: 'json',
            data:	{chinese_name : $("#name").val(), 
       				 mobile_phone : $("#phone").val(),
       				 ordered_status : "全部",
     			  }
            type: 'Post',
            cache: false,
            success: function (data) {
              /*console.log(data);*/
              var event_data = '';
              $.each(data.results, function (index, ordered) {
                /*console.log(value);*/
                this_data += '<tr>';
                this_data += '<td>' + ordered.ordered_number + '</td>';//訂單編號
                this_data += '<td>' + ordered.customer.chinese_name + '</td>';//名字
                this_data += '<td>' + ordered.customer.mobile_phone + '</td>';//電話
                this_data += '<td>' + ordered.customer.idcard_number + '</td>';//身分證字號
                this_data += '<td>' + ordered.ordered_tomeals.table_number + '</td>';//桌號
                this_data += '<td>' + ordered.ordered_tomeals.meals_accounts + '</td>';//餐點總價
                this_data += '<td>' + ordered.ordered_toroom.room_number + '</td>';//房號
                this_data += '<td>' + ordered.ordered_toroom.room_accounts + '</td>';//房間總價
                this_data += '<td>' + ordered.ordered_status.ordered_status + '</td>';//訂單狀態
                this_data += '<td>' + ordered.ordered_accounts + '</td>';//訂單總價
                this_data += '<td>' + ordered.ordered_date + '</td>';//訂單成立日期
                this_data += '<td>' + ordered.ordered_finish_date + '</td>';//訂單完成時間
                this_data += '<td>' + ordered.note + '</td>';//備註
                this_data += '</tr>';
              });
              $('#container').append(this_data);
            },
            error: function (d) {
              /*console.log("error");*/
              alert('錯誤');
            },
          });
        });
      });
    </script>
  </body>
</html>