package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_06 {
	public static void main(String[] args) throws Exception {
		m1();
	}

	private static void m1() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력: ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력: ");
		int n2 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력: ");
		int n3 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력: ");
		int n4 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력: ");
		int n5 = Integer.parseInt(reader.readLine());
		
		int evencount=0,oddcount=0,diff=0;
		
		if(n1%2==0)
			evencount+=1;
		else 
			oddcount+=1;
		
		if(n2%2==0)
			evencount+=1;
		else 
			oddcount+=1;
		
		if(n3%2==0)
			evencount+=1;
		else 
			oddcount+=1;
		
		if(n4%2==0)
			evencount+=1;
		else 
			oddcount+=1;
		
		if(n5%2==0)
			evencount+=1;
		else 
			oddcount+=1;
		if(evencount>oddcount) 
			diff= evencount-oddcount;
		else diff = oddcount-evencount;
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n",evencount,oddcount);
		System.out.printf("%s가 %s보다 %d개 더 많습니다.",evencount>oddcount?"짝수":"홀수",
				evencount>oddcount?"홀수":"짝수",diff);
		
	}
}
