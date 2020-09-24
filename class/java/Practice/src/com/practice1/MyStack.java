package com.practice1;

import java.util.Arrays;

//LIFO
public class MyStack {
	
	private String[] list;
	private int index; // 내부적인 방번호
	
	public MyStack() {
		this(10);
	}
	public MyStack(int capacity) {
		list = new String[capacity];
		this.index=0;
	}
	
	public void push(String value) {
		checkLength();
		list[this.index]=value;
		this.index++;
	}
	
	private void checkLength() {
		if(this.list.length<=this.index) {
			String[] temp = new String[list.length*2];
			for(int i=0;i<this.index;i++) {
				temp[i]=list[i];
			}
			list=temp;
		}
	}
	
	public String pop() {
		String temp = list[this.index-1];
		this.index--;
		return temp;
	}
	
	public int size() {
		return this.index;
	}
	
	public String peek() {
		
		return list[this.index-1];
		
	}
	
	public void clear() {
		this.index=0;
	}
	
	public void trimToSize() {
		String[] temp = new String[this.index];
		for(int i=0;i<this.index;i++) {
			temp[i]=list[i];
		}
		list = temp;
	
		}
	
	@Override
	public String toString() {
		return String.format("length:%d\nindex:%d\n배열:%s",list.length,this.index,Arrays.toString(list));
	}

}
