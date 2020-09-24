<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<!--  -->
	<div class="container">
		<h1>Ajax 응답 데이터</h1>

		<h2>Text</h2>
		<button tyep="button" id="btn1">클릭</button>
		<div id="result1" class="well"></div>

		<h2>XML</h2>
		<button tyep="button" id="btn2">클릭</button>
		<div id="result2" class="well"></div>

		<h2>JSON</h2>
		<button tyep="button" id="btn3">클릭</button>
		<div id="result3" class="well"></div>



	</div>
	<!-- 데이터가 적으면 get -->
	<!-- text는 데이터가 많으면 불편, 받아써 쓰는 입장에서 불편 -->
	<script>
		$("#btn1").click(function(){
			//ajax -> 전송 데이터(X), 수신 데이터(O)
			$.ajax({
				//요청 정보
				type: "GET",  
				url: "/ajax/ex04ok.do",
				
				//전송 데이터
				data:"type=4",
				
				//수신 데이터의 형식
				dataType:"text",		
				
				//수신 데이터, result 안에 들어옴
				success: function(result){
					//$("#result1").text(result);
					
					var lines = result.split("\n");
					lines.forEach(function(item,index){
						//console.log(item);
						var column = item.split(",");
						$("#result1").append("<div>("+column[0]+")" + column[1] + "[" + column[2]+"]</div>");
					});
					
				},
				
				//예외 처리
				error:function(a,b,c){
					console.log(a,b,c);
				}
				
			});
			
		});
		
		//다량의 데이터 일수록 구조화된게 접근성이 쉬워 xml,json을 주로 씀, ajax는 데이터를 xml 형태로 주고 받음 => ajax 주로 json
		$("#btn2").click(function(){
			$.ajax({
				type: "GET",  
				url: "/ajax/ex04ok.do",	
				data:"type=5",
				dataType:"xml",	//받는 데이터	
				success: function(result){
					//result -> 단순 데이터(X) , XML Document 객체, xml 전부다 가지고 있는 
					//$("#result2").text($(result).find("item").text());
					$(result).find("item").each(function(index,item){
							//<item>
							$("#result2").append("<div>"+$(item).find("seq").text()+"."+$(item).find("subject").text()+"</div>");
						
					});
					
					
					
				},
				error:function(a,b,c){
					console.log(a,b,c);
				}
				
			});
		});
			
		$("#btn3").click(function(){
			$.ajax({
				type: "GET",  
				url: "/ajax/ex04ok.do",	
				data:"type=6",
				dataType:"json",	//받는 데이터	
				success: function(result){
					//result = {"result":"111"};
					//$("#result3").text(result.result);
					
					//result = [{},{},{}]
					
					$(result).each(function(index,item){
						//item.seq
						//item.subject
						//item.regdates
						
						$("#result3").append("<div>" + item.subject + "</div>")
						
					});
				},
				error:function(a,b,c){
					console.log(a,b,c);
				}
				
			});
		
		});
		
	</script>
</body>
</html>


