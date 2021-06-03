package com.assignment.Book.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.Book.dao.BookRepository;
import com.assignment.Book.entity.Book;

@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	private List<Book> books=new ArrayList<>();
	
	@Test
	public void testSave() {
		Book book = createBook();
		bookServiceImpl.save(book);
	}
	@Test
	public void testFindAll() {
		initialSetUp();
		books = bookServiceImpl.findAll();
		System.out.println(books);
		assertTrue(books.size()==2);
	}
	
	
	private Book createBook() {
		Book book = new Book("abc",100,200,"xyz");
		books.add(book);
		return book;
	}
	
	private void initialSetUp() {
		Book book1 =  new Book("abc",100,200,"xyz");
		Book book2 = new Book("A Hundred Miles",507,700,"Hasley");
		bookServiceImpl.save(book1);
		bookServiceImpl.save(book2);
	}
	
	@Test
	public void testFindById() {
		initialSetUp();
		books = bookServiceImpl.findAll();
		Book book = bookServiceImpl.findById(books.get(0).getId());
		assertNotNull(book);
		
	}
	
	@Test
	public void testDelete() {
		initialSetUp();
		books= bookServiceImpl.findAll();
		System.out.println(books);
		
		int size=books.size();
		System.out.println(size);
		assertTrue(books.size()==size);
		bookServiceImpl.deleteById(books.get(0).getId());
		
		assertTrue(books.size()==size-1);
	}
}
