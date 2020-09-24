package com.test.project;

import java.util.Calendar;

public class practice {
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
	
		c.add(c.MONTH,1);
		System.out.printf("%tF\n",c);
	}

}
