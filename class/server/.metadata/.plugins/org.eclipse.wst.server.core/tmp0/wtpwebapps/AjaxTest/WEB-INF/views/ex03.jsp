<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>
	.container {
		width: 900px;
	}
</style>
</head>
<body>
	<!-- template.jsp > ex02.jsp -->
	<div class="container">
		<h1>Ajax</h1>
		<!-- 
		[기본 방식]
		- 페이지 바뀐다 > 브라우저 화면이 바뀐다.(깜박임) > 작업 상태를 유지 못한다.
		1. 버튼을 누른다.
		2. 입력값을 서버로 전송한다.
		3. 서버 > 입력값을 DB값 더한 후 반환한다.
		4. 반환된 값을 화면에 출력한다.
		
		 -->
		 		 
		 <!-- 서버와 데이터를 주고 받는 행동은 나머지 작업하고 동시에 하면 안돼 -->
			<form>
			<input type="text" name="txt1" id="txt1">
			<input type="button" value="버튼1" id="btn1">
			<div id="result1">결과: <span></span></div>
		</form>
		
		<hr>
		다른 작업: <input type="text">
	</div>
		
	<script>
	
		/* 
		Ajax
		1. 순수 자바스크립트
		2. 각종 라이브러리(jQuery)
		*/
		
		$("#btn1").click(function(){
			
			//1. 서버에 데이터 보내기 
			//2. 서버로부터 데이터 받기 
			//var xhr = new XMLHttpRequest(); //ajax 객체 
			
			//$("대상(태그)").메소드();
			
			//$.ajax(); // $ : 전역함수
			
			$.ajax({
				//페이지 요청
				type:"POST",
				url : "/ajax/ex03ok.do",
				// 동기(false) vs 비동기(true)
				// 동기는 작업이 끝날때까지 못써
				// - ajax > 비동기 방식을 사용한다.
				async:true,
				
				//요청 + 데이터 전달(전송)
				data:"txt1="+$("#txt1").val(),
				//요청 + 결과 반환(응답)
				success:function(result){
					//alert(result);
					$("#result1 > span").text(result);
				},
				//Ajax 에러 처리
				error:function(a,b,c){
					console.log(a,b,c);
				}
			})
			
			
			
		});
	</script>
</body>
</html>


