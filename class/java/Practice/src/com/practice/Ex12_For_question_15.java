package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_15 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("9자리 숫자 입력: ");
		String snum =reader.readLine();
		int num = Integer.parseInt(snum);
		int evensum=0;
		int oddsum=0;
		boolean loop = false;
		if(snum.length()<=9) {
		for(int i=0;i<snum.length();i++) {
			int each = (num/(int)Math.pow(10,i))%10;
			if(each%2==0) evensum+=each;
			else oddsum+=each;
			}
		}
		else loop=true;
		
		
		if(loop) {
			System.out.println("9자리 숫자가 아니어서 프로그램이 종료되었습니다.");
		}
		else {
			System.out.printf("짝수의 합: %d\n",evensum);
			System.out.printf("짝수의 합: %d\n",oddsum);
		}
		
		
		
	}

}
