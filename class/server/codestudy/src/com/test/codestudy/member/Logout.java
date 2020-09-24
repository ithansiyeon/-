package com.test.codestudy.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//링크라서 
		
		//1. 인증 티켓 제거 
		//2. 시작 페이지로 이동 
		
		//1.
		HttpSession session = req.getSession();
		
		//session.removeAttribute("id"); //로그 아웃
		//session.removeAttribute("name");
		
		//2.
		session.invalidate(); // 현재 세션을 소멸 시켜, 5개의 데이터 한번에 날라가 
		
		
		//2. 
		resp.sendRedirect("/codestudy/index.do");
		
		
	}
}
