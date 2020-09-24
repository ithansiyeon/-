package com.practice1;

public class Packer {
	private static int pencilCount;
	private static int eraserCount;
	private static int ballPointPenCount;
	private static int rulerCount;
	
	public void packing(Pencil pencil) {
		String c=pencil.getHardness();
		System.out.printf("포장 전 검수 : %s 진하기 연필입니다.\n",c);
		if(c.equals("4B")|| c.equals("3B")
				|| c.equals("2B")
				|| c.equals("B")
				|| c.equals("HB")
				|| c.equals("H")
				|| c.equals("2H")
				|| c.equals("3H")
				|| c.equals("4H")) {
			System.out.println("포장을 완료했습니다.");
			this.pencilCount+=1;
		}
		else {
			System.out.println("잘못된 진하기 연필입니다.");
		}
	}
	public void packing(Eraser eraser) {
		String c = eraser.getSize();
		System.out.printf("포장 전 검수 : %s 사이즈 지우개입니다.\n",c);
		if(c.equals("Large") || c.equals("Medium") 
				|| c.equals("Small")){
			System.out.println("포장을 완료했습니다.");
			this.eraserCount+=1;
		}
		else {
			System.out.println("잘못된 사이즈 지우개입니다.");
		}
				
		
	}
	
	public void packing(BallPointPen ballPointPen) {
		double thick = ballPointPen.getThickness();
		String color = ballPointPen.getColor();
		System.out.printf("포장 전 검수 : %s 색상 %.1fmm 볼펜입니다.\n",color,thick);
		if((thick == 0.3 || thick == 0.5 || thick == 0.7 || thick == 1 || thick == 1.5) && 
				(color.equals("red") || color.equals("blue") || color.equals("green") || color.equals("black"))){
			System.out.println("포장을 완료했습니다.");
			this.ballPointPenCount+=1;
		}
		else {
			if(!((thick == 0.3 || thick == 0.5 || thick == 0.7 || thick == 1 || thick == 1.5) && 
					(color.equals("red") || color.equals("blue") || color.equals("green") || color.equals("black")))) {
				System.out.println("두께와 색상이 잘못됐습니다.");
			}
			else if(!(thick == 0.3 || thick == 0.5 || thick == 0.7 || thick == 1 || thick == 1.5)) {
				System.out.println("두께가 잘못됐습니다.");
			}
			else {
				System.out.println("색상이 잘못됐습니다.");
			}
		}
		
	}
	
	public void packing(Ruler ruler) {
		int length = ruler.getLength();
		String c = ruler.getShape();
		System.out.printf("포장 전 검수 : %dcm %s입니다.\n",length,c);
		if((length == 30 || length == 50 || length == 100) && 
				(c.equals("줄자") || c.equals("운형자") || c.equals("삼각자"))) {
			System.out.println("포장을 완료했습니다.");
			this.rulerCount+=1;
		}
		else {
			if(!((length == 30 || length == 50 || length == 100) && 
				(c.equals("줄자") || c.equals("운형자") || c.equals("삼각자")))) {
				System.out.println("길이와 형태가 잘못됐습니다.");
			}
			else if(!(length == 30 || length == 50 || length == 100)) {
				System.out.println("길이가 잘못됐습니다.");
			}
			else System.out.println("모양이 잘못됐습니다.");
		}
		
	}
	
	public void countPacking(int type) {
		System.out.println();
		System.out.println("==================================");
		System.out.println("포장 결과");
		if(type==0) {
			System.out.printf("연필 %d회\n",this.pencilCount);
			System.out.printf("지우개 %d회\n",this.eraserCount);
			System.out.printf("볼펜 %d회\n",this.ballPointPenCount);
			System.out.printf("자 %d회\n",this.eraserCount);
		}
		else if(type==1) {
			System.out.printf("연필 %d회\n",this.pencilCount);
		}
		else if(type==2) {
			System.out.printf("지우개 %d회\n",this.eraserCount);
		}
		else if(type==3) {
			System.out.printf("볼펜 %d회\n",this.ballPointPenCount);
		}
		else if(type==4) {
			System.out.printf("자 %d회\n",this.eraserCount);
		}
		else System.out.println("숫자를 잘못입력했습니다.");
		
		System.out.println("==================================");
	}
}
