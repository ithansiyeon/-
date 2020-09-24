package com.practice1;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0,0,0);
	}
	
	public Time(int hour,int minute,int second) {
		if(hour>=0 && minute >=0 && second >=0) {
			if(second>=60) {
				minute+=second/60;
				second%=60;
			}
			if(minute>=60) {
				hour+=minute/60;
				minute%=60;
			}
			this.hour=hour;
			this.minute=minute;
			this.second=second;
		}
	}
	public Time(int minute,int second) {
		this(0,minute,second);
	}
	public Time(int second) {
		this(0,0,second);
	}
	public String info() {
		String info="";
		info+=String.format("%d:%d:%d",this.hour,this.minute,this.second);
		return info;
	}
}
