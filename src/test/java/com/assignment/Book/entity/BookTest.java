package com.assignment.Book.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

	@Test
	public void testBook() {
		Book theBook = new Book(1,"Antic Hay",200,100.0,"Aldous Huxley");
		
		assertNotNull(theBook);
		
		Book theBook2 = new Book("East of Eden",400,1000.0,"Christie");
		
		assertNotNull(theBook2);
		
	}
}
