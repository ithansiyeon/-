package com.test.codestudy.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/list.do")
public class List extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. DB 작업 > select 
		//2. 결과값 전달 + JSP 호출하기 
		
		HttpSession session = request.getSession();
		
		//목록 or 검색 
		// - 목록 : list.do
		// - 검색 : list.do?search=홍길동
		String search = request.getParameter("search");
		
		//정렬 기준
		// - list.do -> seq(thread)
		// - list.do?sort=seq
		// - list.do?sort=heart
		// - list.do?sort=readcount
		String sort = request.getParameter("sort");
		
		if(sort == null || sort == "") {
			sort = "thread"; // 기본값
		}
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("search", search);
		map.put("sort", sort);
		
		//페이징 처리 관련 변수
		int nowPage = 0; //현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한 페이지 당 출력 갯수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // rnum 시작 번호
		int end = 0; // rnum 끝 번호
		int n = 0; // 페이지바 관련 변수
		int loop = 0; // 페이지바 관련 변수
		int blockSize = 10; //페이지바 관련 변수
		
		//list.do -> list.do?page=1 변경  
		//list.do?page=3
		String page = request.getParameter("page");
		
		if(page == null || page == "") nowPage = 1; //default
		else nowPage = Integer.parseInt(page); // 보고 싶은 페이지
		
		//nowPage -> 보려는 페이지 번호!!
		//1page -> where rnum 1 >= 10 && rnum <= 10 
		//2page -> where rnum 1 >= 11 && rnum <= 20 
		//3page -> where rnum 1 >= 21 && rnum <= 30
		begin = ((nowPage-1)*pageSize)+1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin+"");
		map.put("end",end+"");
		
		//1.
		BoardDAO dao = new BoardDAO();
		
		//총 페이지 수 계산하기
		//총 페이지수  = 총게시물 수 / 한페이지당 출력 게시물 수 
		// ? = 175 / 10 -> 17.5 -> 18 
		totalCount = dao.getTotalCount(map); //검색어 포함
		//System.out.println(totalCount);
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		//System.out.println(totalPage);
		
		
		ArrayList<BoardDTO> list = dao.list(map);
//		System.out.println(list.size());
		//list : 게시판 목록 원본 
		// -> list 가공 
		
		//데이터 가공 시점
		// - 최소 규칙 : 최대한 빨리한다.
		
		//1. SQL 
		//2. 서블릿 : 시분초가 필요할떄도 있어서 
		//3. JavaScript 
		// 데이터의 성질하고 어디에서 가공하는게 좋은지 
		
		//1.5 
		Calendar now = Calendar.getInstance();
		
		for (BoardDTO dto : list) {
			//c. 최신글 표시하기 
			// - 글쓴지 1시간 이내
			// - 현재 시각 - 글쓴 시간 < 1시간 
			// (tick) 오라클은 날짜 - 날짜 
			
			// b. 오늘 쓴글 구분하기
			if (dto.getRegdate().startsWith(String.format("%tF", now))) { // 2020-08-04
				
				dto.setRegdate(dto.getRegdate().substring(11));
				
			} else {
			// a. 날짜 추출하기
//			System.out.println(dto.getRegdate());
				dto.setRegdate(dto.getRegdate().substring(0, 10));
				
			}
			//list.do
			//search != null
			//1. list.do -> false
			//2. list.do?search=홍길동 -> true
			//3. list.do?search= -> true 
			//request.getParameter("search")
			//1. list.do -> null 반환
			//2. list.do?search=홍길동 -> '홍길동' 반환
			//3. list.do?search=> 빈문자열 반환
			if(search != null && search != "") {
			//d. 검색어 부각시키기 
			// - 제목
			String subject = dto.getSubject();
			subject = subject.replace(search,"<span style = 'font-weight:bold;color:tomato;'>"+search+"</span>");
			dto.setSubject(subject);
			
			String name = dto.getName();
			name = name.replace(search,"<span style = 'font-weight:bold;color:tomato;'>"+search+"</span>");
			dto.setName(name);
			}

		} //for
		
		
		//새로고침 조회수 증가 방지 
		session.setAttribute("read", false);
		// view에서 on/off 스위치로 쓰임
		
		/*
		 
		 <nav class="pagebar">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li>
                        	<a href="/codestudy/board/list.do">1</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
		 
		 */
		
		
		//페이지바 제작
		loop = 1; // 10바퀴씩 돌기 위한 
		n = ((nowPage-1)/blockSize) * blockSize + 1;
		
		//list.do?page=1
		// 1 2 3 4 5 6 7 8 9 10
		
		//list.do?page=3 
		// 1 2 3 4 5 6 7 8 9 10
		
		//list.do?page=11
		// 11 12 13 14 15 16 17 18 19 20
		
		
		String pagebar = "";
		if(search==null) {
			search = "";
			
		}
		
		pagebar+="<nav class=\"pagebar\">";
		pagebar+="<ul class=\"pagination\">";
		//이전 10페이지
		if(n==1) {
		pagebar+="<li class = 'disabled'>";
		pagebar+="<a href=\"#!\" aria-label=\"Previous\">";
		pagebar+="<span aria-hidden=\"true\">&laquo;</span>";
		pagebar+="</a>";
		pagebar+="</li>";
		} else {
		pagebar+="<li>";
		pagebar+=String.format("<a href=\"/codestudy/board/list.do?page=%d&search=%s&sort=%s\" aria-label=\"Previous\">",n-1,search,sort);
		pagebar+="<span aria-hidden=\"true\">&laquo;</span>";
		pagebar+="</a>";
		pagebar+="</li>";
		}
		
//		for(int i=1;i<=totalPage;i++) {
		while(!(loop>blockSize || n >totalPage)) { // 10바퀴 , 지금 번호가 최대 페이지를 넘어가면 안돼서
			//페이지 번호
			
			if(n == nowPage) { // 지금 보고 있는 페이지냐?
			pagebar+="<li class = 'active'>";
			pagebar+=String.format("<a href=\"#!\">%d</a>",n);
			pagebar+="</li>";
			} else {
				pagebar+="<li>";
				pagebar+=String.format("<a href=\"/codestudy/board/list.do?page=%d&search=%s&sort=%s\">%d</a>",n,search,sort,n);
				pagebar+="</li>";
			}
			loop++;
			n++;
		}
		
		//다음 10페이지
		// 총 페이지수보다 클떄 좇겨나면 돼 
		if(n > totalPage) {
			pagebar+="<li class = 'disabled'>";
			pagebar+="<a href=\"#!\" aria-label=\"Next\">";
			pagebar+="<span aria-hidden=\"true\">&raquo;</span>";
			pagebar+="</a>";
			pagebar+="</li>";
		} else {
			pagebar+="<li>";
			pagebar+=String.format(" <a href=\"/codestudy/board/list.do?page=%d&search=%s&sort=%s\" aria-label=\"Next\">",n,search,sort);
			pagebar+="<span aria-hidden=\"true\">&raquo;</span>";
			pagebar+="</a>";
			pagebar+="</li>";
		}
		
		pagebar+="</ul>";
		pagebar+="</nav>";
		
		
		//2. 줘야지 알음
		request.setAttribute("list",list);
		request.setAttribute("search", search);
		request.setAttribute("sort", sort);
		
		request.setAttribute("page", page);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pagebar", pagebar);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(request, response);
		
	}

}

