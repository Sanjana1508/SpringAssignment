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

	//private BookRepository bookRepository;

	
	@Autowired
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO=bookDAO;
	}
	
	/*@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}*/
	
	@Override
	@Transactional
	public List<Book> findAll() {
		//return bookRepository.findAll();
		return bookDAO.findAll();
	}

	@Override
	@Transactional
	public Book findById(int theId) {
		
		/*Optional<Book> result = bookRepository.findById(theId);
		Book theBook = null;
		if(result.isPresent()) {
			theBook= result.get();
		}
		else {
			throw new RuntimeException("Book id not found : "+theId);
		}
		return theBook;*/
		
		return bookDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Book theBook) {
		//return bookRepository.save(theBook);
		bookDAO.save(theBook);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		//return deleteById(theId);
		bookDAO.deleteById(theId);
	}

}
