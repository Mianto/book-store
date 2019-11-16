package com.javastarter.bookstore.service;

import java.util.List;

import com.javastarter.bookstore.model.Book;

public interface BookService {
	Book addBook(Book book);
	Book addCopies(long id, int numCopies);
	List<Book> getAllBook();
	Book getBookById(long id);
}
