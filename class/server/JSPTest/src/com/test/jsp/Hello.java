package com.test.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//JDBC 작업 + 업무 등등...
		//PrintWriter -> JSP
		
		String name = "Hong";
		
		req.setAttribute("name", name);
		
		// / : webcontent
		//resp.sendRedirect("hello.jsp"); 
		//pageContext.forward("hello.jsp");
		
		
		// 서블릿이 서블릿을 부른 거야 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
		
		dispatcher.forward(req, resp);
		// 서버 쪽에서 이동, jsp가 돌려준거야 서블릿 주소가 남아  
		// 맡긴다. => 이동한다.
		
		
		
	}
	
}
