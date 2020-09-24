package com.practice1;

class Macaron {
    private int size;
    private String color;
    private int thickness;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size>=5 && size<=15)
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if(color.equals("red") || color.equals("blue") 
				|| color.equals("yellow") || color.equals("white")
				|| color.equals("pink") || color.equals("purple")
				|| color.equals("black") || color.equals("green"))
		this.color = color;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		if(thickness>=1 && thickness <=20)
		this.thickness = thickness;
	}
}