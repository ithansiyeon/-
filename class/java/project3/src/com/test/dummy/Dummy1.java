package com.test.dummy;

import java.util.Calendar;

public class Dummy1 {
	public static void main(String[] args) {
		String sql = "";
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 7);
		c.set(Calendar.DATE, 1);
		for(int i=0;i<30;i++) {
			c.add(Calendar.DATE, 2);
			sql = String.format("insert into tblBooking values(bookingSeq.nextVal,to_date('2020-08-%02d','yyyy-mm-dd'),to_date('%tF','yyyy-mm-dd'),'완료',1,%d,default);",
					i+1, c,(int)(Math.random()*100)+10,1);
			System.out.println(sql);
		}
		
	}
}
