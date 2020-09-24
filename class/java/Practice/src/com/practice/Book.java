package com.practice;

class Book {
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String pubYear = "2019";
	private String isbn;
	private int page;

	// getter, setter

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		boolean loop = true;
		for (int i = 0; i < title.length(); i++) {
			char c = title.charAt(i);
			if (title.length() > 50 && (c < '0' || c > '9')
					&& (c < 'a' || c > 'z')
					&& (c < 'A' || c > 'Z')
					&& (c < '가' || c > '힣')
					&& c!=' ') {
				loop = false;
			} 
		}
		if(loop) {
			this.title=title;
		}
		else {
			System.out.println("유효하지 않는 제목입니다.");
		}

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>0 && price<1000000)
		this.price = price;
		else System.out.println("유효하지 않는 가격입니다.");
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubYear() {
		return pubYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page>1)
		this.page = page;
		else {
			System.out.println("유효하지 않는 페이지입니다.");
		}
	}

	public String info() {
		String info="";
		info+=this.title+", "+this.author+", "+this.isbn+", "+this.page+", "+this.price+", "+this.publisher+", "+
		this.pubYear;
        return info;
    }
}