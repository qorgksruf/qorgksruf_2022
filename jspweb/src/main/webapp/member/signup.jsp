<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<%-- <%@ include file="/header.jsp"%> --%>	<!--윗거랑 둘 중 하나만 사용하삼  -->
	<h3> 회원가입</h3>
	<form class="signupForm">	<!--폼 전송시 자식 input의 매개변수식별:name  -->
		아이디:		<input onkeyup="idcheck()" 			maxlength="30" 		type= "text"	 	 name="mid" 			class="mid">
					<span class= "idcheckconfirm">x</span> 
					<br/>
		비밀번호:		<input onkeyup="pwdcheck()"		 	maxlength="20"  	type= "password"     name="mpwd" 			class="mpwd">	<br/>
		비밀번호확인:	<input onkeyup="pwdconformcheck()"  maxlength="20" 		type= "password"	 name="mpwdconfirmed"   class="mpwdconfirmed">	
						<span class= "idcheckconfirm">x</span><br/>
		
		이메일:		<input onkeyup="emailcheck()" type= "text" name="memail" 	class="memail">			
						<span class= "idcheckconfirm">x</span><br/>
		
		프로필:		<input onchange="premimg(this)" type= "file" name="mimg" 			class="mimg">
			미리보기
			<img class="premimg" alt="" src="/jspweb/member/pimg/default.webp">
		<br/>	
		<button onclick="signup()" type="button">가입 </button>
	</form>
	
		
		
		<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>

		
	
</body>
</html>