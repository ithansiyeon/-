package com.test.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ex22_formok.do")
public class Ex22_FormOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파일 업로드 처리 
		//1. 업로드된 파일을 어디에 저장할지 결정 
		// - 웹 경로 표기(X) -> 로컬 파일 경로 표기(O)
		
		//가상 경로 & 상대 경로 
		//String path = "/files";
		//String path = "D:\\class\\server\\JSPTest\\WebContent\\files";
		
		String path = req.getRealPath("/files"); // 가상경로 => 물리적인 경로로
		
		//D:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\files
		// 이거를 복사본으로 작업 공간으로 떠 놓아, 임시 폴더 안에 있는 programs 파일로 잡혀 
		System.out.println(path);
		
		//2. 업로드핧 파일의 최대 크기 
		// - 최대한 작게 
		// - 게시판(100MB)
		// - 바이트
		
		int size = 1024*1024*100; //100MB
		
		//3. 변수 선언 
		String subject = ""; 		// 제목
		String name = ""; 			// 이름
		String filename = ""; 		//첨부파일명
		String orgfilename = "";	// 첨부파일명
		
		//<form enctype = "multipart/form-data"
		// -> 기존의 req.getParameter() 메소드가 동작을 안한다.
		//subject = req.getParameter("subject");
		//System.out.println(subject); //null
		
		req.setCharacterEncoding("UTF-8");
		
		try {
			//기본의 request를 대신할 객체 
			//cos.jar 
			// MultipartRequest 객체를 만드는 순간 파일업로드도 같이 진행된다.
			MultipartRequest multi = new MultipartRequest(
					req, // 기존의 request 객체 
					path, // 업로드 폴더 
					size, // 업로드 크기 
					"UTF-8", // 인코딩 
					new DefaultFileRenamePolicy() // 똑같은 이름의 파일을 넘버링
					);
			subject = multi.getParameter("subject");
			//System.out.println(subject);
			name = multi.getParameter("name");
			
			//첨부파일명
			filename = multi.getFilesystemName("attach"); // <input type = "file" name = "attach">
			//System.out.println(filename);
			orgfilename = multi.getOriginalFileName("attach"); //물리적인 이름
			//System.out.println(orgfilename); // 넘버링 하기 전의 이름 , 원본 이름 
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("subject", subject);
		req.setAttribute("name", name);
		req.setAttribute("filename", filename);
		req.setAttribute("orgfilename", orgfilename);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ex22_formok.jsp");
		dispatcher.forward(req, resp);
		
		
	}
}
