package com.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex15_Arrays_question_04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("배열의 길이 : ");
		int size = scan.nextInt();
		Random rnd = new Random();
		int[] nums = new int[size];
		int[] result = new int[size/2];
		for(int i=0;i<nums.length;i++) {
			nums[i]=(rnd.nextInt(9)+1);
			
		}
		int k=0;
		for(int j=0;j<size/2;j++) {
			result[j]=nums[k]+nums[k+1];
			k+=2;
		}
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(result));
		
	}

}
