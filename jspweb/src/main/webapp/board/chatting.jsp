<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
		<link href="/jspweb/css/chatting.css" rel="stylesheet">
	
<body>

	<%@include file="/header.jsp" %>
	
	<div class="container chattingwrap">
		<!--채팅 내용물이 표시되는 구역  -->
		
		<!-- 들어온 사람 명단 -->
			<div class="connectlistbox">	<!--접속명단 표시 구역  -->

			</div>
			
		
		<div class="chattingbox">
		
			<div class="contentbox">
			
			
<!-- 				보낼때[시간 내용]
				<div class="secontent">
					<div class="date">오전 10:07</div>
					<div class="content">안녕하세요</div>
				</div>
				알람 
				<div class="alerm">
					<span> 강호동님이 입장 하셨습니다. </span>
				</div>
				
				받을떄 [프로필, 시간, 내용]
				<div class="tocontent">
					<div><img src="/jspweb/member/pimg/default.webp" class="hpimg"></div>
					<div class="rcontent">
						<div class="name">강호동</div>
						<div class="contentdate">
							<div class="content">그래 안녕</div>
							<div class="date"> 오전10:10</div>
						</div>
					</div>
					
				</div> -->
				
			</div>
			

			
			
			<!-- form controller -->
				<!--채팅 입력창  -->
			<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
				<!--채팅 전송버튼 -->
			<div class="cattingbtnbox">
	
			
				<!-- 드롭다운 -->
			
	
				<!--드룹다운 버튼   -->			
				<button class="emobtn" type="button" data-bs-toggle="dropdown">
					<i class="far fa-smile"></i>
				</button>
				
				<!--드룹다운 버튼 클릭시 보이는 구역  -->
				<div class="dropdown-menu enolist">

				</div>
				
				<button onclick="보내기()" class="sendbtn" type="button">보내기</button>
			</div>	
		</div>	
				
	</div>


	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>

</body>
</html>