<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 예제 1: HTTP 메소드</h3>
	<button onclick="doPOST()" type="button">POST메소드 </button>
	<button onclick="doGET()" type="button">GET메소드 </button>
	<button onclick="doPUT()" type="button">PUT메소드 </button>
	<button onclick="doDELETE()" type="button">DELETE메소드 </button>

	<h3> 예제2: 비회원 방문록</h3>
	내용: <input type="text" class="content">	<br>
	작성자: <input type="text" class="writer"><br>
	<button  onclick="onwrite()" type="button"> 방문록 등록</button>
	
	<h3> 테이블 </h3>
	<table class = "boardtable" border="1">
	</table>


	<!-- 
		jsp,js 기준 파일 사용
		dao, dto,serVlet 새로 파일 만들기
		과제3
			1.제품등록	[제품명,가격]
			2.제품출력	[테이블에 모두 [제품번호,제품명,가격] 출력]
			3.제품삭제 [제품번호 이용한 삭제]
			4.제품수정	[제품번호 이용한 제폼명, 가격 수정 =prompt 수정할 데이터 입력받기]
		
		
	 -->
	<h3> 과제 제품테이블</h3>
	제품명: <input type="text" class="pname">	<br>
	가격: <input type="text" class="pprice"><br>
	<button  onclick="onregi()" type="button">등록하기</button>
		
	<h3>과제테이블</h3>
	<table class="pboardtable"></table>
	
	
	
	
	
	<!--경로  -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="index.js" type="text/javascript"> </script>
	
	
	
</body>
</html>