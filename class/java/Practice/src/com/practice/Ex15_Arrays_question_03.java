package com.practice;

import java.util.Scanner;

public class Ex15_Arrays_question_03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수 : ");
		int num = scan.nextInt();
		//scan.skip("\r\n");
		scan.nextLine();
		String[] list = new String[num];
		for(int i=0;i<num;i++) {
			System.out.print("학생명 : ");
			list[i]=scan.nextLine();
		}
		print(num,list);
		
	}

	private static void print(int num,String[] list) {
		System.out.printf("입력한 학생은 총 %d명입니다.\n",num);
		for(int i=num-1;i>=0;i--) {
			System.out.printf("%d. %s\n",i+1,list[i]);
		}
		
		
	}

}
