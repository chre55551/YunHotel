<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/ordered.css'
	type="text/css" />
<title>訂單查詢</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themes/cupertino/jquery-ui.min.css">
<!-- Bootstrapt插件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="../CommonTemplates/Indexheader.jsp"%>

	<div class="queryODBG">
				<input type="hidden" id="${odl}" value="${odl}">
	<c:forEach var="od" items="${odl}">
				<input type="hidden" id="${od.ordered_number}" value="${od}">
	</c:forEach>
		<div class="main">
			<table class="orm2" id="container">
				<thead class="ormt2" >
				    <tr>
     					 <th>您的所有訂單</th>
    				</tr>
				</thead>
				<tbody>
					<c:forEach var="od" items="${odl}" varStatus="state">
						<tr>
							<td>${od.ordered_number}</td>
							<c:choose>
								<c:when test="${not empty otms[state-1]}">
									<td>餐廳訂單</td>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${not empty rdates[state-1]}">
									<td>房間訂單</td>
								</c:when>
							</c:choose>
							<td></td>
							<td></td>
							<td></td>
							<td>${od.orderedStatus.ordered_status}</td>
							<td>${od.ordered_date}</td>
						</tr>
					</c:forEach>
				</tbody>
<%-- 				<p>訂單編號: ${onum}</p> --%>
<%-- 				<p>姓名: ${name}</p> --%>
<%-- 				<p>手機: ${phone}</p> --%>
<%-- 				<p>訂單時間: ${odate}</p> --%>
<%-- 				<p>訂單狀態: ${ostatus}</p> --%>
<%-- 				<p>付款方式: ${oBill}</p> --%>
<!-- 				<br> <input class="ormBtn" type="button" value="回官網" -->
<!-- 					onclick="location.href='http://localhost:8080/YunHotel/YunPage'"> -->
			</table>
		</div>
	</div>

	<div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>

	<script type="text/javascript"> 
	let jsonS = ${jsonString};
	
	
// 	$(document).ready(function(){ 
// 		var odl = $('#odl').val();
//    		var this_data = '';
	
//    		for(let od of odl){
// 	    	this_data += '<tr>';
//  			this_data += '<td>' + od.ordered_number + '</td>';//訂單編號
// 	  		this_data += "<td><button onclick="+'"'+"window.location.href='/YunHotel/ordered/outsidethisOrdered/"+ od.ordered_number + "'"+'">詳細資料</button>'
//   			this_data += '</tr>';
// 		}
// 		this_data +=  '<br> <input class="ormBtn'+'" type='+'"button'+'" value='+'"'+'回官網"'+'onclick="location.href='+"'http://localhost:8080/YunHotel/YunPage"+"'"+'">';
// 		$('#container').append(this_data);

// 	});
//  function () {
//     var this_data = '';
// 		if(fk != null){
// 			for(let ordered of fk){
//    		    	this_data += '<tr>';
//      			this_data += '<td>' + qq.ordered_number + '</td>';//訂單編號
// 		  		this_data += "<td><button onclick="+'"'+"window.location.href='/YunHotel/ordered/outsidethisOrdered/"+ ordered.ordered_number + "'"+'">詳細資料</button>'
//       			this_data += '</tr>';
//     		  };
// 				 $('#container').append(this_data);
// 		}else{
// 			 alert('查無資料');
//  		}
//  }
 	</script> 
</body>
</html>