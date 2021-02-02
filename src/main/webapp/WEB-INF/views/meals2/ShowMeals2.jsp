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
<title>Show Meals2</title>
</head>
<body><%@ include file="../CommonTemplates/header.jsp"%>

<div class="main">
	<%@ include file="../CommonTemplates/leftmenu.jsp"%>
	
    <div class="right">
        <p class="title">餐點</p>
        <p class="hr"></p>
        		
        <div class="allcontent"> <!-- 整個放內容白色區塊 -->	
        	<div class="litletitle"> <!-- 灰色title -->	
<!--         		<div class="ltF_div"> 按鈕	 -->
<!--         			<a class="ltF" href='showinsertNews'>新增消息</a> -->
<!--         		</div> -->
        	</div>
        		<div class="listtitle">
        		
        		
		<table border='1'  >
			<tr>
			   <th width='56' height='20'>餐點編號</th>
			   <th width='130' height='20'>餐點類型</th>
			   <th width='130' height='20'>餐點名稱</th>
			   <th width='130' height='20'>餐點價格</th>
			   <th width='180' height='20'>餐點庫存</th>
			   <th colspan='2' height='20'>維護</th>
			</tr>
			<c:forEach var='MES' items='${meals2List}'>
				<tr>
					<td style="text-align:center">${MES.meals2_id}</td>
					<td style="text-align:center">${MES.meals2_type}</td>
					<td style="text-align:center">${MES.meals2_name}</td>
					<td style="text-align:center">${MES.meals2_price}</td>
					<td style="text-align:center">${MES.meals2_stock}</td>
					
					 <td><a
                        href="${pageContext.request.contextPath}/meals2/update/${MES.meals2_id}">編輯</a></td>
                    <td><a
                        href="${pageContext.request.contextPath}/meals2/DeleteMeals2/${MES.meals2_id}">刪除</a></td>
				</tr>
			</c:forEach>
		
		</table>
				</div>
        </div>
        	
     </div>

</div>



<script type='text/javascript'>
    $(document).ready(function() {
        $('.deletelink').click(function() {
        	if (confirm('確定刪除? ')) {
        		var href = $(this).attr('href');
                $('form').attr('action', href).submit();
        	} 
        	return false;
            
        });
    })
</script>

	<%@ include file="../CommonTemplates/footer.jsp"%>
</body>
</html>