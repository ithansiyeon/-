package com.practice;

public class Ex14_String_question_06 {
	public static void main(String[] args) {
		String text = "     하나    둘   셋  ";
		String trimtext = text.replace(" ","");
		int Lcnt=0,Rcnt=0;
		String result=" ";
		System.out.printf("원본 문자열 : [%s]\n",text);
		int i=0;
		while(text.charAt(i)==' ') { //while문이 헷갈렸어 공백을 만나면 while문이 나가는 걸로
			Lcnt++;
			i++;
		}
		int j=text.length()-1;
		while(text.charAt(j)==' ') {
			Rcnt++;
			j--;
		}
		
		for(int k=0;k<Lcnt;k++) {
			trimtext=" "+trimtext;
		}
		
		for(int l=0;l<Rcnt;l++) {
			trimtext=trimtext+" ";
		}
		System.out.printf("결과 문자열 : [%s]\n",trimtext);
	}

}
