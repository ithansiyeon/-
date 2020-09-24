package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_11 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int one=0,two=0,three=0;
		System.out.print("최대 숫자: ");
		int max = Integer.parseInt(reader.readLine());
		int count = 0;
		if(max<1000 && max>=1) {
			for(int i=1;i<=max;i++) {
			count=0;
			one = i%10;
			two = (i/10)% 10;	
			three =(i/100)% 10;
			
			if(one==3 || one ==6 || one==9) count++;
			if(two==3 || two==6|| two==9) count++;
			if(three==3 || three==6 || three==9) count++;
			if(count!=0) {
				for(int j=0;j<count;j++) {
					System.out.print("짝");
					}
			}
			else System.out.printf("%d",i);
			
			System.out.print(" ");
			}
				
		}
		else System.out.print("최대 3자리 숫자만 입력할 수 있습니다.");
		
		
		
		
	}

}
