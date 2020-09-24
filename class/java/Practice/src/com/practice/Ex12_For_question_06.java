package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_06 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		System.out.print("끝 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		int sum=0;
		for(int i=start,place=1;i<=end;i++,place++) {
			if(place%2==0) {
				sum-=i;
				System.out.printf("%d+",i); }
			else { sum+=i;
				System.out.printf("%d-",i);
				}
			}
			System.out.printf("\b=%d",sum);
		}
	
	}
	


