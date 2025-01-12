<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	//현재 상황
	// 요청 ~ 응답 사이에 지속적으로 특정 데이터를 유지해야 하는 상황
	// - one -> two
	
	//1. 지역 변수 사용(X)
	int a = 10;
	
	//3. pageContext 사용(X) 
	pageContext.setAttribute("c",30);
	                     
	//4. request 사용(O) ***
	// - pageContext.forward()와 같이 사용했을 때만 가능
	request.setAttribute("d", 40);
	
	//5. session 사용(O) ***
	session.setAttribute("e", 50);
	//접속만 되면 살아남아 있음
	// 생명주기 session > request > pageContext 
	
	//6. application 사용(O) => 절대로 사용하지 않음
	application.setAttribute("f", 60);
	
	//request, session, application 데이터 충돌 발생 -> 해결
	request.setAttribute("name", "홍길동");

%>
<%
	//2. 멤버 변수 사용(X)
	int b = 20;
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file = "inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<div class = "container">
		<h1>첫번째 페이지</h1>
		<a href = "ex18_two.jsp">두번째 페이지</a>
	</div>
	
	<script>
		//location.href = "ex18_two.jsp";
	</script>
	<%
		//response.sendRedirect("ex18_two.jsp");
		pageContext.forward("ex18_two.jsp");
		//pageContext 생명주기가 그 페이지만이야
	%>
</body>
</html>