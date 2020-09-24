package com.practice1;

import java.util.Calendar;

class Bugles {
    private int price;
    private int weight;
    private Calendar creationTime;
    private int expiration;

    //getter, setter 구현

    public void eat() {
    	if(getExpiration()<0) {
    		System.out.println("유통기한이 지나 먹을 수 없습니다.\n");
    	}
    	else {
    		System.out.println("과자를 맛있게 먹습니다.\n");
    	}

    }

	public int getPrice() {
		return price;
	}


	public void setWeight(int weight) {
		if(weight==300) {
			this.expiration=7;
			this.price+=850;
			this.weight=weight;
		}
		else if(weight==500) {
			this.expiration=10;
			this.weight = weight;
			this.price+=1200;
		}
		else if(weight==850) {
			this.expiration=15;
			this.weight=weight;
			this.price+=1950;
		}
	}


	public void setCreationTime(String creationTime) {
		Calendar k = Calendar.getInstance();
		int year = Integer.parseInt(creationTime.substring(0,4));
		int month = Integer.parseInt(creationTime.substring(5,7));
		int date = Integer.parseInt(creationTime.substring(8,10));
		k.set(year,month-1,date);
		
		this.creationTime = k;
	}

	public int getExpiration() {
		Calendar now = Calendar.getInstance();
		return this.expiration-(int)((now.getTimeInMillis()-this.creationTime.getTimeInMillis())/1000/60/60/24);
	}

}