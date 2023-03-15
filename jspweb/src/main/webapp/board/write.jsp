<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	


	<%@include file="/header.jsp" %>
	
	<script type="text/javascript">
	// 1.jsp로 로그인 여부 제어
/* 		if(memberinfo.mid==null){
			alert('회원제 기능입니다 로그인후 작성해주세요');
			location.href="/jspweb/member/login.jsp"
		} */
	</script>
	<%
		// 2.jsp로 로그인 여부 제어
		Object o=request.getSession().getAttribute("login");
		if( o == null ){
			response.sendRedirect("/jspweb/member/login.jsp");
		} 
	%>
	
	<div class="container">
		<h3> 글쓰기</h3>
			<form class="writeForm">
			카테고리: <select name="cno">
						<option value="1">공지사항 </option>
						<option value="2">커뮤니티 </option>
						<option value="3">QnA </option>
						<option value="4">노하우 </option>
					</select>
			제목	:<input name="btitle" type="text">
			내용	:<textarea name="bcontent" rows="3" cols="3"></textarea>
			첨부파일: <input name="bfile" type="file">
			<button onclick="bwrite()" type="button">쓰기</button>
		</form>
	</div>
	
	<!--
		HTML --- > form [동기식: 페이지전환이 있음]
	1. enctype="application/x-www-form-urlencoded": 기본 폼 전송타입
	2. enctype= multipart/form-data  
	주의 form 테그 안에있는 <button> type 생략시 type="submit"(폼보내기)
		<!-- 	<form method="post" action="서블릿URL"  enctype="multipart/form-data"> -->

	<script src="/jspweb/js/board/write.js"  type="text/javascript"></script>
	
</body>
</html>