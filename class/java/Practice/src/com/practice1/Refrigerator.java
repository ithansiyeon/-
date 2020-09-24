package com.practice1;

public class Refrigerator {
	Item[] item = new Item[100];
	private int cnt=0;
	public void add(Item item) {
		this.item[cnt]=new Item();
		this.item[cnt]=item;
		cnt++;
		}
	
	public Item get(String name) {
		int k=0;
		for(int i=0;i<cnt;i++) {
			if(item[i].getName().equals(name)) {
				k=i;
				Item p = item[k];
				for(int j=k;j<cnt-1;j++) {
					item[j]=item[j+1];
				}
				item[cnt-1]=null;
				cnt--;
				return p;
			}
		}
		return null;
	}
	
	public int count() {
		int count=0;
		for(int i=0;i<cnt;i++) {
			count+=1;
		}
		return count;
	}
	
	public void listItem() {
		System.out.println("[냉장고 아이템 목록]");
		for(int i=0;i<cnt;i++) {
			System.out.printf("%s(%s)\n",item[i].getName(),item[i].getExpiration());
		}
	}

}
