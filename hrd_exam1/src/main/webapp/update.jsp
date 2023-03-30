<%@page import="controller.MemberDto"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%@ include file="header.jsp" %>
	<%
		int custno =Integer.parseInt(request.getParameter("custno"));
		Dao dao = new Dao();
		MemberDto dto = dao.getmember(custno);
	%>
	
	<center>
			<h3> 홈쇼핑 회원 정보수정 </h3>
	<form name="updateform" action="/hrd_exam1/join" method="get">
			<table border=1>
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input value="<%=dto.getCustno()%>" name="custno" type="text"></td>  <%--  value="<%=sustno%>" --%>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input value="<%=dto.getCustname()%>"  name="custname" type="text"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input value="<%=dto.getPhone()%>" name="phone" type="text"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input value="<%=dto.getAddress()%>" name="address" type="text"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input value="<%=dto.getJoindate()%>" name="joindate" type="text"></td>	<%--  value="<%=now%>"  --%>
				</tr>
				<tr>
					<td>고객등급[A:VIP,B:일반,C:직원]</td>
					<td><input value="<%=dto.getGrade()%>" name="grade" type="text"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input value="<%=dto.getCity()%>" name="city" type="text"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="onupdate()">수정</button>
						<a href="view.jsp"><button type="button" onclick="view()">조회</button></a>
					</td>	
				</tr>												
			</table>
		</form>	
	</center>
	
	<%@ include file="footer.jsp" %>
	
	<script src="/hrd_exam1/update.js" type="text/javascript"></script>

</body>
</html>