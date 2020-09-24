package com.practice1;

import java.util.Random;

class Box {
	private Macaron[] list = new Macaron[10];
	private String[] color = { "red", "blue", "white", "pick", "purple", "green", "black" };
	public void cook() {
		Random rnd = new Random();
		for (int i = 0; i < list.length; i++) {
			list[i] = new Macaron();
			list[i].setSize(rnd.nextInt(11) + 5);
			list[i].setColor(color[rnd.nextInt(color.length)]);
			list[i].setThickness(rnd.nextInt(20) + 1);
		}
	}

	public void check() {
		int pass=0,fail=0;
		for (int i = 0; i < list.length; i++) {
			if ((list[i].getSize() >= 8 && list[i].getSize() <= 14) && !list[i].getColor().equals("black")
					&& (list[i].getThickness() >= 3 && list[i].getThickness() <= 18)) {
				pass+=1;
			}
			else {
				fail+=1;
			}
		}
		System.out.printf("QC 합격 개수 : %d개\n",pass);
		System.out.printf("QC 불합격 개수 : %d개\n",fail);
	}

	public void list() {
		for (int i = 0; i < list.length; i++) {
			if ((list[i].getSize() >= 8 && list[i].getSize() <= 14) && !list[i].getColor().equals("black")
					&& (list[i].getThickness() >= 3 && list[i].getThickness() <= 18)) {
				System.out.printf("%d번 마카롱 : %dcm(%s,%dmm) : 합격\n", i + 1, list[i].getSize(), list[i].getColor(),
						list[i].getThickness());
			} else {
				System.out.printf("%d번 마카롱 : %dcm(%s,%dmm) : 불합격\n", i + 1, list[i].getSize(), list[i].getColor(),
						list[i].getThickness());
			}

		}
	}
}
