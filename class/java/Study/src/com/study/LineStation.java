package com.study;

import java.sql.Connection;

import java.sql.Statement;
import java.util.Random;

import com.study.DBUtil;


public class LineStation {
	public static void main(String[] args) {
		// 환승구간 random
//		insert into tblLineStation values(LineStation_seq.nextVal,랜덤,랜덤,1,-1,7,709); // 장암
//		insert into tblLineStation values(LineStation_seq.nextVal,랜덤,랜덤,2,-1,7,710); // 도봉산
//		insert into tblLineStation values(LineStation_seq.nextVal,랜덤,랜덤,4,-1,7,711); // 수락산
//		insert into tblLineStation values(LineStation_seq.nextVal,랜덤,랜덤,5,-1,7,712); // 마들
//		insert into tblLineStation values(LineStation_seq.nextVal,랜덤,랜덤,6,-1,7,711); // 노원	
		Statement stat = null;
		Connection conn = null;
		DBUtil util = new DBUtil();
		//util.open("121.143.237.8","subway","java1234");
		Random rnd = new Random();
		//a. 문위치
		String[] door = {"왼쪽","오른쪽"};
		
		//b. 환승구간
		String[] trans = {"1-1","1-2","1-3","1-4","1-5","1-6","1-7","1-8","1-9"
						  ,"2-1","2-2","2-3","2-4","2-5","2-6","2-7","2-8","2-9"
						  ,"3-1","3-2","3-3","3-4","3-5","3-6","3-7","3-8","3-9"
						  ,"4-1","4-2","4-3","4-4","4-5","4-6","4-7","4-8","4-9"
						  ,"5-1","5-2","5-3","5-4","5-5","5-6","5-7","5-8","5-9"};
		
		int j=1;
		int k = 709;
		
		try {
			
			//stat=conn.createStatement();
			
			//7호선 
			System.out.println("7호선 장암행");
			for(int i=0;i<51;i++) {                                          //시퀀스, 문위치 , 역 순서 , 호선 번호, 역 번호, 환승 구간 
				String sql = String.format("insert into tblLineStation values(LineStation_seq.nextVal,'%s',%d,%d,109,'%s');\r\n",door[rnd.nextInt(door.length)],j,k,trans[rnd.nextInt(trans.length)]);
				j++;
				k++;
//				stat.executeQuery(sql);
				System.out.println(sql);
			
			}
			j=1;
			k=709;
			System.out.println("7호선 부평구청행");
			for(int i=0;i<51;i++) {                                          //시퀀스, 문위치 , 역 순서 , 호선 번호, 역 번호, 환승 구간 
				String sql = String.format("insert into tblLineStation values(LineStation_seq.nextVal,'%s',%d,%d,110,'%s');\r\n",door[rnd.nextInt(door.length)],j,k,trans[rnd.nextInt(trans.length)]);
				j++;
				k++;
//				stat.executeQuery(sql);
				System.out.println(sql);
			
			}
			System.out.println();
			System.out.println("9호선 개화행 115");
			//9호선
			j=1;
			k=901;
			for(int i=0;i<38;i++) {                                        
				String sql = String.format("insert into tblLineStation values(LineStation_seq.nextVal,'%s',%d,%d,115,'%s');\r\n",door[rnd.nextInt(door.length)],j,k,trans[rnd.nextInt(trans.length)]);
				j++;
				k++;
//				stat.executeQuery(sql);
				System.out.println(sql);
			
			}
			System.out.println("9호선 중앙 116");
			j=1;
			k=901;
			for(int i=0;i<38;i++) {                                        
				String sql = String.format("insert into tblLineStation values(LineStation_seq.nextVal,'%s',%d,%d,115,'%s');\r\n",door[rnd.nextInt(door.length)],j,k,trans[rnd.nextInt(trans.length)]);
				j++;
				k++;
//				stat.executeQuery(sql);
				System.out.println(sql);
			
			}
			//9호선 급행
			System.out.println("9호선 급행 개화행 115");
			j=1;
			k=901;
			for(int i=0;i<38;i++) {                                         //시퀀스, 문위치 , 역 순서 , 호선 번호, 역 번호, 환승 구간 
				String sql = String.format("insert into tblLineStation values(LineStation_seq.nextVal,'%s',%d,%d,115,'%s');\r\n",door[rnd.nextInt(door.length)],j,k,trans[rnd.nextInt(trans.length)]);
				j++;
				k+=4;
//				stat.executeQuery(sql);
				System.out.println(sql);
			
			}
			System.out.println("9호선 급행 중앙 116");
			j=1;
			k=901;
			for(int i=0;i<38;i++) {                                         //시퀀스, 문위치 , 역 순서 , 호선 번호, 역 번호, 환승 구간 
				String sql = String.format("insert into tblLineStation values(LineStation_seq.nextVal,'%s',%d,%d,116,'%s');\r\n",door[rnd.nextInt(door.length)],j,k,trans[rnd.nextInt(trans.length)]);
				j++;
				k+=4;
//				stat.executeQuery(sql);
				System.out.println(sql);
			
			}
			//stat.close();
			//conn.close();
			
		} catch (Exception e) {
			System.out.println("LineStation.main()");
			e.printStackTrace();
		}
		

	}

}
