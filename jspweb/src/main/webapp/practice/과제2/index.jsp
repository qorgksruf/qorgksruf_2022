<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<h3> 과제 [C] </h3>
			 
			data1[이름문자열]	:<input type="text" class="data1"> <br/>
			data2[전화번호]	:<input type="text" class="data2"><br/>
			data3[키]		:<input type="text" class="data3"><br/>
			data4[나이]		:<input type="number" class="data4"><br/>
			data5[등록일]		:<input type="date" class="data5"><br/>
			data6[성별]		:<input type="radio" name="data6" value="남">남	
				  			:<input type="radio" name="data6" value="여">여<br/>
			data7[개인정보동의] :<input type="checkbox" class="data7"> 개인정보동의<br/> 
			data8[사는지역3]	:<select class="data8"> 
								<option>안산</option> <option>안양</option> <option>수원</option>
									</select>									<br/>
			data9[자기소개]	: <textarea class="data9" rows="" cols=""></textarea> <br/>
			
			<button type="button" onclick="ex1()">전송 </button>
			
			<h3> [R] </h3>
			<div class="ex2_box"> </div>
			

					<!-- 1. JQUERY( ajax 사용하기 위해 ) -->
					<script src="http://code.jquery.com/jquery-latest.min.js"></script>
					
					<!-- 2. 사용자정의 js  -->
					<script src="index.js" type="text/javascript"></script>
</body>
</html>