package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {
	public static void main(String[] args) {
		
		/*
	
		JDBC, Java DatatBase Connectivity
		- 자바 응용 프로그램(콘솔, 웹, 모바일 등...)과 데이터베이스 시스템(오라클, MySql, MS-SQL 등..)
		간의 연결 시켜주는 중간 계층
		
		- 사람(유저) <-> SQL Developer(툴) <-> SQL(질의) <-> 오라클(서버)
		- 자바(유저) <-> JDBC(툴) 		   <-> SQL(질의) <-> 오라클(서버)
	
		
		[사람 + SQL Developer]
		1. 실행
		2. 접속 
		 		2.1 호스트명: 서버 IP or 도메인 주소
		 		2.2. 포트번호: 1521
		 		2.3 SID : xe
		 		2.4. 드라이버: this(oci)
		 		2.5 사용자명 : hr
		 		2.6 비밀번호 : java1234
		 3. 질의(***)
		 	3.1 SQL 사용 
		 	3.2 반환값이 없는 쿼리(물리적인) 
		 		- select를 제외한 모든 쿼리(insert,delete..)
		 	3.3 반환값이 있는 쿼리 
		 		- 결과셋을 반환하는 쿼리
		 		- select 
		 		- 결과셋 > 업무에 사용 
		 	4. 접속 종료 
		 		4.1 commit or rollback
		 		4.2 접속 종료 
		 		
		 		
		[(사람 + Java) + JDBC]		
		
		1. 응용 프로그램(JAVA) 실행 
		2. 접속(JDBC) 
				- Connection 클래스 사용
		 		2.1 호스트명: 서버 IP or 도메인 주소
		 		2.2. 포트번호: 1521
		 		2.3 SID : xe
		 		2.4. 드라이버: this(oci)
		 		2.5 사용자명 : hr
		 		2.6 비밀번호 : java1234
		
		 3. 질의(***)
		 	- Statement 클래스 사용
		 	3.1 SQL 사용 
		 	3.2 반환값이 없는 쿼리(물리적인) 
		 		- select를 제외한 모든 쿼리(insert,delete..)
		 	3.3 반환값이 있는 쿼리
		 	 	- ResultSet 클래스 사용 -> select 결과셋 참조 (select 결과 테이블)
		 		- 결과셋을 반환하는 쿼리
		 		- select 
		 		- 결과셋 > 업무에 사용 
		 	4. 접속 종료 
		 		- Connection 클래스 사용
		 		4.1 commit or rollback
		 		4.2 접속 종료 
		 	
		 	Connection, Statement, ResultSet 클래스 
		 	- JDBC 관련 클래스 사용 > *.jar 참조 
		 	- 데이버테이스 제조사에서 제공 + DB 종류 or 버전에 따라 다양하게 제공
		 	
		 	JDBC 사용 환경 세팅하기 
		 	- ojdbcXX.jar
		 	- oracle 11g > ojdbc6.jar or ojdbc14.jar
		 	- C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
		 	
			
		*/
		
		
		//1. DB 접속 
		// - Connection 클래스
		Connection conn = null;
		
		//연결 문자열 생성(1번)
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //드라이버 서버 포트번호 xe
		String id = "hr";
		String pw = "java1234";
		
		try {
			// DB작업 > 외부 환경 > 예외 처리 필수
			
			// 설치된 JDBC 드라이버 로딩(상투적인 구문)
			Class.forName("oracle.jdbc.driver.OracleDriver"); // DB에 맞는 전용 드라이버
			//접속(DB 연결 + Connection 객체 생성 반환)
			conn = DriverManager.getConnection(url,id,pw); // conn DB 연결 관리하는 객체
			System.out.println(conn.isClosed()); // false(연결O), true(연결X)
			// 질의(업무) > select, insert, update, delete...
			

			//2. DB 접속 종료 
			// - Connection 클래스
			conn.close();
			System.out.println(conn.isClosed());
		}	
		catch(Exception e) {
			System.out.println("Ex01.main()");
			e.printStackTrace();
		}
		
		
		
	} //main

}
