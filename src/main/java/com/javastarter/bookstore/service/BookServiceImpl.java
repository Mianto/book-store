package com.javastarter.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javastarter.bookstore.exception.ResourceNotFoundException;
import com.javastarter.bookstore.model.Book;
import com.javastarter.bookstore.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book addCopies(long id, int numCopies) {
		Optional<Book> bookDb = this.bookRepository.findById(id);
		if (bookDb.isPresent()) {
			Book updatedBook = bookDb.get();
			updatedBook.setNumberOfCopies(numCopies);
			bookRepository.save(updatedBook);
			return updatedBook;
		} else {
			throw new ResourceNotFoundException("No Record of Book with id " + id);
		}
	}

	@Override
	public List<Book> getAllBook() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book getBookById(long id) {
		Optional<Book> bookDb = this.bookRepository.findById(id);
		if (bookDb.isPresent()) {
			return bookDb.get();
		} else {
			throw new ResourceNotFoundException("No Record of Book with id " + id);
		}
	}

}
