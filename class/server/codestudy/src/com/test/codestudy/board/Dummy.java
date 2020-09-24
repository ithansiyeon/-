package com.test.codestudy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.codestudy.DBUtil;

public class Dummy {
	
	public static void main(String[] args) {
		//게시판 더미 데이터 
		//seq,subject,content,regate,readcount,mseq,thread,depth
		//자동, 난수 ,     고정,   자동,   , 자동, , 난수, 증가, 고정
		String[] subject = {"게시판 테스트입니다.","페이징 처리를 구현합니다.","키보드를 샀어요","JSP수업중입니다.","과자를 샀어여","비가 오네요","행복한 하루입니다.","이건 몇번째 페이지입니까?","그냥 테스트용 게시물입니다.",
				"이클립스가 무겁습니다.","헬로기티 귀엽다","안녕하세요."};
		String[] mseq = {"5","6"}; //본인 회원들 
		
		Connection conn = null;
		PreparedStatement stat = null;
		DBUtil util = new DBUtil();
		Random rnd = new Random();
		try {
			conn = util.open();
			String sql = "insert into tblBoard(seq,subject,content,regdate,readcount,mseq,thread,depth) values(seqBoard.nextVal,?,'내용입니다.',default,default,?,?,0)";
			
			stat = conn.prepareStatement(sql);
			for(int i=0;i<175;i++) {
				stat.setString(1, subject[rnd.nextInt(subject.length)]);
				stat.setString(2, mseq[rnd.nextInt(mseq.length)]);
				stat.setInt(3,(i+1)*1000);
				
				System.out.println(i+":"+stat.executeUpdate());
				
				
			}
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Dummy.main()");
			e.printStackTrace();
		}
		
	}
	
}
