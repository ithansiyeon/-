package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_06 {
	public static void main(String[] args) throws Exception {
		m1();
		m2();
	}

	private static void m2() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("음식을 받기 원하는 시각");
		System.out.print("시 : ");
		int hour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int min = Integer.parseInt(reader.readLine());
		//짜장면
		min += hour*60;
		hour = 0;
		
		min = min-10;
		hour = min/60;
		min = min % 60;
		System.out.printf("짜장면: %d시 %d분\n",hour,min);
		//치킨
		min += hour*60;
		hour = 0;
		
		min = min-8;
		hour = min/60;
		min = min % 60;
		System.out.printf("치킨 : %d시 %d분\n",hour,min);
		//피자
		min += hour*60;
		hour = 0;
		
		min = min-10;
		hour = min/60;
		min = min % 60;
		System.out.printf("피자 : %d시 %d분\n",hour,min);
		
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("음식을 받기 원하는 시각");
		System.out.print("시 : ");
		int hour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int min = Integer.parseInt(reader.readLine());
		
		Calendar date = Calendar.getInstance();
		
		date.set(Calendar.HOUR_OF_DAY, hour);
		date.set(Calendar.MINUTE, min);
		date.add(Calendar.MINUTE, -10);
		System.out.printf("짜장면 : %d시 %d분\n",date.get(Calendar.HOUR_OF_DAY),date.get(Calendar.MINUTE));
		date.add(Calendar.MINUTE, -8);
		System.out.printf("치킨 : %d시 %d분\n",date.get(Calendar.HOUR_OF_DAY),date.get(Calendar.MINUTE));
		date.add(Calendar.MINUTE, -7);
		System.out.printf("피자 : %d시 %d분\n",date.get(Calendar.HOUR_OF_DAY),date.get(Calendar.MINUTE));
		
		

		
	}

}
