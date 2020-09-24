package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_10 {
	public static void main(String[] args) throws Exception {
		m1();
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("근무 년수:");
		int year = Integer.parseInt(reader.readLine());
		if(year>=1) {
		if(year>=1 && year <=4) {
			System.out.printf("%d년차 초급 개발자입니다.\n",year);
			System.out.printf("앞으로 %d년 더 근무하면 중급개발자가 됩니다.\n",5-year);
		}
		else if(year>=5 && year<= 9) {
			System.out.printf("%d년차 중급 개발자입니다.\n",year);
			System.out.printf("%d년 전에는 초급개발자였습니다.\n",year-4);
			System.out.printf("앞으로 %d년 더 근무하면 고급개발자가 됩니다.\n",10-year);
			
		}
		else {
			System.out.printf("%d년차 고급 개발자입니다.\n",year);
			System.out.printf("%d년 전에는 중급개발자였습니다.\n",year-9);
		}
		}
		
		else System.out.println("개발자가 아니거나 근무년수를 잘못입력했습니다.");
			
	}
}
