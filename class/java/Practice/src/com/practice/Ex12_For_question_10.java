package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_10 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int year=1;
		int month=1;
		int date=0;
		
		for(year=1;year<=2019;year++) {
		date+=365;
		 if(year%4!=0) {
				// "평년"
			}
			else if(year%100!=0) {
				// "윤년"
				date+=1;
			}
			else if(year%400!=0) {
				//"평년"
			}
			else {
				// "윤년"
				date+=1;
			}
		}
		
		for(month=1;month<=3;month++) {
		switch(month) {
		case 2:
			 if(year%4!=0) {
					// "평년"
				 	date+=28;
				}
				else if(year%100!=0) {
					// "윤년"
					date+=29;
				}
				else if(year%400!=0) {
					//"평년"
					date+=28;
				}
				else {
					// "윤년"
					date+=29;
				}
		break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			date+=31;
		break;
		case 4:
		case 6:
		case 9:
		case 11:
			date+=30;
			}
		}
		date+=17;
		System.out.printf("2020년 4월 17일은 %,d일째 되는 날입니다.\n",date);
		System.out.println(date%7);
		
		
		
		
		
	}

}
