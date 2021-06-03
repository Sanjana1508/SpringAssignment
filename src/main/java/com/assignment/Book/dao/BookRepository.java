package com.assignment.Book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.assignment.Book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	
}
