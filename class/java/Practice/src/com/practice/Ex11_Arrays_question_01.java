package com.practice;

import java.util.Arrays;

public class Ex11_Arrays_question_01 {
	public static void main(String[] args) {
		
		int[] list = new int[4];
		list[0]=10;
		list[1]=20;
		list[2]=30;
		list[3]=40;
		
		String result = dump(list);
		System.out.printf("nums = %s\n",result);
		
		
		
		
	}
/*
	private static String dump(int[] list) {
		
		return Arrays.toString(list);
	}
*/

	private static String dump(int[] list) {
		String result="[";
		for(int i=0;i<list.length;i++) {
			result+=list[i]+",";
		}
		result+="\b ]";
		return result;
	}
	
}
