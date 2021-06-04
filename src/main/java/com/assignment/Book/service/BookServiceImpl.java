package com.assignment.Book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.Book.dao.BookDAO;
import com.assignment.Book.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;

	@Autowired
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO=bookDAO;
	}
	
	@Override
	@Transactional
	public List<Book> findAll() {
		
		return bookDAO.findAll();
	}

	@Override
	@Transactional
	public Book findById(int theId) {
		
		return bookDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Book theBook) {
		
		bookDAO.save(theBook);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		bookDAO.deleteById(theId);	}

}
