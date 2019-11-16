package com.javastarter.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javastarter.bookstore.model.Book;
import com.javastarter.bookstore.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book/allbooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok().body(this.bookService.getAllBook());
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) {
		return ResponseEntity.ok().body(this.bookService.getBookById(id));
	}
	
	@PostMapping("book/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.ok().body(this.bookService.addBook(book));
	}
	
	@PutMapping("book/updatecopies/{id}/copies/{numCopies}")
	public ResponseEntity<Book> updateCopies(@PathVariable long id, @PathVariable int numCopies) {
		return ResponseEntity.ok().body(this.bookService.addCopies(id, numCopies));
	}
	
}
