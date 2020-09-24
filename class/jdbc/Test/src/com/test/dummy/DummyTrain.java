package com.test.dummy;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class DummyTrain {

	public static void main(String[] args) {
		DBUtil util = new DBUtil();
		String sql = null;
		Statement stat = null;
		Connection conn = null;
		Random rnd = new Random();
		try {
			conn = util.open("211.63.89.57","subway","java1234");
			stat = conn.createStatement();
			
			for (int i = 0; i < 356; i++) { // 호선(10개) 기차 갯수가 30개라서 총 300개 
					for (int j = 0; j < 8; j++) {	//칸 갯수 
						sql =String.format("Insert into tblTrainSeat values(trainSeat_seq.nextVal,%d,%d)",rnd.nextInt(15)+30,i+1);
//						System.out.println(sql);
						stat.executeUpdate(sql);
					}
				
			}
			System.out.println("완료");
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("DummyTrain.main()");
			e.printStackTrace();
		}
		
	}

}
