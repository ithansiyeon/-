package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_08 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("날짜 입력 : ");
		int day = Integer.parseInt(reader.readLine());
		System.out.printf("2020년 4월 20일은 '%s'입니다.",day % 7==1 ? "수요일": day % 7==2 ? "목요일":
				day % 7==3 ? "금요일":day % 7==4 ? "토요일":day % 7==5 ? "일요일":day % 7==6 ? "월요일":
					"화요일");
	}
}
