<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- 

경로
1. 절대 경로: 루트가 이미 정해져 있어서 타고 내려오는, /로 시작하는게  
2. 상대 경로: . 현재페이지

"/Context Root" -> WebContent 폴더 
"/jsp" -> WebConetent 폴더


*** inc 폴더내의 파일(조각 페이지)에서는 되도록 절대 경로를 사용하는 것이 좋다.

 -->
<link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/bootstrap.css">
<script src = "<%= request.getContextPath() %>/js/jquery-1.12.4.js"></script>
<script src = "<%= request.getContextPath() %>/js/bootstrap.js"></script>

<!-- <link rel = "stylesheet" href = "../css/bootstrap.css">
<script src = "../js/jquery-1.12.4.js"></script>
<script src = "../js/bootstrap.js"></script> -->
