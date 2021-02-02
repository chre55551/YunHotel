<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>澐Hotel-房型介紹 </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700&display=swap" rel="stylesheet">
    
    
    
    
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/aos.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/jquery.timepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/fancybox.min.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts2/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts2/fontawesome/css/font-awesome.min.css">
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test/style.css">
    
    
    
    
    
    
    
    
    
    
     <link href="${pageContext.request.contextPath}/fonts/icomoon/icomoon.eot" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/fonts/icomoon/icomoon.svg" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/fonts/icomoon/icomoon.ttf" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/fonts/icomoon/icomoon.woff" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/fonts/ionicons/css/ionicons.min.css" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/fonts/ionicons/css/_ionicons.scss" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/fonts/open-iconic/open-iconic.eot" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/open-iconic/open-iconic.otf" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/open-iconic/open-iconic.svg" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/open-iconic/open-iconic.ttf" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/open-iconic/open-iconic.woff" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon/font/_flaticon.scss" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon/font/flaticon.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon/font/Flaticon.eot" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon/font/flaticon.html" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon/font/Flaticon.svg" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon/font/Flaticon.ttf" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/flaticon/font/Flaticon.woff" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/test2/bootstrap/bootstrap-gird.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/test2/bootstrap/bootstrap-reboot.css" rel="stylesheet">
    
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/animate.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/owl.theme.default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/magnific-popup.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/aos.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/ionicons.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/jquery.timepicker.css">

    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/icomoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/test2/style.css">
  </head>
  <body>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="../YunPage">Yun<span>Hotel</span></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

<%-- 		<%@ include file="CommonTemplates/Indexheader.jsp"%> --%>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="../YunPage" class="nav-link">首頁</a></li>
	          <li class="nav-item"><a href="about.html" class="nav-link">關於我們</a></li>
	          <li class="nav-item"><a href="blog.html" class="nav-link">最新消息</a></li>
	          <li class="nav-item"><a href="RoomIntroduction" class="nav-link">房型介紹</a></li>
	          <li class="nav-item"><a href="../meals/Delicious" class="nav-link">美食佳餚</a></li>
	          <li class="nav-item"><a href="contact.html" class="nav-link">其他設施</a></li>
	          <li class="nav-item"><a href="../customer/Login" class="nav-link">會員登入</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
		<div class="hero-wrap" style="background-image: url('../image/test2/bg_3.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="../YunPage">Home</a></span> <span>歡迎蒞臨 澐Hotel</span></p>
	            <h1 class="mb-4 bread">Rooms</h1>
            </div>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section ftco-no-pb ftco-room">
    	<div class="container-fluid px-0">
    		<div class="row no-gutters justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
          	<span class="subheading">2021全新房型</span>
            <h2 class="mb-4">澐Hotel 房型介紹</h2>
          </div>
        </div>
        
        

         <section class="section bg-light pb-0"  >
      <div class="container">
       
        <div class="row check-availabilty" id="next">
          <div class="block-32" data-aos="fade-up" data-aos-offset="-200">

            <form action="http://localhost:8080/YunHotel/ordered/outsideInsertRoomOd">
              <div class="row">
                <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                  <label for="checkin_date" class="font-weight-bold text-black">入住</label>
                  <div class="field-icon-wrap">
<!--                     <div class="icon"><span class="icon-calendar"></span></div> -->
                    <input type="text" id="checkin_date" class="form-control">
                  </div>
                </div>
                <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                  <label for="checkout_date" class="font-weight-bold text-black">退房</label>
                  <div class="field-icon-wrap">
<!--                     <div class="icon"><span class="icon-calendar"></span></div> -->
                    <input type="text" id="checkout_date" class="form-control">
                  </div>
                </div>
                <div class="col-md-6 mb-3 mb-md-0 col-lg-3">
                  <div class="row">
                    <div class="col-md-6 mb-3 mb-md-0">
                      <label for="adults" class="font-weight-bold text-black">成人</label>
                      <div class="field-icon-wrap">
