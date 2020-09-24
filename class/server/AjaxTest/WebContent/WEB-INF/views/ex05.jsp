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
		width: 700px;
	}
</style>
</head>
<body>
	<!--  -->
	<div class="container">
		<h1>아이디 중복검사</h1>
		<form>
		<table class = "table table-bordered">
			<tr>
				<th>아이디</th>
				<td>
					<input type = "text" name = "id" id = "txtid">
					<button type = "button" id = "btnCheck">중복검사</button>
					<span id = "result"></span>
				</td>
			</tr>
		</table>
		<button id = "btnSubmit" disabled>가입하기</button>
		</form>
	</div>
	
	<script>
	
		$("#btnCheck").click(function(){
					
			//ajax 처리 
			$.ajax({
				type:"POST",
				url:"/ajax/ex05ok.do",
				data: "id="+$("#txtid").val(),
				dataType:"json",
				success:function(result){
					
					//result = {"use":1}
					//alert(result.use);
					// 페이지 새로 고침없이 하다 보니까 데이터 전송도 원활하게 함
					
					if(result.use == 0){
						$("#result").text("사용 가능한 아이디입니다.");
						$("#result").css("color","royalblue");
						$("#btnSubmit").attr("disabled",false);
					} else {
						$("#result").text("이미 사용중인 아이디입니다.");
						$("#result").css("color","tomato");
					}
					
				},
				error:function(a,b,c){
					console.log(a,b,c);
				}
				
			});
			
			
		});
		
	</script>
</body>
</html>


