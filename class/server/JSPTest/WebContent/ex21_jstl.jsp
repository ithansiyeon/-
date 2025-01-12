<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- JSTL 참조 -->
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>



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
		<h1>JSTL+EL</h1>
		
		<h2>변수 선언</h2>
		
		<%
			int a = 10; //지역 변수 
			pageContext.setAttribute("b", 20); //pageContext 변수 
		%>
		<!-- JSTL 변수 : 자동으로 pageContext 요소가 된다. > EL 사용 -->
		<c:set var = "c" value = "30"></c:set>
		
		<div>a ; <%= a %></div>
		<div>b : <%= pageContext.getAttribute("b") %></div>
		<div>b : ${b}</div> 
		<!-- pageContext나 request만 가능 -->
		
		<!-- <div>c :<%--  <%= c%> --%> </div> -->
		<!-- <div>c: 10 </div> -->
		<%-- <div>c: 10 </div> --%>
		
		<%-- <div>c : <%= c %></div>  --%>
		<div>c: ${c}</div>
		<div>c : <%= pageContext.getAttribute("c") %></div>
		
		<h2>변수 수정</h2>
		<c:set var = "c" value = "300"></c:set>
		<!-- HashMap과 같아, 똑같은 값을 찾아서 교체한 것 -->
		<div>c: ${c}</div>
		
		<h2>변수 삭제</h2>
		<c:remove var = "c" />
		<div>c:${c}</div>	
		<div>c: ${empty c}</div>
		<div>b: ${empty b}</div>
		<!-- null이 찍힌 것 -->
		
		<%
			Random rnd = null;
		%>
		
		<c:set var = "d" />
		<div>rnd : <%= rnd %></div>
		<div>d: ${d}</div>
		
		<hr>
		
		<h2>조건문</h2>
		
		<c:set var = "n" value = "0" />
		<div>n : ${n}</div>
		
		<c:if test = "${n > 0}">
		<div>${n}은 양수입니다.</div>
		</c:if>
		<c:if test = "${n < 0}">
		<div>${n}은 음수입니다.</div>
		</c:if>
		
		<c:choose>
			<c:when test = "${n > 0 }">양수</c:when>
			<c:when test = "${n < 0 }">음수</c:when>
			<c:otherwise>0</c:otherwise>
		</c:choose>
		
		<h2>반복문(일반 for + 향상된 for)</h2>
		
		<h3>일반 for</h3>
		<!-- step : 음수 사용 불가능 -->
		<c:forEach var = "i" begin="1" end = "10" step = "1">
			<div>${i}</div>
		</c:forEach>
		<!-- pageContext에 들어가 있어, step은 반드시 양수 -->
		
		<h3>향상된 for</h3>
		<%
			String[] color = {"빨강","노랑","파랑","검정","하양"};
			
			// 어떤 자원(자바)을 JSTL로 접근 > 내장객체 변수로 등록??? > JSTL이 데이터를 접근할 때 EL을 사용하기 때문에!!!
			
			pageContext.setAttribute("color", color);	
			
		
		%>
		<ul>
		<% for(String name : color){ %>
			<li><%= name %></li>
		<% } %>
		</ul>
		
		<ul>
		<c:forEach var="name" items = "${color}">
			<li>${name}</li>
		</c:forEach>
		</ul>
		
	</div>
		
	<script>
		
	</script>
</body>
</html>