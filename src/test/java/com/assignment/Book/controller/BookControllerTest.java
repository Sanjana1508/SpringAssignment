package com.assignment.Book.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.Book.service.BookService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class BookControllerTest {
	 
	@Autowired
	private BookService bookService;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	  
	@Test
	public void testGetBooks() throws Exception{
			this.mockMvc.perform(MockMvcRequestBuilders.get("/books/list"))
						.andExpect(status().isOk())
						.andExpect(model().attributeExists("books"))
						.andExpect(view().name("list-books"));
						
	}
	
	@Test
	public void testShowFormForAdd() throws Exception{
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/books/showFormForAdd"))
					.andExpect(status().isOk())
					.andExpect(model().attributeExists("book"))
					.andExpect(view().name("book-form"));
	}
	
	@Test
	public void testShowFormForUpdate() throws Exception{
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/books/showFormForUpdate?bookId=3"))
					.andExpect(status().isOk())
					.andExpect(model().attributeExists("book"))
					.andExpect(view().name("book-form"));
					
	}
	
	@Test
	public void testSaveBook() throws Exception{
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/books/save"))
					.andExpect(status().is3xxRedirection())
					.andExpect(view().name("redirect:/books/list"));
		
	}
	
	@Test
	public void testDelete() throws Exception{
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/books/delete?bookId=3"))
					.andExpect(status().is3xxRedirection())
					.andExpect(view().name("redirect:/books/list"));
			
	}
}
