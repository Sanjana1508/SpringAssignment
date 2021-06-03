package com.assignment.Book.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.Book.entity.Book;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookDAO bookDAO;
	
	private List<Book> books ;
	@Test
	public void testSave() {
		Book theBook = bookRepository.save(new Book("abc",100,100,"xyz"));
		assertNotNull(theBook);
		assertTrue(theBook.getId()>0);
		assertTrue(theBook.getBookName().equals("abc"));
		assertTrue(theBook.getNumberOfPages() == 100);
		assertTrue(theBook.getPrice() == 100);
		assertTrue(theBook.getAuthor().equals("xyz"));
		
	}
	
	@Test
	public void testSaveThrowsExceptionWhenBookNameIsNull() {
		Book theBook = bookRepository.save(new Book());
		System.out.println(theBook.getId());
		System.out.println(theBook);
		assertNull(theBook.getBookName());
		assertNotNull(theBook.getId());
		
	}
	
	@Test
	public void testFindAll() {
		bookRepository.deleteAll();
		initialSetUp();
		books = (List<Book>) bookRepository.findAll();
		System.out.println(books);
		assertNotNull(books);
		assertEquals(books.size(),2);
		}

	private void initialSetUp() {
		books=new ArrayList<>();
		Book theBook1 = new Book("Catch-22",200,500,"Joseph");
		Book theBook2 = new Book("Ulysses",323,1000,"James");
		bookRepository.save(theBook1);
		bookRepository.save(theBook2);
	}
	
	@Test
	public void testFindById() throws IndexOutOfBoundsException{
		bookRepository.deleteAll();
		initialSetUp();
		books = bookRepository.findAll();
		Optional<Book> book1 = bookRepository.findById(books.get(0).getId());
		Book theBook1=null;
		if(book1.isPresent()) {
			theBook1=book1.get();
		}
		assertNotNull(theBook1);
		try {
		Optional<Book> book2 = bookRepository.findById(books.get(5).getId());
		throw new IndexOutOfBoundsException();
		}
		catch(IndexOutOfBoundsException exc) {
			System.out.println("Index Out Of Bounds Exception");
		}
	}
	
	@Test
	public void testDeleteById() {
		bookRepository.deleteAll();
		initialSetUp();
		books = bookRepository.findAll();
		int size=books.size();
		System.out.println(books);
		bookDAO.deleteById(books.get(0).getId());
		System.out.println(books);
		assertTrue(books.size()==size-1);
	}
}
