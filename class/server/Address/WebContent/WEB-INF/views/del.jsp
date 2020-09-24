<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file = "/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<div class = "container">
		<!-- WEB-INF는 직접 접근 할 수가 없어 -->
		
		<!-- 결과 메시지 -->
		<%@ include file = "/inc/header.jsp" %>
		<div class = "content">
			
			<c:if test="${result==1}">
			<!-- <div>주소록 삭제을 성공했습니다.</div>
			<div><a href = "/address/list.do">목록보기</a></div> -->
			</c:if>
			
			<c:if test = "${result == 0 || empty result}">
			<!-- div>주소록 삭제을 실패했습니다.</div>
			<div><a href = "#" onclick="history.back();">돌아가기</a></div> -->
			</c:if>
		</div>
		
		
	</div>
	
	<script>
		<c:if test="${result==1}">
		//alert("삭제 성공!!!");
		location.href="/address/list.do";
		</c:if>
		
		<c:if test = "${result == 0 || empty result}">
		alert("삭제 실패;;;");
		history.back();
		</c:if>
	</script>
</body>
</html>