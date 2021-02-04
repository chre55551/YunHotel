<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/indexcss.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/aboutus.css'
	type="text/css" />
<title>關於我們</title>
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

	<div class="BG">
		<div class="main">
			<div class="aboutdiv">
			
			<div class="leftFdiv">
			<p class="titleus">關於我們</p>
			<div class="line"></div>
			<div class="aboutF">
			一個簡約又不失高雅的旅遊好去處，在繁忙的生活中，提供您閑靜愜意的環境，
			遠離都市的塵囂，讓身心靈好好地充個電，望向藍天大海，享受著大自然帶來的寧靜，
			讓來到這裡的每一個人有回到家的感覺，放鬆心情，享受旅遊，就在澐Hotel。
			</div>
			</div>
			
			<iframe class="map_pos" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d451.87688666435463!2d121.54337575419828!3d25.033561846969427!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442abd379a5ec97%3A0xedc006d25a9e35df!2z6LOH562W5pyDIOaVuOS9jeaVmeiCsueglOeptuaJgCDmlbjkvY3kurrmiY3ln7nogrLkuK3lv4M!5e0!3m2!1szh-TW!2stw!4v1612166831261!5m2!1szh-TW!2stw" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
			
			</div>
		</div>
		<%@ include file="../CommonTemplates/Indexfloat.jsp"%>
	</div>
	<%@ include file="../CommonTemplates/footer.jsp"%>


	<script
		src="${pageContext.request.contextPath}/js/Yun_js/SharedFunctions.js"></script>

</body>
</html>