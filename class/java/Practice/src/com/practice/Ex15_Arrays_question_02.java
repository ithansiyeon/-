package com.practice;

import java.util.Scanner;

public class Ex15_Arrays_question_02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[5];
		for(int i=0;i<5;i++) {
		System.out.print("숫자 : ");
			nums[i]=scan.nextInt();
		}
		print(nums);
	}

	private static void print(int[] nums) {
		for(int i=4;i>=0;i--) {
			System.out.printf("nums[%d] = %d\n",i,nums[i]);
		}
		
	}

}