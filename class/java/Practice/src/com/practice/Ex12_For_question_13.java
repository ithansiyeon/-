package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_13 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.");
		int cnum =(int)(Math.random()*10)+1;
		boolean loop = true;
		int count=0;
		for(;loop;) {
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			if(num==cnum) {
				System.out.println("맞췄습니다.");
				count++;
				loop=false;
			}
			else {System.out.println("틀렸습니다.");
			count++;
			}
			
		}
		System.out.println();
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n",cnum);
		System.out.printf("정답을 맞추는데 시도한 회수는 %d회입니다.\n",count);
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
		
		
		
		
	}

}
