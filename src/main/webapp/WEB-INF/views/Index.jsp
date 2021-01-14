<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='${pageContext.request.contextPath}/WEB-INF/css/indexcss.css'  type="text/css" charset=UTF-8 />
<title>澐YunHotel酒店.首頁</title>
    <link rel="stylesheet" href="../css/themes/cupertino/jquery-ui.min.css">
    <!-- Bootstrapt插件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<header> 
    <ul>
        <li><img id="logo" src="../imgs/logo.png"></li>
        <li>&emsp;&emsp;&emsp;&emsp;</li>
        <li><a href="#">關於我們</a></li>
        <li><a href="#">最新消息</a></li>
        <li><a href="#">房型介紹</a></li>
        <li><a href="#">美食佳餚</a></li>
        <li><a href="#">其他設施</a></li>
    </ul>
</header>

<div id="main">
    <div id="container">
        <div class="dateline">
            <div class="D1">
                <p id="dateF">入住:</p><br>
                <!-- readonly:不讓使用者自行輸入日期 -->
                <input type="text" id="from" class="datepicker" readonly> 
                <img id="datepic" src="../imgs/date1.png">
                <button></button>
            </div>

            <div class="D1">
                <p id="dateF">退房:</p><br>
                <input type="text" id="to" class="datepicker" readonly>
                <img id="datepic" src="../imgs/date1.png">
                <button></button>
            </div>
        </div>

    

        
    </div>
</div>

<div id="footer"> 
    <p>© The Hotel. All Rights Reserved.</p>
</div>


<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../js/plugin/jquery-ui.js"></script>
<script>

$(function() {
    $( "#from" ).datepicker({

      changeMonth: true, //顯示月份列表供選擇
      firstDay: 1,  //星期一開始
      minDate:0, //最小日期只能選今天
      dateFormat: "yy-mm-dd",
      onClose: function(selectedDate) { 
      $('#to').datepicker('option', 'minDate', new Date(selectedDate).addDays(1)); 
     } 
    });

    function addDays(date, days) { 
    var dat = date; 
    dat.setDate(dat.getDate() + days); 
    return dat; 
    } 

    $( "#to" ).datepicker({

      changeMonth: true,
      firstDay: 1,
      minDate:"+1", //最小日期只能選隔天(退房)
      dateFormat: "yy-mm-dd",
      onClose: function( selectedDate ) {
        $( "#from" ).datepicker( "option", "maxDate", selectedDate );
      }
    });
  });
</script>
	
</body>
</html>