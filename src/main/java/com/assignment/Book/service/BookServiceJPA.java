package com.assignment.Book.service;

import java.util.List;

import com.assignment.Book.entity.Book;

public interface BookServiceJPA {

public List<Book> findAll();
	
	public Book findById(int theId);
	
	public Book save(Book theBook);
	
	public Object deleteById(int theId);
}
