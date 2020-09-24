package com.test.dummy;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

/**
 * 
 * @author siyeon
 * 혼잡도 더미를 출력하는 클래스입니다.
 */
public class DummyCongestion {
	public static void main(String[] args) {
		DBUtil util = new DBUtil();
		String sql = null;
		Statement stat = null;
		Connection conn = null;
		Random rnd = new Random();
		
		try {
			conn = util.open("211.63.89.57","subway","java1234");
			stat = conn.createStatement();
			// 1호선 루트 
			// 호선(10개) 기차 갯수가 30개라서 총 300개 
			// 번호 | 인원수 | 기차위치 번호 | 칸 번호 
				for(int i=208;i<=268;i++) {
					for(int j=0;j<240;j++) {

						sql = String.format("insert into tblCongestion values(congestion_seq.nextVal,%d,%d,%d)",rnd.nextInt(10)+60,i,j+1);
//						System.out.println(sql);
						stat.executeUpdate(sql);
						
					}
				}
				System.out.println();
				// 3호선 루트 
				for(int i=269;i<=311;i++) {
					for(int j=0;j<240;j++) {
						
						sql = String.format("insert into tblCongestion values(congestion_seq.nextVal,%d,%d,%d)",rnd.nextInt(10)+60,i,481+j);
//						System.out.println(sql);
						stat.executeUpdate(sql);
						
					}
				}
				System.out.println();
				
				//5호선 루트 
				for(int i=312;i<=354;i++) {
					for(int j=0;j<240;j++) {
						sql = String.format("insert into tblCongestion values(congestion_seq.nextVal,%d,%d,%d)",rnd.nextInt(10)+60,i,1201+j);
//						System.out.println(sql);
						stat.executeUpdate(sql);
						
					}
				}
			
				System.out.println("완료");
//				stat.close();
//				conn.close();
		} catch (Exception e) {
			System.out.println("DummyCongestion.main()");
			e.printStackTrace();
		}
	}

}
