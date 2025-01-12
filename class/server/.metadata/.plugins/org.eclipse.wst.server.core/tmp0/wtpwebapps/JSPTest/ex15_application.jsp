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
		<h1>Application</h1>
		<!-- 
			서블릿과 JSP는 사용하는 컨테이너(톰캣)에 따라 달라진다.
			- 톰캣의 버전에 따라 서블릿과 JSP 버전이 달라진다.
			
			톰캣 v8.X -> 서블릿 3.1
			
			
		 -->
		<div>서블릿 버전: <%= application.getMajorVersion() %>.<%=application.getMinorVersion() %></div>
		
		<div>
			컨테이너 정보 <%= application.getServerInfo() %>
			<br>
			<%= application.getContextPath() %> 
			<!-- request.getContextPath() -->
			<br>
			<%= application.getRealPath(".") %> <!-- **** 상대 경로를 파일 절대 경로로 변환한다. 
			서버측의 실제 경로를 반환, 임시 공간에다가 복사해서 씀 -->
			<br>
			<%= application.getServletContextName() %>
			<!-- 현재 프로젝트 이름 -->
		</div>
		<div>
			JSP 버전
			<%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
		</div>
		<div><%= session.getAttribute("name") %></div>
	</div>
		
	<script>

	</script>
</body>
</html>