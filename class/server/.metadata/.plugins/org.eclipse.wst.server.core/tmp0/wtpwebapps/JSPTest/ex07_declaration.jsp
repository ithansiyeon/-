<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.test.jsp.Util" %>
<%! // 전역 영역(클래스 영역)
	public int sum(int a,int b){
		return a+b;
	}
	
	int c = 30; // 멤버 변수 
%>

<% // 지역 영역
	
	//메소드 선언 
	/* public int sum(int a,int b){
		return a+b;
	} */
	
	
	// 지역 변수(메소드 안에 들어가 있어) 
	int a = 10;
	int b = 20;
	
	Util util = new Util();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>

</style>
</head>
<body>
	<div><%= a %> + <%= b %> = <%= a+b %></div> 
	<div><%= a %> + <%= b %> = <%= sum(a, b) %></div>
	<div><%= a %> + <%= b %> = <%= util.sum(a, b) %></div>
	
	<script>
		
	</script>
</body>
</html>