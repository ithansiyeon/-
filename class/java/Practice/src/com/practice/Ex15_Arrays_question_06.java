package com.practice;

import java.util.Random;
import java.util.Scanner;

public class Ex15_Arrays_question_06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] list = new int[20];
		int[] result = new int[list.length];
		Random rnd = new Random();
		System.out.print("원본 : ");
		
		for(int i=0;i<list.length;i++) {
			list[i]=rnd.nextInt(19)+1;
			System.out.printf("%d,",list[i]);
		}
		System.out.println();
		System.out.print("최대 범위 : ");
		int max=scan.nextInt();
		System.out.print("최소 범위 : ");
		int min=scan.nextInt();
		int k=0;
		for(int i=0;i<list.length;i++) {
			if(list[i]>=min && list[i]<=max) {
				result[k]=list[i];
				k++;
			}
		}
		System.out.print("결과 : ");
		for(int j=0;j<k;j++) {
			System.out.printf("%d,",result[j]);
		}
		System.out.println();
		
		
		
		
	}

}
