package com.test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex08_Transaction {
	public static void main(String[] args) {
		
		//Ex08_Transaction.java
		/*
		 
		 트랜잭션 처리
		 1. 오라클(DBMS)
		 	1.1 스크립트 작업 중 > 사용자 직접 > commit or rollback // 사람이 직접일을 할때 수동
		 	1.2 프로시저내에서.. 업무 제어(제어문 + exception) > commit or rollback 		자동
		 2. 자바(JDBC > 응용)
		 	- Connection 클래스를 사용 
		 
		 
		 
		*/
		
		//update(댓글 카운트 증가) -> insert(댓글 쓰기)
		Connection conn = null;
		Statement stat = null;
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open(); //연결 직후
			conn.setAutoCommit(false);
			
			stat = conn.createStatement(); // 실행
			
			String sql = "";
			
			//업무 A.
			sql = "update tblBoard set commentCount = commentCount+1" + 
					" where seq = 100";
				
			int result = stat.executeUpdate(sql); //AutoCommit, 적용된 행의 개수를 숫자로 반환함
			
			//업무B.
			sql = "insert into tblComment(seq,subject,pseq)" + 
					" values(13,'댓글',1)";
		
			result+=stat.executeUpdate(sql); //AutoCommit
			
			System.out.println("완료");
			
			//모든 업무를 커버할 수 있어, 논리적인 에러처리
			if(result==2) {
				conn.commit();
			} else {
				conn.rollback();
			}
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex08_Transaction.main()");
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
