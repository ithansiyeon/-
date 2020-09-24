package com.practice1;

import java.util.Arrays;

public class MyArrayList {
	private String[] list; //중심 데이터
	private int index; // 현재 데이터를 넣은 방의 위치 
	
	// append 모드로 배열의 맨 끝에 요소 추가
	public void add(String s) {
		checkLength(); 
		list[this.index]=s;
		this.index++;
	}

	//배열의 길이가 두배가 되는 상황
	private void checkLength() {
		if(this.list.length<=this.index) {
			String[] temp = new String[list.length*2];
			for(int i=0;i<this.index;i++) {
				temp[i]=list[i];
			}
			list=temp;
		}
	}
	
	public String get(int index) {
		if(index>=0 && index <list.length) {
			return list[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int size() {
		return this.index;
	}

	public void set(int index, String value) {
		
		if(index>=0 && index<list.length) {
			list[index]=value;
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	public void remove(int index) {
		
		if(index>=0 && index<list.length) {
			for(int i=this.index-2;i>=index;i--) {
				list[i]=list[i+1];
			}
			this.index--;
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}

	public void add(int index, String value) {
		
		if(index>=0 && index<this.index) {
			checkLength();
			for(int i=index;i<this.index-1;i++) {
				list[i+1]=list[i];
			}
		}
		list[index]=value;
		this.index++;
		
	}

	public int indexOf(String value) {
		
		for(int i=0;i<this.index;i++) {
			if(list[i].equals(value)) {
				return i;
			}
		}
		return -1;
		
	}
	
	public int lastIndexOf(String value) {
		
		for(int i=this.index-1;i>=0;i--) {
			if(list[i].equals(value)) {
				return i;
			}
		}
		return -1;
		
	}
	
	public void clear() {
		this.index=0;
	}
	
	public boolean contains(String value) {
		
		for(int i=0;i<this.index;i++) {
			if(list[i].equals(value)) {
				return true;
			}
		}
		return false;
		
	}
	
	public void trimToSize() {
		String[] temp = new String[this.index]; 
		for(int i=0;i<this.index;i++) {
			temp[i]=list[i];
		}
		list=temp;
	}
	
	public boolean isEmpty() {
		if(this.index==0) {
			return true;
		} 
		return false;
	}
	
	public MyArrayList subList(int fromIndex, int toIndex) {
		MyArrayList sub = new MyArrayList();
		for(int i=fromIndex;i<toIndex;i++) {
			sub.add(get(i));
		}
		return sub;
	}
	
	public MyArrayList() {
		this(10);
	}
	
	public MyArrayList(int capacity) {
		list = new String[capacity];
	}

	@Override
	public String toString() {
		return String.format("길이:%d\n인덱스:%d\n배열:%s",list.length,this.index,Arrays.toString(list));
	}
}
