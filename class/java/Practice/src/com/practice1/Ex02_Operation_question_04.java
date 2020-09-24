package com.practice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02_Operation_question_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("사용자가 페달을 밟은 횟수 : ");
		int padder = Integer.parseInt(reader.readLine());
		System.out.print("기어비: ");
		int gear = Integer.parseInt(reader.readLine());
		
		System.out.printf("사용자가 총 %,d회 페달을 밟아 자전거가 총 %,.0fm를 달렸습니다.",padder,26*2.54*3.14*padder*gear/100);
		
		
	}
}
