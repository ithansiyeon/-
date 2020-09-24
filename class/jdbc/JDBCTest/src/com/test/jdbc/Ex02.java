package com.test.jdbc;

import java.sql.Connection;

public class Ex02 {
	public static void main(String[] args) {
		
		DBUtil util = new DBUtil();
		 Connection conn = null;
		
		
		 try {
			 //conn = util.open(); //접속O
			 conn = util.open("211.63.89.36", "hr", "java1234");
			 System.out.println(conn.isClosed());
			 
			 util.close(); //접속X
		 
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 
	}

}
