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
		
		<h1>업로드 결과</h1>
		
		<div>제목 : ${subject }</div>
		<div>이름 : ${name }</div>
		<div>첨부파일명 : ${filename }</div>
		<div>첨부파일명 : ${orgfilename }</div>
		
		<hr>
		
		<a href = "/jsp/files/${filename}" download>다운로드</a>
		
	</div>
	
	<script>

	</script>
</body>
</html>