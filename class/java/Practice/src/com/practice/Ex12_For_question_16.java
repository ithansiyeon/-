package com.practice;



public class Ex12_For_question_16 {
	public static void main(String[] args) {
		
		int num = 1;
		int sum=0;
	
		for(int i=0;i<100;i++) {
			num+=i;
			sum+=num;
			System.out.printf("%d + ",num); 
			if(sum==469) break;
			
	}
		System.out.printf("\b\b = %d",sum);
	}
}
