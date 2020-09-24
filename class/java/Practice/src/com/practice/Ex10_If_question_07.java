package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_07 {
	public static void main(String[] args) throws Exception  {
		m1();
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[들어온 시간]");
		System.out.print("시: ");
		int ihour = Integer.parseInt(reader.readLine());
		System.out.print("분: ");
		int imin = Integer.parseInt(reader.readLine());
		
		System.out.println("[나간 시간]");
		System.out.print("시: ");
		int ohour = Integer.parseInt(reader.readLine());
		System.out.print("분: ");
		int omin = Integer.parseInt(reader.readLine());
		
		imin+=ihour*60;
		int pay=0;
		omin+=ohour*60;
		
		if((omin-imin)>30)
			pay=(omin-imin-30)/10*2000;
		else pay=0;
		
		System.out.printf("주차 요금은 %,d원입니다.",pay);
		
	}
}
