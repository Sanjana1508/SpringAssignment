package com.assignment.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.Book.entity.Book;
import com.assignment.Book.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	
	
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	@GetMapping("/list")
	public String getBooks(Model theModel) {
		List<Book> books = bookService.findAll();
		theModel.addAttribute("books",books);
		return "list-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Book theBook = new Book();
		
		theModel.addAttribute("book",theBook);
		return "book-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,Model theModel) {
		
		Book theBook = bookService.findById(theId);
		
		theModel.addAttribute("book",theBook);
		return "book-form";
		
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		
		bookService.save(theBook);
		
		return "redirect:/books/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		bookService.deleteById(theId);
		return "redirect:/books/list";
	}
	
	
}
