package com.test.dummy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/**
 * 
 * @author siyeon
 * 답변 더미를 생성하는 클래스입니다.
 */

public class answerDummy {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		String answer[] = {"에어컨을 가동시켰습니다.","불만사항을 처리하였습니다.","기차 내부를 깨끗이 청소하였습니다.",
				"안내방송으로 안내해드리겠습니다.","분실물 접수가 완료되었습니다.","고장난 부분을 수리하였습니다.","난방을 가동하였습니다.","개선 사항을 접수후 다시 문자드리겠습니다."
						, "기차 방역을 하였습니다.","마스크를 타고 지하철을 이용할 수 있도록 하겠습니다.","에어컨을 껐습니다.","난방을 껐습니다."};
		String num[] = {"1","2","3","4","5"};
		DBUtil util = new DBUtil();
		String sql = null;
		Statement stat = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = util.open("121.143.237.8","subway","java1234");
			stat = conn.createStatement();
			
			for (int i = 0; i < 100; i++) {
				sql = String.format("insert into tblAnswer values(answer_Seq.nextVal,'%s',default,%d,%s)",
						answer[rnd.nextInt(answer.length)],i+1,num[rnd.nextInt(num.length)]);
				stat.executeUpdate(sql);
			}
				
			System.out.println("완료");
			/*
			System.out.println("[seq]\t[delflag]\t[comseq]\t[adseq]\t[content]");
			sql = "select * from tblanswer";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.printf("%s\t",rs.getString("seq"));
				System.out.printf("%s\t\t",rs.getString("delflag"));
				System.out.printf("%3s\t\t",rs.getString("comseq"));
				System.out.printf("%s\t",rs.getString("adseq"));
				System.out.printf("%s",rs.getString("content"));
				System.out.println();
			}
			*/
			util.close();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
