package com.test.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class Practice {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int month = 6;
		int day = 1;
		String sql = null;
		boolean loop = true;
		File file = new File("D:\\프로젝트3\\회차더미.txt");
	
		String starttime[] = {"13:00","17:00","21:00"};
		String endtime[] = {"15:30","19:30","23:30"};
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for (int i = 0; i < 100; i++) {
			
//					for (int j = 0; j < 3; j++) {
					
						String date = String.format("%tF %tT", c,c);
						sql = String.format(
								"insert into tblRoundInfo values(roundInfoSeq.nextVal,'%s','%s',%d,default);",
								starttime[1],endtime[1],i + 1);
						writer.write(sql);
						writer.newLine();

//					}

			}
			writer.close();
		
		} catch (Exception e) {
			System.out.println("RoundInfoDummy.main()");
			e.printStackTrace();
		}
		System.out.println("완료");
	}
}
