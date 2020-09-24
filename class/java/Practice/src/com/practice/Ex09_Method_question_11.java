package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex09_Method_question_11 {
	public static void main(String[] args) {
	position("홍길동");
	System.out.println();
	position("홍길동","유재석");
	System.out.println();
	position("홍길동","유재석","정형돈");
	System.out.println();
	position("홍길동","유재석","정형돈","정준하");
		
	}
	
	public static void position(String name1){ 
		System.out.printf("사원 : %s\n",name1);
		
	}
	
	public static void position(String name1,String name2){ 
		System.out.printf("사원 : %s\n",name1);
		System.out.printf("대리 : %s\n",name1,name2);
		
	}
	
	public static void position(String name1,String name2,String name3){ 
		System.out.printf("사원 : %s\n",name1);
		System.out.printf("대리 : %s\n",name1,name2);
		System.out.printf("과장 : %s\n",name1,name2,name3);
		
	}
	
	public static void position(String name1,String name2,String name3,String name4){ 
		System.out.printf("사원 : %s\n",name1);
		System.out.printf("대리 : %s\n",name1,name2);
		System.out.printf("과장 : %s\n",name1,name2,name3);
		System.out.printf("부장 : %s\n",name1,name2,name3,name4);
		
	}
	
}
