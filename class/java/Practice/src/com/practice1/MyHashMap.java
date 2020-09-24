package com.practice1;

import java.util.Arrays;

public class MyHashMap {
	private String[] list;
	private String[] valueList;
	private int index;

	public MyHashMap() {
		this(10);
	}

	public MyHashMap(int capacity) {
		list = new String[capacity];
		valueList = new String[capacity];

	}
//containKey를 쓸수도 있구나~!
	public void put(String key, String value) {
		boolean loop = true;
		checkLength();
		for (int i = 0; i < this.index; i++) {
			if (list[i].equals(key)) {
				valueList[i] = value;
				loop = false;
				break;
			}
		}
		if (loop) {
			list[this.index] = key;
			valueList[this.index] = value;
			this.index++;
		}
	}

	private void checkLength() {
		if(this.index>=list.length) {
			String[] temp = new String[list.length*2];
			String[] temp_v = new String[list.length*2];
			for(int i=0;i<this.index;i++) {
				temp[i]=list[i];
				temp_v[i] = valueList[i];
			}
			list=temp;
			valueList=temp_v;
		}
	}


	public String get(String key) {
		for(int i=0;i<this.index;i++) {
			if(list[i].equals(key)){
				return valueList[i];
			}
		}
		return null;
		
	}

	public int size() {
		return this.index;
		
	}

	public void remove(String key) {
		for(int i=0;i<this.index;i++) {
			if(list[i].equals(key)){
				for(int j=i;j<this.index-1;j++) {
					list[j]=list[j+1];
					valueList[j]=valueList[j+1];
				}
				this.index--;
			}
		}
	}

	public boolean containKey(String key) {
		for(int i=0;i<this.index;i++) {
			if(list[i].equals(key)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsValue(String value) {
		for(int i=0;i<this.index;i++) {
			if(valueList[i].equals(value)) {
				return true;
			}
		}
		return false;

	}

	public void clear() {
		this.index=0;
	}
	
	@Override
	public String toString() {
		return String.format("길이:%d\n인덱스:%d\nkey:%s\nvalue:%s\n",list.length,this.index,Arrays.toString(list),Arrays.toString(valueList));
	}
}
