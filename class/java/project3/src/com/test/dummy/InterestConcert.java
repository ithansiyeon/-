package com.test.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class InterestConcert {
	public static void main(String[] args) {
		File file = new File("D:\\프로젝트3\\관심공연.txt");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String line = null;
			for(int i=0;i<7000;i++) {
				line = String.format("insert into tblmyshow values(myShowSeq.nextVal, to_date('2020-08-%d','yyyy-mm-dd'),%d,%d,default);",(int)(Math.random()*31)+1,(int)(Math.random()*100)+1,i+1);
				writer.write(line);
				writer.newLine();
			}
			writer.close();
			System.out.println("완료");
			
		} catch (Exception e) {
			System.out.println("InterestConcert.main()");
			e.printStackTrace();
		}
	}
}
