package com.practice;

public class Ex07_Operation_question_09 {
	public static void main(String[] args) throws Exception {
		System.out.print("영문자 입력 : ");
		int num = System.in.read();
		System.out.printf("입력한 문자 '%c'는 %s입니다.",num,num>= 'a' && num<= 'z'?"소문자":num>='A'&& num<='Z' ? "대문자" :"?");
	}
}
