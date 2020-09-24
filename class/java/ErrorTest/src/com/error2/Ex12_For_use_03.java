package com.error2;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class Ex12_For_use_03 {
	
	public static void main(String[] args) throws Exception {
		
		m1();
		//m2();
		
	}

	private static void m2() throws Exception {

		//별찍기(행 입력)
		//*
		//**
		//***
		//****
		//*****
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행: ");
		
		int row = Integer.parseInt(reader.readLine()); //String을 형변환할려면 Integer.parseInt()를 써야 됨 
		
		for (int i=0; i<=row; i++) {
			for (int j=0; j<=i; j++) {
				System.out.print("*"); //*를 한줄로 찍어야 되므로 ln을 지움 
			}
			System.out.println();
		}
		
	}

	private static void m1() {
		
		//구구단
		//2단 ~ 9단
				
		for (int j=2; j<10; j++) {
		
			for (int i=1; i<10; i++) { //j++이 아니고 i이어야 한다. i==9가 되면 i는 1이어서 조건을 만족을 못시키므로
				// 출력이 안됨
				System.out.printf("%d x %d = %2d\n", j, i, j * i);
			}
			
			System.out.println();
			
		}
		
	}

}









