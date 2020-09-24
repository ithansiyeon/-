package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question02_11 {
	public static void main(String[] args) throws Exception {
		int money = 10000; //지역변수에는 static 사용불가
		boolean loop = true;
		for(;loop;)	{
		System.out.println("===========================");
		System.out.println("My Bank ");
		System.out.println("===========================");
		System.out.println("1. 계좌 입금");
		System.out.println("2. 계좌 출금");
		System.out.println("3. 잔액 조회");
		System.out.println("4. 종료");
		System.out.println("===========================");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("선택(번호) : ");
		int num= Integer.parseInt(reader.readLine());
		if(num==1) {
		System.out.print("계좌 비밀번호 : ");
		String password = reader.readLine();
		if(password.equals("1234"))
				{
				System.out.print("입금액 : ");
				int amount = Integer.parseInt(reader.readLine());
				deposit(money,amount);
				pause();
				}
		}
		if(num==2) {
			System.out.print("계좌 비밀번호 : ");
			String password = reader.readLine();
			if(password.equals("1234"))
			{
			System.out.print("출금액 : ");
			int amount = Integer.parseInt(reader.readLine());
			money=withdraw(money,amount);
			pause();
			}	
		}
		if(num==3) {
			check(money);
			pause();
		}
		if(num==4) {
			loop = false;
		}
			}
		
		
		}
		
		
		

	private static void pause() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("계속하시려면 엔터를 누르세요.");
		reader.readLine();
		}
	
	private static int deposit(int money, int amount) {
		money+=amount;
		System.out.printf("%,d원이 입급되었습니다.\n",amount);
		return money;
	}
	
	private static int withdraw(int money,int amount) {
		money-=amount;
		System.out.printf("%,d원이 출금되었습니다.\n",amount);
		return money;
	}
	
	private static void check(int money) {
		System.out.printf("현재 잔액: %,d원\n",money);
	}
	
	
}

