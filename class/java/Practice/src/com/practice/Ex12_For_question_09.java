package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_09 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("종료할 누적값 : ");
		int end = Integer.parseInt(reader.readLine());
		boolean loop = true;
		int sum =0;
		int place =1;
		String result = "";
		for(;loop;) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
				if(place%2==1) {
					sum+=num;
					result+=num+" - ";
				}
				else {
					sum-=num;
					result+=num+" + ";
				}
				
				if(sum>end)
					loop=false;
				place++;
			}
		
		
		
		System.out.printf("%s\b\b = %d",result,sum);
		
		
		
	}

}
