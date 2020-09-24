package com.error2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_use_01 {
	
	public static void main(String[] args) throws Exception {
		
		m1();
		//m2();
		//m3();
		
	}

	private static void m3() throws Exception {
		
		//사용자가 짝수를 입력하면 누적, 홀수를 입력하면 중단하시오. 횟수는 무제한입니다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum=0;
		int i=0; // 값을 넣어주지 않아도 되지만 선언과 동시에 초기화를 하는게 좋음
		
		for (i=0;;i++) {
			
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 0) { //짝수를 입력하면 누적이므로 %2는 0이어야 한다.
				sum += num; //sum에 누적해야 되므로 +=
			} else {
				break;
			}
			
		}
		
		System.out.printf("%d회 입력 결과: %,d\n", i, sum);	//sum을 초기화 하지 않아서 오류 발생
		
	}

	private static void m2() {
		
		//1 ~ 10까지의 합을 구하시오.
		int sum=0;
		
		for (int i=1; i<=10; i++) {
			System.out.println(i);
			sum += i; // 1~10까지를 누적하므로 +=i임 
		}
		
		System.out.println(sum); //sum이 초기화 되지 않아서 오류가 발생
		
		
	}

	private static void m1() {
		
		//구구단 출력
		// - 9단을 출력합니다.
		
		int dan = 9;
		
		for (int i=1; i<=9; i++) { //for문의 조건식이 i<=9일때이다. 따라서 i가 증가하다가 9가 되면 종료되므로 출력이 되지 않았다.
			
			System.out.printf("%d x %d = %2d\n"
								, dan, i, dan * i);
			
		}
		
		
		
	}

}






