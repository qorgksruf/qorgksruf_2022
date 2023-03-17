<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<!--과제
		 글쓰기[첨부파일]
		 모든 글 출력[list]
		-페이징처리,검색처리
		 글 개별조회[view]
		 -조회수증가, 좋아요/싫어요증가
		  글삭제 
		  글수정
		 
		  + 과제/관리자명단에
		  
		   검색처리랑(번호,아이디,이메일) 
		   
		   페이징처리  
		 
		  
		  
		     -->
		
	
	<%@ include file="/header.jsp" %>
	<%String mno=	request.getParameter("mno");%>
	<input type="hidden" class="mno" value="<%=mno%>">
	
	<h3> 모든 회원 명단 </h3>
	
	<table class="mListTable" border="1">

	</table>

	
	<!-- 여기부터과제시작 -->
	
	<button onclick="setsearch()" type="button">전체보기[검색제거]</button>	
		<div class="seachcount"></div>
		<select onchange="setlistsize()" class="listsize">
			<option>3</option>
			<option>5</option>
			<option>10</option>
		</select>
	
	<!-- 페이징처리 버튼 -->	
	<div class="pagebox"> 
	
	
	</div>

	<!-- 검색창 -->
	<div>
		<select class="key">
			<option value="mno">번호</option>
			<option value="mid">아이디</option>
			<option value="memail">이메일</option>
		</select>
		<input class="keyword" type="text">
		<button onclick="getsearch()" type="button">검색</button>
	</div>


	<script src="/jspweb/js/admin/info.js " type="text/javascript"></script>

	

		
		
</body>
</html>