<!--                         <div class="icon"><span class="ion-ios-arrow-down"></span></div> -->
                        <select name="" id="adults" class="form-control">
                          <option value="">1</option>
                          <option value="">2</option>
                          <option value="">3</option>
                          <option value="">4+</option>
                        </select>
                      </div>
                    </div>
                    <div class="col-md-6 mb-3 mb-md-0">
                      <label for="children" class="font-weight-bold text-black">孩童</label>
                      <div class="field-icon-wrap">
<!--                         <div class="icon"><span class="ion-ios-arrow-down"></span></div> -->
                        <select name="" id="children" class="form-control">
                          <option value="">1</option>
                          <option value="">2</option>
                          <option value="">3</option>
                          <option value="">4+</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-6 col-lg-3 align-self-end">
                  <button class="btn btn-primary btn-block text-white" type="submit">馬上訂房</button>
                </div>
              </div>
            </form>
          </div>


        </div>
      </div>
    </section>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    		<div class="row no-gutters">
    			<div class="col-lg-6">
    				<div class="room-wrap d-md-flex ftco-animate">
    					<a href="#" class="img" style="background-image: url(../image/test2/room-6.jpg);"></a>
    					<div class="half left-arrow d-flex align-items-center">
    						<div class="text p-4 text-center">
<!--     							<p class="star mb-0"><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span></p> -->
    							<p class="mb-0"><span class="price mr-1">$NT7,600</span> <span class="per">每晚</span></p>
	    						<h3 class="mb-3"><a href="RoomIntroduction">豪華三人房</a></h3>
	    						<p class="pt-1"><a href="DeluxeTripleRoom" class="btn-custom px-3 py-2 rounded">詳細資料</a></p>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-lg-6">
    				<div class="room-wrap d-md-flex ftco-animate">
    					<a href="#" class="img" style="background-image: url(../image/test2/room-1.jpg);"></a>
    					<div class="half left-arrow d-flex align-items-center">
    						<div class="text p-4 text-center">
<!--     							<p class="star mb-0"><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span></p> -->
    							<p class="mb-0"><span class="price mr-1">$NT6,600</span> <span class="per">每晚</span></p>
	    						<h3 class="mb-3"><a href="RoomIntroduction">都會套房</a></h3>
	    						<p class="pt-1"><a href="MetropolisSuite" class="btn-custom px-3 py-2 rounded">詳細資料</a></p>
    						</div>
    					</div>
    				</div>
    			</div>

    			<div class="col-lg-6">
    				<div class="room-wrap d-md-flex ftco-animate">
    					<a href="#" class="img order-md-last" style="background-image: url(../image//test2/room-2.jpg);"></a>
    					<div class="half right-arrow d-flex align-items-center">
    						<div class="text p-4 text-center">
<!--     							<p class="star mb-0"><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span></p> -->
    							<p class="mb-0"><span class="price mr-1">$NT8,800</span> <span class="per">每晚</span></p>
	    						<h3 class="mb-3"><a href="RoomIntroduction">豪華家庭房</a></h3>
	    						<p class="pt-1"><a href="DeluxeFamilyRoom" class="btn-custom px-3 py-2 rounded">詳細資料</a></p>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-lg-6">
    				<div class="room-wrap d-md-flex ftco-animate">
    					<a href="#" class="img order-md-last" style="background-image: url(../image/test2/room-3.jpg);"></a>
    					<div class="half right-arrow d-flex align-items-center">
    						<div class="text p-4 text-center">
<!--     							<p class="star mb-0"><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span></p> -->
    							<p class="mb-0"><span class="price mr-1">$NT4,600</span> <span class="per">每晚</span></p>
	    						<h3 class="mb-3"><a href="RoomIntroduction">豪華單人房</a></h3>
	    						<p class="pt-1"><a href="DeluxeSingleRoom" class="btn-custom px-3 py-2 rounded">詳細資料</a></p>
    						</div>
    					</div>
    				</div>
    			</div>

    			<div class="col-lg-6">
    				<div class="room-wrap d-md-flex ftco-animate">
    					<a href="#" class="img" style="background-image: url(../image/test2/room-4.jpg);"></a>
    					<div class="half left-arrow d-flex align-items-center">
    						<div class="text p-4 text-center">
