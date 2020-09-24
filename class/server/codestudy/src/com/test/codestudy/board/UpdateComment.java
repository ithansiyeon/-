package com.test.codestudy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/updatecomment.do")
public class UpdateComment extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		String bseq = req.getParameter("bseq");
		String comment = req.getParameter("comment");
		
		BoardDAO dao = new BoardDAO();
		int result = dao.updateComment(seq,comment);
		
		//3. 
				if(result == 1) {
					//댓글 수정 성공
					resp.sendRedirect("/codestudy/board/view.do?seq="+bseq);
				} else {
					//댓글 삭제 실패
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
