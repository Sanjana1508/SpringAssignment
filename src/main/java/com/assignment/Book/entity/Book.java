package com.assignment.Book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="number_of_pages")
	private int numberOfPages;
	
	@Column(name="price")
	private double price;
	
	@Column(name="author")
	private String author;
	
	public Book() {
		
	}

	public Book(int id, String bookName, int numberOfPages, double price, String author) {
		this.id = id;
		this.bookName = bookName;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