<!--     							<p class="star mb-0"><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span></p> -->
    							<p class="mb-0"><span class="price mr-1">$NT5,200</span> <span class="per">每晚</span></p>
	    						<h3 class="mb-3"><a href="RoomIntroduction">豪華雙人房</a></h3>
	    						<p class="pt-1"><a href="DeluxeDoubleRoom" class="btn-custom px-3 py-2 rounded">詳細資料</a></p>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-lg-6">
    				<div class="room-wrap d-md-flex ftco-animate">
    					<a href="#" class="img" style="background-image: url(../image/test2/room-5.jpg);"></a>
    					<div class="half left-arrow d-flex align-items-center">
    						<div class="text p-4 text-center">
<!--     							<p class="star mb-0"><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span><span class="ion-ios-star"></span></p> -->
    							<p class="mb-0"><span class="price mr-1">$NT5,800</span> <span class="per">每晚</span></p>
	    						<h3 class="mb-3"><a href="RoomIntroduction">高級套房</a></h3>
	    						<p class="pt-1"><a href="AdvancedRoom" class="btn-custom px-3 py-2 rounded">詳細資料 </a></p>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </section>


    <footer class="ftco-footer ftco-section img" style="background-image: url(../image/test2/bg_4.jpg);">
    	<div class="overlay"></div>
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2"></h2>
              <p></p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
<!--                 <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li> -->
<!--                 <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li> -->
<!--                 <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li> -->
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2"></h2>
              <ul class="list-unstyled">
<!--                 <li><a href="#" class="py-2 d-block">Blog</a></li> -->
<!--                 <li><a href="#" class="py-2 d-block">Rooms</a></li> -->
<!--                 <li><a href="#" class="py-2 d-block">Amenities</a></li> -->
<!--                 <li><a href="#" class="py-2 d-block">Gift Card</a></li> -->
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2"></h2>
              <ul class="list-unstyled">
<!--                 <li><a href="#" class="py-2 d-block">Career</a></li> -->
<!--                 <li><a href="#" class="py-2 d-block">About Us</a></li> -->
<!--                 <li><a href="#" class="py-2 d-block">Contact Us</a></li> -->
<!--                 <li><a href="#" class="py-2 d-block">Services</a></li> -->
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2"></h2>
            	<div class="block-23 mb-3">
	              <ul>
<!-- 	                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li> -->
<!-- 	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li> -->
<!-- 	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li> -->
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> © Copyright 澐酒店 Yun Hotel. All rights reserved. 2021 <i aria-hidden="true"></i> 
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="${pageContext.request.contextPath}/js/test2/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/jquery-migrate-3.0.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/jquery.easing.1.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/jquery.waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/jquery.stellar.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/aos.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/jquery.animateNumber.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/bootstrap-datepicker.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="${pageContext.request.contextPath}/js/test2/google-map.js"></script>
  <script src="${pageContext.request.contextPath}/js/test2/main.js"></script>
  
  
 
  
    <script src="${pageContext.request.contextPath}/js/test/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/test/jquery-migrate-3.0.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/test/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/test/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/test/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/test/jquery.stellar.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/test/jquery.fancybox.min.js"></script>
    
    
    <script src="${pageContext.request.contextPath}/js/test/aos.js"></script>
    
    <script src="${pageContext.request.contextPath}/js/test/bootstrap-datepicker.js"></script> 
    <script src="${pageContext.request.contextPath}/js/test/jquery.timepicker.min.js"></script> 

    

    <script src="${pageContext.request.contextPath}/js/test/main.js"></script>
  
   
  </body>
</html>