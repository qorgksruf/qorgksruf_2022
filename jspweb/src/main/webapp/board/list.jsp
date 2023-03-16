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
	<%
	//HTTP GET <a> 전달된 매개변수 가져오기
	String cno=	request.getParameter("cno");
	//표현식을 이용한 input,div등등 대입
	%>
	<!--cno숨겨서 js에게 전달  -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<div class="container">	
		<h3 class="cname"></h3>
		
		<a href="write.jsp">글쓰기</a>
		
		<button onclick="setsearch()" type="button">전체보기[검색제거]</button>
		<div class="seachcount"></div>
		<select onchange="setlistsize()" class="listsize">
			<option>3</option>
			<option>5</option>
			<option>10</option>
		</select>
		
		<table class="boardtable table table-hover">
			
		</table>
		
		<!-- 페이징처리 버튼들  -->
		<div class="pagebox">

		</div>
		
		<!--검색창  -->
					<!-- 
						select * from board where 필드명=데이터;
						
					 -->
		<div>		<!--select*from board where 필드명=데이터  -->
			<select class="key"> <!--select 시 사용되는 조건의 필드명  -->
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input  class="keyword" type="text">	<!-- select시 사용되는 조건의 데이터 -->	
			<button onclick="getsearch()" type="button">검색</button>
		</div>
		
	</div>


	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>

</body>
</html>