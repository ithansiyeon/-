package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_04 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("사용자가 페달을 밟은 횟수 : ");
		int pedal = Integer.parseInt(reader.readLine());
		System.out.print("기어비 : ");
		int gear = Integer.parseInt(reader.readLine());
		System.out.printf("사용자가 총 %,d회 페달을 밟아 자전거가 총 %,dm를 달렸습니다.",pedal,(int)(gear*pedal*26/100*Math.PI*2.54));
		
	}
}
