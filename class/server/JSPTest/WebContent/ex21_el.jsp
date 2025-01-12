<%@page import="com.test.jsp.Student"%>
<%@page import="java.util.HashMap"%>
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
		<h1>EL</h1>
		
		<%
			
			//자바 데이터 
			int a = 10;
			
			//내장 객체 데이터
			pageContext.setAttribute("b", 20);
			
		
		%>
		
		<h2>자바 표현식</h2>
		<div>a : <%= a %></div>
		<div>b : <%= pageContext.getAttribute("b") %></div>
		<div>b : <%= (int)pageContext.getAttribute("b") * 2 %></div>
		
		<h2>EL</h2>
		<div>a : ${a}</div>
		<div>b : ${b}</div>
		<div>b: ${b * 2}</div>
		
		<% 
			int c = 30;
			pageContext.setAttribute("d", 30);
		%>

		<h2>EL + 연산</h2>

		<div>c+10=<%=c + 10%></div>
		<div>d+10 = <%= (int)pageContext.getAttribute("d")+10 %></div>
	
		<div>d+10=${d+10}</div>
		<div>d-10=${d-10}</div>
		<div>d*10=${d*10}</div>
		<div>d/10=${d/10}</div>
		<div>d%10=${d%10}</div>
	
		<div>d &gt; 10 = ${d>10}</div>
		<div>d &lt; 10 = ${d<10}</div>
		<div>d == 10 = ${d==10}</div>
		<div>d != 10 = ${d!=10}</div>
		
		<div> d > 0 ? "합격" : "불합격" ${d>0?"합격":"불합격"}</div>
		
		<h2>HashMap 지원</h2>
		
		<%
			
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("name","홍길동");
			map.put("job","학생");
			map.put("address","서울시");
			
			pageContext.setAttribute("map", map);
		
		%>
		
		<div>이름 : <%= map.get("name") %></div>
		<div>직업 : <%= map.get("job") %></div>
		<div>주소 : <%= map.get("address") %></div>
		
		<div>이름 : ${map.get("name")}</div>
		<div>직업 :${map.job}</div>
		<div>주소 : ${map.address}</div> 
		<div>주소 : ${map["address"]}</div>
		
		<!-- 멤버 변수와 같이 -->
		<h2>객체 지원</h2>
		<%
			Student s = new Student();
			s.setName("아무개");
			s.setGender("남자");
			s.setAge("20");
			
			pageContext.setAttribute("s", s);
		%>
		
		<div>이름: <%= s.getName() %></div>
		<div>성별: <%= s.getGender()%></div>
		<div>나이: <%= Integer.parseInt(s.getAge())-1 %></div>
		
		<div>이름:  ${s.getName()} </div>
		<div>이름:  ${s.name} </div>
		<div>성별:  ${s.gender}</div>
		<div>나이:  ${s.age -1}</div>
		<!-- 암시적인 형변환으로 도배시켜 놓았어 -->
	</div>
	
	<script>

	</script>
</body>
</html>