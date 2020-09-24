package com.test.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;

public class ReservationDummy {
	public static void main(String[] args) {

		String state[] = { "완료" }; // 환불은 나중에
		File file = new File("D:\\프로젝트3\\예매.txt");
		// 8월 16일 ~ 8월 29일
		// 매수는 0~10개 정도로 하고
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		DBUtil util = new DBUtil();
		Connection conn = null;
		Statement stat = null;
		c.set(2020, 7, 19);
		c1.set(2020, 7, 19);
	

		int cnt = 0;
		int sum = 0;
//		int i = 0;
		String sql = null;

		String line = null;
		try {
			conn = util.open("yoginolja.ccyezlxmksh2.ap-northeast-2.rds.amazonaws.com","Atticket","java1234");
			stat = conn.createStatement();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			while (c.get(Calendar.DATE) != 27) {
				int seat1 = (int) (Math.random() * 200) + 300;
				int seat2 = (int) (Math.random() * 50) + 50;
				c1.set(Calendar.MONTH, c.get(Calendar.MONTH));
				c1.set(Calendar.DATE, c.get(Calendar.DATE));
				c1.add(Calendar.DATE, 7);
				for (int j = 0; j < 3; j++) {
					for (int i = 0; i < 240; i++) {
						while (sum < seat1) {
							cnt = (int) (Math.random() * 3) + 1;
							sum += cnt;
							sql = String.format(
									"insert into tblBooking values(bookingSeq.nextVal,to_date('%tF','yyyy-mm-dd'),to_date('%tF','yyyy-mm-dd'),'%s',%d,%d,default)",
									c, c1, state[(int) (Math.random() * state.length)], cnt, i + 1);
//					System.out.println(sql);
							stat.executeUpdate(sql);
//							writer.write(sql);
//							writer.newLine();
						}
						sum = 0;
					}
					sum=0;
					for (int i = 241; i < 300; i++) {
						while (sum < seat2) {
//							System.out.println(1);
							cnt = (int) (Math.random() * 3) + 1;
							sum += cnt;
							sql = String.format(
									"insert into tblBooking values(bookingSeq.nextVal,to_date('%tF','yyyy-mm-dd'),to_date('%tF','yyyy-mm-dd'),'%s',%d,%d,default)",
									c, c1, state[(int) (Math.random() * state.length)], cnt, i + 1);
//					System.out.println(sql);
							stat.executeUpdate(sql);
//							writer.write(sql);
//							writer.newLine();
						}
						sum = 0;
					}
				}
				
				c.add(Calendar.DATE, 1);
			}
//			writer.close();
			stat.close();
			conn.close();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("완료");
//		System.out.println(date.toString());

	}

}
