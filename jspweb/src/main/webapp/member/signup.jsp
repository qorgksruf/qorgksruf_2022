<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- css경로 -->
	<link href="/jspweb/css/signup.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<%-- <%@ include file="/header.jsp"%> --%>	<!--윗거랑 둘 중 하나만 사용하삼  -->
		<div class="container"> <!-- bs 박스권 -->
				
				<form class="signupForm">	
				<h3> Ezen 커뮤니티</h3>
				<h3> 환영합니다 . 다양한 커뮤니티 제공합니다</h3>
				
				
					<div class="title">아이디</div>
						<input onkeyup="idcheck()" 			maxlength="30" 		type= "text"	 	 name="mid" 			class="mid">
						<div class= "idcheckconfirm"></div>
					
					<div class="title">비밀번호</div>
						<input onkeyup="pwdcheck()"		 	maxlength="20"  	type= "password"     name="mpwd" 			class="mpwd">	<br/>
					<div>비밀번호확인</div>
						<input onkeyup="pwdconformcheck()"  maxlength="20" 		type= "password"	 name="mpwdconfirmed"   class="mpwdconfirmed">	
						<div class= "idcheckconfirm"></div>
					
					<div  class="title">이메일</div>	
						<div class="emainbox">
							<input onkeyup="emailcheck()" type= "text" name="memail" 	class="memail">	
							<button class="emailboxbtn">인증</button>
						</div>
						<!--인증코드 입력 구역  -->
						<div class="authbox">
							<div class="timebox">03:00</div>
							<input type="text" class="authinput" placeholder="인증코드">
							<button type="button">확인</button>
						</div>
								
						<div class= "idcheckconfirm"></div>
					
					<div  class="title">프로필</div>
						<div class="pimgbox">
							<input onchange="premimg(this)" type= "file" name="mimg" 			class="mimg">
							<img class="premimg" alt="" src="/jspweb/member/pimg/default.webp">
						</div>
						
					<button onclick="signupbtn" type="button">가입 </button>
				</form>

	</div>
	
		
		
		<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>

		
	
</body>
</html>