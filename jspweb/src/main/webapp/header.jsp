<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<!--반응형  -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--부트스트램CSS  -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 모든페이지 공통 넣어주기  -->
	<link href="/jspweb/css/index.css" rel="stylesheet">

	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

	<link href="/jspweb/css/modal.css" rel="stylesheet">
</head>
<body>
	<!--모든 페이지 공통메뉴  -->

	

		<div class="container">
			<div class="header">
				<!-- 로고 -->
				<div class="mainlogo">
					<a href="/jspweb/index.jsp"> 
						<img src="/jspweb/img/logo.jpg">
					</a>
				</div>
				
				<!-- 본메뉴 -->
				<ul class="mainmenu">
					<li> <a href="/jspweb/board/list.jsp?cno=1"> 공지사항 </a> </li>
					<li> <a href="/jspweb/board/list.jsp?cno=2"> 커뮤니티 </a> </li>
					<li> <a href="/jspweb/board/list.jsp?cno=3"> QNA </a> </li>
					<li> <a href="/jspweb/board/list.jsp?cno=4"> 노하우 </a> </li>
					<li> <a href="#"> 기능메뉴5 </a> </li>
					<li> <a href="#"> 기능메뉴6 </a> </li>
					<li> <a href="#"> 기능메뉴7 </a> </li>
					
				</ul>
				
				<!-- 서브메뉴 -->
				<div class="submemu">

				</div>	
			</div>
			
		</div>

	<!--jquery signup -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>	

	<!--부트스트랩JS  -->
	<script src="https://cdn.jsdelivr.net
	/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
 	
 	<!-- js개인페이지 -->
	<script src="/jspweb/js/header.js" type="text/javascript"></script> 
	
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>
	
  </body>
</body>
</html>