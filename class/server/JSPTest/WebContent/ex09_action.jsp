<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	//1. 클라이언트(브라우저) : UTF-8
	//2. 데이터 전송 
	//3. 인터넷(WEB) ~~~ 서버 도착 : ISO-8859-1 
	//4. 서버 수신 : UTF-8 
	

	//데이터 수신하기 
	request.setCharacterEncoding("UTF-8"); // 첫줄에 적어

	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	//텍스트 박스 
	String txt1 = request.getParameter("txt1"); // 인터넷상에서는 무조건 문자열로 반환을 함

	//암호 박스
	String pw1 = request.getParameter("pw1");
	
	//다중 라인
	String txt2 = request.getParameter("txt2");
	txt2 = txt2.replace("\n", "<br>");
	
	//체크 박스
	//1. value O
	// - 체크O : value
	// - 체크X : null
	//2. value X
	// - 체크O : "on"
	// - 체크X : null
	String cb1 = request.getParameter("cb1");
	
	String cb2 = request.getParameter("cb2");
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	
	String temp = "";
	
	/* temp로 관리함 */
	for(int i=2;i<=4;i++){
		temp += request.getParameter("cb"+i)+",";
	}
	
	String[] cb = request.getParameterValues("cb");
	//같은 이름을 한꺼번에 받을 수 있어
	
	//라디오 버튼(단일값 컨트롤)
	String [] rb =request.getParameterValues("rb"); // 길이가 1짜리 배열이 만들어져, 사용X
	System.out.println(Arrays.toString(rb)); //[on], [on]
			
	String rb2 = request.getParameter("rb"); // 사용O
	System.out.println(rb2); //[y],y,[n],n
	
	//셀렉트
	String sel1 = request.getParameter("sel1");
	
	//달력
	String date1 = request.getParameter("date1");
	
	//범위
	String range1 = request.getParameter("range1");
	
	//자바스크립트(히든 태그)
	String jvalue = request.getParameter("jvalue");
	
	//단일 데이터 : request.getParameter()
	//다중 데이터 : request.getParameterValues()
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	div{
	margin-bottom:15px;
	}
</style>
</head>
<body>

	<h1>데이터 수신하기</h1>
	<div>이름: <%= name %></div>
	<div>나이: <%= age %></div>
	
	<h1>폼 데이터 수신하기</h1>
	<div>텍스트 박스: <%= txt1 %></div>
	
	<div>암호상자: <%= pw1 %></div>
	<div>다중 라인: <%= txt2 %></div>
	<div>체크 박스: <%= cb1 %></div>
	
	<div>체크 박스 : <%= cb2 %>, <%= cb3 %>, <%= cb4 %></div>
	<div>체크 박스 : <%= temp %></div>
	<div>체크 박스 : <%= Arrays.toString(cb) %></div>
	<div>라디오 버튼 : <%= rb2 %></div>
	<div>셀렉트 : <%= sel1  %></div>
	<div>달력 : <%= date1 %></div>
	<div>범위 : <%= range1 %></div>
	<div>자바스크립트 : <%= jvalue %></div>
	<script>

	</script>
</body>
</html>