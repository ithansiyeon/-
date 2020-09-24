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
		<% int dan = 2; %>
		<h1>구구단</h1>
		
		<% for (int i=1;i<=9;i++)  {%>
		<div><%= dan %> x <%= i %> = <%= dan*i %></div>
			
		<% } %>
		
		<hr>
		
		<%
			// 출력 버퍼(임시 페이지)에 쌓여 있는 내용을 지우고 다시 시작해라 
			//out.clear();
		
			//출력 버퍼(임시 페이지)에 쌓는 작업을 종료해라. => 출력만
			out.close();
		%>
		
		<h1>구구단</h1>
		<% 
			for(int i=1;i<=9;i++) {
				out.println(String.format("<div>%d x %d = %d</div>",dan,i,dan*i));
				
			}
		
		%>
	</div>
	
	<script>

	</script>
</body>
</html>