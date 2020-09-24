package com.practice1;

public class Barista {

	
	public Espresso makeEspresso(int bean) {
		Espresso espresso = new Espresso();
		espresso.setBean(bean);
		Coffee.bean+=bean;
		Coffee.espresso+=1;
		Coffee.beanTotalPrice+=bean*Coffee.beanUnitPrice;
		return espresso;
	}
	
	public Espresso[] makeEspressoes(int bean,int count) {
		Espresso[] espresso = new Espresso[count];
		for(int i=0;i<count;i++) {
			espresso[i] = new Espresso();
			espresso[i].setBean(bean);
			Coffee.bean+=bean;
			Coffee.espresso+=1;
			Coffee.beanTotalPrice+=bean*Coffee.beanUnitPrice;
		}
		return espresso;
	}
	
	Latte makeLatte(int bean, int milk) {
		Latte latte = new Latte();
		latte.setBean(bean);
		latte.setMilk(milk);
		Coffee.bean+=bean;
		Coffee.milk+=milk;
		Coffee.latte+=1;
		Coffee.beanTotalPrice+=bean*Coffee.beanUnitPrice;
		Coffee.milkTotalPrice+=milk*Coffee.milkUnitPrice;
		return latte;
	}
	
	Latte[] makeLattes(int bean, int milk, int count) {
		Latte[] latte = new Latte[count];
				for(int i=0;i<count;i++) {
					latte[i] = new Latte();
					latte[i].setBean(bean);
					latte[i].setMilk(milk);
					Coffee.bean+=bean;
					Coffee.milk+=milk;
					Coffee.latte+=1;
					Coffee.beanTotalPrice+=bean*Coffee.beanUnitPrice;
					Coffee.milkTotalPrice+=milk*Coffee.milkUnitPrice;
				}
			return latte;
		}
	
	Americano makeAmericano(int bean, int water, int ice) {
		Americano americano = new Americano();
		americano.setBean(bean);
		americano.setWater(water);
		americano.setIce(ice);
		Coffee.americano+=1;
		Coffee.ice+=ice;
		Coffee.beanTotalPrice+=bean*Coffee.beanUnitPrice;
		Coffee.waterTotalPrice+=water*Coffee.waterUnitPrice;
		Coffee.iceTotalPrice+=ice*Coffee.iceUnitPrice;
		return americano; 
	}
	
	Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		Americano[] americano = new Americano[count];
		for(int i=0;i<count;i++) {
			americano[i] = new Americano();
			americano[i].setBean(bean);
			americano[i].setIce(ice);
			americano[i].setWater(water);
			Coffee.bean+=bean;
			Coffee.ice+=ice;
			Coffee.water+=water;
			Coffee.americano+=1;
			Coffee.beanTotalPrice+=bean*Coffee.beanUnitPrice;
			Coffee.waterTotalPrice+=water*Coffee.waterUnitPrice;
			Coffee.iceTotalPrice+=ice*Coffee.iceUnitPrice;
		}
		return americano;
	}
	void result() {
		System.out.println("============================");
		System.out.println("판매 결과");
		System.out.println("============================");
		System.out.println();
		
		System.out.println("----------------------------");
		System.out.println("음료 판매량");
		System.out.println("----------------------------");
		System.out.println();
		System.out.printf("에스프레소 : %d잔\n",Coffee.espresso);
		System.out.printf("아메리카노 : %d잔\n",Coffee.americano);
		System.out.printf("라떼 : %d잔\n",Coffee.latte);
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("원자재 소비량");
		System.out.println("----------------------------");
		System.out.println();
		System.out.printf("원두 : %,dg\n",Coffee.bean);
		System.out.printf("물 : %,dml\n",Coffee.water);
		System.out.printf("얼음 : %,d개\n",Coffee.ice);
		System.out.printf("우유 : %,dml\n",Coffee.milk);
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("매출액");
		System.out.println("----------------------------");
		System.out.printf("원두 : %,d원\n",Coffee.beanTotalPrice);
		System.out.printf("물 : %,d원\n",Coffee.waterTotalPrice);
		System.out.printf("얼음 : %,d원\n",Coffee.iceTotalPrice);
		System.out.printf("우유 : %,d원\n",Coffee.milkTotalPrice);
		
	}
}
