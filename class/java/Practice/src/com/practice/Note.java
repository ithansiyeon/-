package com.practice;

public class Note {
	private String size;
	private String color;
	private int page;
	private String owner;
	private int price;
	private String thickness;

	public void setSize(String size) {
		if (size.equals("A3") || size.equals("A4") || size.equals("A5") || size.equals("B3") || size.equals("B4")
				|| size.equals("B5")) {
			this.size = size;
			if (size.equals("A5"))
				this.price += 500;
			else if (size.equals("A3"))
				this.price += 900;
			else if (size.equals("A4"))
				this.price += 700;
			else if (size.equals("B3"))
				this.price += 1000;
			else if (size.equals("B4"))
				this.price += 800;
			else
				this.price = 600;
		} else
			System.out.println("유효하지 않는 크기입니다.");
	}

	public void setColor(String color) {
		if (color.equals("검정색") || color.equals("흰색") || color.equals("노란색") || color.equals("파란색")) {
			this.color = color;
			if (color.equals("검정색"))
				this.price += 100;
			else if (color.equals("노란색"))
				this.price += 200;
			else if (color.equals("파란색"))
				this.price += 200;
		} else
			System.out.println("유효하지 않는 색상입니다.");
	}

	public void setPage(int page) {
		if (page >= 10 && page <= 200) {
			this.page = page;
			if (page >= 10 && page <= 50) {
				thickness = "얇은";
			} else if (page >= 51 && page <= 100) {
				thickness = "보통";
			} else
				thickness = "두꺼운";
			this.price += (page - 10) * 10;
		} else
			System.out.println("유효하지 않는 페이지수입니다.");
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String info() {
		String info = "";
		if (this.owner != null) {
			info+="■■■■■■ 노트 정보 ■■■■■■\n";
			info+=String.format("소유자 : %s\n", this.owner);
			info+=String.format("특성 : %s %s %s노트\n", this.color,this.thickness,this.size);
			info+=String.format("가격 : %,d\n", this.price);
			info +="■■■■■■■■■■■■■■■■■■■■■■\n";
			return info;
		} else {
			info+="■■■■■■ 노트 정보 ■■■■■■\n";
			info += "주인 없는 노트\n■■■■■■■■■■■■■■■■■■■■■■\n";
			return info;
		}
	}
	
}
