package com.test.codestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Java DOC 주석 
// public 키워드에만 달았어, public 멤버에 주로 달음
/**
 * 
 * @author siyeon
 * 오라클 연결 클래스입니다.
 */
public class DBUtil {
	private Connection conn = null;
	/**
	 * 서버에 연결합니다.
	 * @return 연결 객체를 반환합니다.
	 */

	public Connection open() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //드라이버 서버 포트번호 xe
		String id = "hr";
		String pw = "java1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,id,pw); // conn를 돌려줌, conn 객체를 가지고 여러가지 행동을 함
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return null; // 접속 실패
	} // open
	
	/**
	 * 연결을 종료합니다.
	 */
	public void close() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // close 
		
	}
	
	/**
	 * 서버에 연결합니다.
	 * @param host 오라클 서버 주소
	 * @param id 계정명
	 * @param pw 비밀번호
	 * @return 연결 객체를 반환합니다.
	 */
	public Connection open(String host, String id, String pw) {
		
		String url = "jdbc:oracle:thin:@" + host + ":1521:xe"; //드라이버 서버 포트번호 xe
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,id,pw); // conn를 돌려줌, conn 객체를 가지고 여러가지 행동을 함
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return null; // 접속 실패
	} // open
}


