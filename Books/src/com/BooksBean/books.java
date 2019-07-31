package com.BooksBean;

import java.util.Date;

public class books {
	//设置参数
	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private Integer price;
	
	
	public books(Integer bookId, String bookName, String bookAuthor,
			Integer price, Integer amount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.price = price;
		this.amount = amount;
	}
	
	public String toString(){
		return "Student [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", price=" + price
				+ ", amount=" + amount +  "]";
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	Integer amount;
}
