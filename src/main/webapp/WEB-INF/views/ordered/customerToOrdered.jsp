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
	<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>依顧客查詢</title>
</head>
<body>
	<%@ include file="../CommonTemplates/header.jsp"%>
<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">查詢訂單</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
        	</div>
        		<div class="listtitle">
        		
		<table id="container" style="width: 800px;height: 500px;">
			<thead  style="width: 800px;height: 300px;">
				<tr>
					<th style="width: 50px;">姓名</th>
					<td>
						<input id="name" type="text">
					</td>
					<th style="width: 50px;">電話</th>
					<td>
						<input id="phone" type="text">
					</td>
					<td style="width: 250px;">
					<input type="radio" name="r" id="status1" value="1">
						<label for="status1"> 已成立 </label> <input type="radio" name="r"
						id="status2" value="2"> <label for="status2"> 已結單</label>
						<input type="radio" name="r" id="status3" value="3"> <label
						for="status3"> 全部 </label>
					</td>
					<td>
						<div class="mycenter">
							<button id="peko">查詢</button>
						</div>
					</td>
				</tr>
			</thead>
			<tbody id="clean">
			</tbody>
		</table>
				</div>
        </div>
        	
     </div>

</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>


	<script>
    
    //已成立訂單的Ajax

        $('#peko').click(function () {
          if($("input[name='r']:checked").val()== 1){
          $.ajax({
            url: 'http://localhost:8080/YunHotel/ordered/customerToOrdered/orderedCreated',
            dataType: 'json',
            data: {chinese_name : $("#name").val(), 
               mobile_phone : $("#phone").val(),
               ordered_status : "已成立",
            },
            type: 'Post',
            cache: false,
            success: function (data) {
            	$('#clean').empty();
            	let fk = data
                var this_data = '';
            			this_data += '<tr style="width: 800px;height: 100px;'+'">';
            			this_data += '<th>' + '訂單編號' + '</th>';
            			this_data += '<th>' + '姓名' + '</th>';
            			this_data += '<th>' + '電話' + '</th>';
            			this_data += '<th>' + '訂單狀態' + '</th>';
            			this_data += '<th>' + '訂單成立日期' + '</th>';
            			this_data += '</tr>';
            				if(fk != null){
            					for(let ordered of fk){
                       	 			this_data += '<tr>';
                     	    		this_data += '<td style="padding-left: 18px;">' + ordered.ordered_number + '</td>';//訂單編號
                     	    		this_data += '<td style="padding-left: 80px;">' + ordered.customer.chinese_name + '</td>';//名字
                       	   		    this_data += '<td style="padding-left: 10px;">' + ordered.customer.mobile_phone + '</td>';//電話
                       			 	this_data += '<td style="padding-left: 80px;">' + ordered.orderedStatus.ordered_status + '</td>';//訂單狀態
                       			    this_data += '<td style="padding-left: 60px;">' + ordered.ordered_date + '</td>';//訂單成立日期
    					 		    this_data += "<td><button onclick="+'"'+"window.location.href='/YunHotel/ordered/thisOrdered/"+ ordered.ordered_number + "'"+'">詳細資料</button>'
                           			this_data += '</tr>';
                     				 };
                 						$('#clean').append(this_data);
               					  }else{
                							 alert('查無資料');
                							}
     				       },
            
           						 error: function (d) {
          								    alert('查無資料');
          										  },
        								   })
       								  }
	

         if($("input[name='r']:checked").val()== 2){
          $.ajax({
            url: 'http://localhost:8080/YunHotel/ordered/customerToOrdered/orderedFinished',
            dataType: 'json',
            data: {chinese_name : $("#name").val(), 
          mobile_phone : $("#phone").val(),
          ordered_status : "已結單",
       },
            type: 'Post',
            cache: false,
            success: function (data) {
            	$('#clean').empty();
            	let fk = data
                var this_data = '';
            	this_data += '<tr style="width: 800px;height: 100px;'+'">';
    			this_data += '<th>' + '訂單編號' + '</th>';
    			this_data += '<th>' + '姓名' + '</th>';
    			this_data += '<th>' + '電話' + '</th>';
    			this_data += '<th>' + '訂單狀態' + '</th>';
    			this_data += '<th>' + '訂單成立日期' + '</th>';
    			this_data += '</tr>';
            		if(fk != null){
            			for(let ordered of fk){
               		    	this_data += '<tr>';
                 			this_data += '<td>' + ordered.ordered_number + '</td>';//訂單編號
               		   	    this_data += '<td>' + ordered.customer.chinese_name + '</td>';//名字
                 		   	this_data += '<td>' + ordered.customer.mobile_phone + '</td>';//電話
               		   		this_data += '<td>' + ordered.orderedStatus.ordered_status + '</td>';//訂單狀態
					  		this_data += "<td><button onclick="+'"'+"window.location.href='/YunHotel/ordered/thisOrdered/"+ ordered.ordered_number + "'"+'">詳細資料</button>'
                  			this_data += '</tr>';
                		  };
           				$('#clean').append(this_data);
            		}else{
            			 alert('查無資料');
            		}
            },
            error: function (d) {
              /*console.log("error");*/
              alert('查無資料');
            },
           },
          );
          };

          if($("input[name='r']:checked").val()== 3){
          $.ajax({
            url: 'http://localhost:8080/YunHotel/ordered/customerToOrdered/orderedAll',
            dataType: 'json',
            data: {chinese_name : $("#name").val(), 
            mobile_phone : $("#phone").val(),
            ordered_status : "全部",
          },
            type: 'Post',
            cache: false,
            success: function (data) {
            	$('#clean').empty();
            	let fk = data
                var this_data = '';
            	this_data += '<tr style="width: 800px;height: 100px;'+'">';
    			this_data += '<th>' + '訂單編號' + '</th>';
    			this_data += '<th>' + '姓名' + '</th>';
    			this_data += '<th>' + '電話' + '</th>';
    			this_data += '<th>' + '訂單狀態' + '</th>';
    			this_data += '<th>' + '訂單成立日期' + '</th>';
    			this_data += '</tr>';
				if(fk != null){
	             	for(let ordered of fk){
	                 	this_data += '<tr>';
	                 	this_data += '<td>' + ordered.ordered_number + '</td>';//訂單編號
	                 	this_data += '<td>' + ordered.customer.chinese_name + '</td>';//名字
	                 	this_data += '<td>' + ordered.customer.mobile_phone + '</td>';//電話
	               		  this_data += '<td>' + ordered.orderedStatus.ordered_status + '</td>';//訂單狀態
	               		  this_data += '<td>' + ordered.ordered_date + '</td>';//訂單成立日期
	 						this_data += "<td><button onclick="+'"'+"window.location.href='/YunHotel/ordered/thisOrdered/"+ ordered.ordered_number + "'"+'">詳細資料</button>'
	              		   this_data += '</tr>';
	              		  };
	              			 $('#clean').append(this_data);	
				      }else{
	            		 	 alert('查無資料');
							}
           		},
            error: function (d) {
              /*console.log("error");*/
              alert('查無資料');
            },
          });
     	 }
    });
    
    
    </script>
</body>
</html>