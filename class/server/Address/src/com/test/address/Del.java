package com.test.address;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Del extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 삭제 
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > delete 
		//3. JSP 호출하기 
		
		//1. del.do?seq = 1
		String seq = req.getParameter("seq");
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			
			//2. 
			DBUtil util = new DBUtil();
			conn = util.open();
			String sql = "delete from tblAddress where seq = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, seq);
			
			int result = stat.executeUpdate();
			
			stat.close();
			conn.close();
			
			req.setAttribute("result", result);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/del.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
}
