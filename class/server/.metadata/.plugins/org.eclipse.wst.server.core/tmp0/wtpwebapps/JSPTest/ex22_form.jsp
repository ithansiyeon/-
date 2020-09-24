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
		<h1>파일 업로드</h1>
		<!-- 
			cos.jar 
			- 무료, 파일 업로드 라이브러리 
			
			1. 반드시 <form method = "POST">를 사용한다. 
			2. enctype 속성을 명시한다.
				- enctype = "multipart/form-data" // 바이너리 데이터 포함 
				- enctype = "application/x-www-form-urlencoded" // 기본값(문자열) 
				
				
		 -->
		<form method = "POST" enctype = "multipart/form-data" action = "/jsp/ex22_formok.do">
			<div>제목 : <input type = "text" name = "subject"></div>
			<div>이름 : <input type = "text" name = "name"></div>
			<div>파일 : <input type = "file" name = "attach"></div>
			<hr>
			<button>등록하기</button>
		</form>
	</div>
	
	<script>

	</script>
</body>
</html>