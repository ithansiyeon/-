package com.practice;

import java.util.Arrays;
import java.util.Random;

public class Ex15_Arrays_question_05 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int[] list = new int[20];
		
		System.out.print("원본 : ");
		for(int i=0;i<list.length;i++) {
			list[i]=rnd.nextInt(19)+1;
		}
		int max=list[0];
		int min=list[0];
		System.out.println(Arrays.toString(list));
		for(int i=0;i<list.length;i++) {
			if(max<list[i]) {
				max=list[i];
			}
			if(min>list[i]) {
				min=list[i];
			}
			
		}
		System.out.printf("최댓값 : %d\n",max);
		System.out.printf("최소값 : %d\n",min);
		
		
		
	}

}
