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
		<h1>Hello</h1>
		
		<div><%=request.getAttribute("name") %></div>
		<div>${name}</div>
	</div>
	
	<script>

	</script>
</body>
</html>