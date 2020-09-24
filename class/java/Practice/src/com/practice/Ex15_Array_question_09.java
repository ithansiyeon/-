package com.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex15_Array_question_09 {
	public static void main(String[] args) {
		int start = 5;
		Random rnd = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제 위치 : ");
		int del = scan.nextInt();
		int[] list = new int[start];
		
		for(int i=0;i<list.length;i++) {
			list[i]=rnd.nextInt(10);
		}
		System.out.print("원본 : ");
		System.out.println(Arrays.toString(list));
		
		for(int i=del;i<list.length-1;i++) {
			list[i]=list[i+1];
			
		}
		list[list.length-1]=0;
		
		System.out.print("결과 : ");
		System.out.println(Arrays.toString(list));
	}

}
