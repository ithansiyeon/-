<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/jquery-ui.js"></script>
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
		
		${list.get(0).catid}
		${list.get(0).x}
		${list.get(0).y}
		
		<img src = '/ajax/images/catty01.png' id = "cat1" class = "cat">
		<img src = '/ajax/images/catty02.png' id = "cat2" class = "cat">
		<img src = '/ajax/images/catty03.png' id = "cat3" class = "cat">
	
		
	</div>
	
	<script>
	
	
		$(".cat").draggable({
			stop:function(event,ui){
				/* alert(ui.position.top);
				alert(ui.position.left);
				alert(this.id); */
				
				//서버로 전송
				$.ajax({
						
					type: "GET",
					url: "/ajax/ex07ok.do",
					
					//data: "catid=cat1&x=100&y=200"
					data:"catid=" + this.id + "&x=" + ui.position.left + "&y=" + ui.position.top,
					
					//success:function(){} //수신할 데이터가 없을 때
					success:function(result){
						if(result==0){
							alert("고양이 정보를 서버에 저장하는 작업을 실패했습니다.");
						} 
					},
					error:function(a,b,c){
						console.log(a,b,c);
					}
					
				});
			}
		});
		
		<c:forEach items = "${list}" var = "dto">
		$("#${dto.catid}").css({
			"left":"${dto.x}px",
			"top":"${dto.y}px"
		});
		</c:forEach>
	</script>
</body>
</html>


