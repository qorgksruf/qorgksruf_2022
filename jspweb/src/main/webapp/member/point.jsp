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
		
		<div class="container">
			
			<h3>포인트결제</h3>
			<button type="button" onclick="setpay(10000)">10000원</button>
			<button type="button" onclick="setpay(50000)">50000원</button>
			
			<button type="button" onclick="requestPay()">카드결제</button>

		</div>


		<!--포트원 결제 js  -->
		<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
		<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
		<script src="/jspweb/js/member/point.js" type="text/javascript"></script>
</body>
</html>