<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<%@ include file = "/inc/header.jsp" %>
		<div class = "content">
			<form method="POST" action="/address/addok.do">
				<table class = "table table-bordered add">
					<tr>
						<th>이름</th>
						<td><input type = "text" name = "name" id = "name" class = "form-control short" required="required"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type = "number" name = "age" id = "age" class = "form-control short" required="required"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type = "text" name = "address" id = "address" class = "form-control" required="required"></td>
						<!-- 데이터를 클라이언트 서버로 전송 : form이나 링크, 서블릿 <=> 서블릿 : request 나 session -->
					</tr>
				</table>
				<div class = "btns">
					<button type = "submit" class = "btn btn-primary">쓰기</button>
					<button type = "button" onclick="history.back();" class = "btn btn-default">뒤로</button>
				</div>
			</form>
		</div>
		
		
	</div>
	
	<script>
		function dummy(){
			$("#name").val("홍길동");
			$("#age").val(20);
			$("#address").val("서울시 강동구 명일동");
		}
		dummy();
	</script>
</body>
</html>