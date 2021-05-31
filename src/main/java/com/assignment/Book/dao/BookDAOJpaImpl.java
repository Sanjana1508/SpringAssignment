package com.assignment.Book.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment.Book.entity.Book;

@Repository
public class BookDAOJpaImpl implements BookDAO {

private EntityManager entityManager;
	
	@Autowired
	public BookDAOJpaImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public List<Book> findAll() {
		
		Query theQuery = entityManager.createQuery("from Book");
		
		List<Book> theBooks = theQuery.getResultList();
		
		return theBooks;
	}

	@Override
	public Book findById(int theId) {
		
		Book theBook = entityManager.find(Book.class, theId);
		return theBook;
	}

	@Override
	public void save(Book theBook) {
		Book dbBook = entityManager.merge(theBook);
		
		theBook.setId(dbBook.getId());

	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Book where id=:bookId");
		
		theQuery.setParameter("bookId", theId);
		theQuery.executeUpdate();

	}

}
