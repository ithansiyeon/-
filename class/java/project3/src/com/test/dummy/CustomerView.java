package com.test.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CustomerView {

	public static void main(String[] args) {
		
		File file = new File("D:\\프로젝트3\\고객방문.txt");
		
		try {	
			
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for(int i=0;i<7000;i++) {
					String line = String.format("update tblcustomer set cview = %d where seq = %d;", (int)(Math.random()*100)+50,i+1);
					writer.write(line);
					writer.newLine();
				}
				writer.close();
				System.out.println("완료");
		} catch (Exception e) {
			System.out.println("CustomerView.main()");
			e.printStackTrace();
		}
		
	}

}
