<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
		<h1>두번째 페이지</h1>
		<!-- request 끝날떄지만 살아남아 c로 돌아오는 순간 사라져, 새로운 인스턴스가 만들어져서 
		하나의 문맥에서 다른 문맥으로 이동해서 이전에 사용했던 자원들이 소멸돼서 없어짐 -->
		<div><%= request.getAttribute("num") %></div>
		<div><%= request.getAttribute("name") %></div>
		<div><%= request.getAttribute("age") %></div>
		
		<div><%= pageContext.getAttribute("color") %></div>

	</div>
	
	<script>

	</script>
</body>
</html>