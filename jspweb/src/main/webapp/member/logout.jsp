<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%	
			//모든 세션 지우기[초기화]
			//request.getSession().invalidate();
			
			//특정 세션지우기 [동일한 이름으로 null대입]
			request.getSession().setAttribute("login", null);
		%>	
	
		<!--여긴 그냥 페이지전환용  -->
		<script type="text/javascript">
			location.href ="/jspweb/index.jsp";
		
		</script>
	
	

</body>
</html>