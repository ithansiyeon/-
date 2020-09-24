package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_14 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean loop = true;
		for(;loop;) {
		System.out.println("=======================");
		System.out.println("         자판기        ");
		System.out.println("=======================");
		
		System.out.println("1. 콜라         : 700원");
		System.out.println("2. 사이다       : 600원");
		System.out.println("3. 비타500      : 500원");
		
		System.out.println("-----------------------");
		System.out.print("금액 투입(원) :");
		int money = Integer.parseInt(reader.readLine());
		System.out.println("-----------------------");
		System.out.print("음료 선택(번호) :");
		int num = Integer.parseInt(reader.readLine());
		if(num==4) break;
		serve(num,money);
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void serve(int num, int money) throws Exception {
		switch(num) {
			case 1:
				System.out.println("+콜라를 제공합니다.");
				System.out.printf("+잔돈 %,d원을 제공합니다.\n",money-700);
				break;
			case 2:
				System.out.println("+사이다를 제공합니다.");
				System.out.printf("+잔돈 %,d원을 제공합니다.\n",money-600);
				break;
			case 3:
				System.out.println("+비타500를 제공합니다.");
				System.out.printf("+잔돈 %,d원을 제공합니다.\n",money-500);
				break;
			default: 
				System.out.println("판매 불가능합니다.");
		}
		pause();
			
		}

	private static void pause() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("계속하시려면 엔터를 누르세요.");
		reader.read();
		
	}
		
	}


