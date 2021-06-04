package com.assignment.Book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.Book.dao.BookRepository;
import com.assignment.Book.entity.Book;

@Service
public class BookServiceJPAImpl implements BookServiceJPA {

	private BookRepository bookRepository;

	
	@Autowired
	public BookServiceJPAImpl(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	@Override
	@Transactional
	public List<Book> findAll() {
		
		return bookRepository.findAll();
	}

	@Override
	@Transactional
	public Book findById(int theId) {
		
		Optional<Book> result = bookRepository.findById(theId);
		Book theBook = null;
		if(result.isPresent()) {
			theBook= result.get();
		}
		else {
			throw new RuntimeException("Book id not found : "+theId);
		}
		return theBook;
	}

	@Override
	@Transactional
	public Book save(Book theBook) {
		
		return bookRepository.save(theBook);
	}

	@Override
	@Transactional
	public Object deleteById(int theId) {
		
		return deleteById(theId);
	}

}
