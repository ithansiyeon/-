package com.practice;

public class Ex14_String_question_08 {
	public static void main(String[] args) {
		String content = "안녕~길동아~ 잘가 ";
		String word = "길동";

		int index = -1;
		int count=0;
		index = -content.length();
		while(true) {
			index=content.indexOf(word,index+word.length());
			if(index>-1) {
				count+=1;
			}
			else {
				break;
			}
		}
		
		System.out.printf("'길동'을 총 %d회 발견했습니다.\n",count);

		
		
		
	}

}
