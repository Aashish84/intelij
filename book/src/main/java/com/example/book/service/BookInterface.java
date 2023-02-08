package com.example.book.service;

import com.example.book.exception.CustomBookException;
import com.example.book.entity.Book;

import java.util.List;

public interface BookInterface {

    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book updateBook (int id , Book book) throws CustomBookException;
    String deleteBook (int id);
    List<Book> findAllByPageSortByPrice(int page_no , int page_size);
}
