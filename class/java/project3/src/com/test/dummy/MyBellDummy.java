package com.test.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyBellDummy {
	public static void main(String[] args) {
		
		File file = new File("D:\\프로젝트3\\알람.txt");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for(int i=0;i<1000;i++) {
				String sql = String.format("insert into tblmybell values(mybellseq.nextVal,%d,%d);",(int)(Math.random()*100)+1,i+1);
				writer.write(sql);
				writer.newLine();
				}
				writer.close();
				System.out.println("완료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
