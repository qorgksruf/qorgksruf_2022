<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%@include file="/header.jsp" %>	<!-- modal.css , modal.js 포함 -->

		<div class="container" >
			<div id="clickLatlng"></div> <!-- 클릭한 위치의 좌표 찾기 -->
			<div id="map" style="width:100%;height:700px;"></div>
		</div>



	<!--카카오지도에 필요한 클래스/메소드 가지고 있는 js라이브러리  -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9ff0d1e43453be5b8bc58c0d17d2db59&libraries=clusterer"></script>
	
	<script src="/jspweb/js/api/api3.js" type="text/javascript"></script>


</body>
</html>