<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/practice/과제1/Company.css" rel="stylesheet">
	
	<!-- 모달 css -->
	<link href="/jspweb/css/modal.css" rel="stylesheet">
</head>
<body>	
	
	<div class="company">
		<!--인사등록  -->
<!-- 인사등록 -->
      <form class="regi">
         <div >   
         	<div class="pimgbox">
				<input onchange="premimg(this)" type="file" name="mimg"	 		class="mimg">		
				<img class="premimg" alt="" src="/jspweb/practice/과제1/img/기본이미지.webp">
			</div>	
            <div> 사원명 </div>
            <input type="text" name="cname" class="cname">
            <div> 직급 </div>
            <select name="clevel" class="clevel">
               <option> 사원 </option>
               <option> 대리 </option>
               <option> 부장 </option>
               <option> 과장 </option>
               <option> 대표 </option>      
            </select>
            <div> 고용형태 </div>
            <select name="cform" class="cform">
               <option> 일용직 </option>
               <option> 계약직 </option>
               <option> 정규직 </option>      
               <option> 임원 </option>   
            </select>
            <div> 부서 </div>
            <select name="cclassfy" class="cclassfy">
               <option> 인사팀 </option>
               <option> 개발팀 </option>
               <option> 영업팀 </option>      
            </select>
            <div> 입사일 </div>
            <input  type="date" name="csdate" class="csdate"> <br/>
            <button class="getbtn" onclick="getbtn()" type="button">등록 </button> 
         </div>
      </form>
      
      
    

            <button onclick="onpenModal()" type="button">퇴사하기 </button> 
 				
 				
 				
		
	<!-- 삭제하기 modal -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				사직서
			</h3>
			<div class="modal_content">
				퇴사하시겠습니까? 아래 작성해주세요
				<br>
				사원이름: <input type="text" class="cname">
	            <div> 퇴사일 </div>
           		 <input  type="date" name="cedate" class="cedate"> <br/>
            	<div> 퇴사사유 </div>
           		 <textarea rows="" cols="" name="cecontent" class="cecontent"> </textarea> <br/>			
				
			</div>
			<div class="modal_btns">
				<button onclick="setbye()" class="modal_check" type="button">삭제하기</button>
				<button onclick="closeModal()" class="modal_cancel" type="button">취소</button>
			</div>
		</div>
	</div>		
		
		
		
		
		
		<!--인사출력  -->
		<div class="print">
		</div>
	
	</div>
	





	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!--js연결  -->
	<script src="/jspweb/practice/과제1/Company.js" type="text/javascript"></script>
	
	<!--회원삭제하기  -->
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>
	
</body>
</html>