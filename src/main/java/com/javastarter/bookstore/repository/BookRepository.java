package com.javastarter.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastarter.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
