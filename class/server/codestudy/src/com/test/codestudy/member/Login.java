package com.test.codestudy.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/login.do")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기(id,pw)
		//2. DB 작업 > select 
		//3. 결과 반환 > 완료 처리 
		
		//1. 
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//2. DB 작업 -> DAO 위임 
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		
		//dao.login(id,pw);
		int result = dao.login(dto); //1,0 
		
		//3. 
		if(result == 1) {
			
			//로그인 O
			//인증(Authentication), 허가(Authorization)
			
			//인증 티켓 발급 
			// - 개인, 전역 -> 세션 
			// 순수 자바에서 세션 얻어 오는 작업
			HttpSession session = req.getSession();
			
			session.setAttribute("id", dto.getId()); // 자유이용권의 유무와 같이, 인증 티켓 
			
			//회원 나머지 정보 -> 세션 추가
			MemberDTO dto2 = dao.getMember(dto.getId());
			
			session.setAttribute("name", dto2.getName()); // dB에서 가져온건 dto2
			session.setAttribute("pic", dto2.getPic());
			session.setAttribute("regdate", dto2.getRegdate());
			session.setAttribute("email", dto2.getEmail());
			session.setAttribute("seq", dto2.getSeq());
			
			
			resp.sendRedirect("/codestudy/index.do"); // 시작 페이지 
			
			
		} else {
			//로그인 X
			//resp.setCharacterEncoding("UTF-8"); => 한글로 쓰고 싶으면
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('failed');history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}
		
		
	
		
	}
}
