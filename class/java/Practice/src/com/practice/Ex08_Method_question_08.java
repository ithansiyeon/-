package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_08 {
	public static void main(String[] args) throws Exception {
		System.out.printf("총 소요 시간은 %d분입니다.",getTime(10,3));
		
	}
	
	public static int getTime(int count,int transfer) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("근무 시간대:");
		String time = reader.readLine();
		return time.equals("평상") ? count*2+transfer*3 : time.equals("출근") ? count*2+transfer*4:count*2+transfer*5;
	}

}
