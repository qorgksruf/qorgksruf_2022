<%@page import="model.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%"> <!--가로/세로 사이즈 생략시 auto(내용물크기만큼)  -->
	
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height: 100%;">
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class="searchbox">

	</div>
	
	
	<div class="contentbox">
		
		<div id="map" style="width:80%;height:80%;"></div>
	
		<!-- 사이드바 -->	
		<div class="productlistbox">

		</div>
	</div>	
	 
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=10ba1da6842b6225a9594bb0758c576f&libraries=services,clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>

</body>
</html>

<!-- 		<div class="pviewinfo">
				<div class="mimgbox">
					<img src="/jspweb/img/emo2.gif" class="hpimg">
					<span class="mid">gksruf1002</span>
				</div>
				<div>
					<button class="pbadge" type="button">목록보기</button>
				</div>
			</div>
				
				이미지 캐러셀: 이미지 슬라이드: 부트스트랩 
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/jspweb/product/pimg/car1.png" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jspweb/product/pimg/car2.png" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jspweb/product/pimg/car3.png" class="d-block w-100" alt="...">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
			
				제품상세 내용물
				<div class="pdate">2023-03-28</div>
				<div class="pname">자동차 팝니다</div>
				<div class="pcomment">내용물</div>
				<div class="pprice">3000000원</div>
				<div  class="pstate"><span class="pbadge">판매중</span></div>
				<div class="petc">
						<i class="fas fa-eye"></i>30
						<i class="fas fa-thumbs-up"></i>5
						<i class="fas fa-comment-dots"></i>2
				</div>		
				<div class="pviewbtnbox">
					<button type="button"><i class="far fa-heart"></i></button>
					<button type="button">채팅</button>
				</div> 
				
			
	
	</div> -->

	
	
	
	<!-- 			<div class="charbox">
			
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspweb/product/pimg/car1.png" class="hpimg">
						<span class="pname">자동차 팝니다 </span>
					</div>
					<div>
						<button onclick="produclistprint()" class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				
				<div class="chatcontent">
					<div class="sendbox">구매가능할까요?</div>
					<div class="receivebox">네 구매 가능합니다</div>
				</div>
				
				<div class="chatbtn">
					<textarea rows="" cols=""></textarea>
					<button type="button">전송</button>
				</div>
				
			</div>	 -->
	