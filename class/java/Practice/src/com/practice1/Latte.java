package com.practice1;

public class Latte {
	private int bean;
	private int milk;

	public void drink() {
		System.out.printf("원두 %d, 우유 %dml으로 만들어진 라떼를 마십니다.\n",this.bean,this.milk);
	}

	public int getBean() {
		return bean;
	}

	public void setBean(int bean) {
		this.bean = bean;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}
}
