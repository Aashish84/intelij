package com.example.book.service;

import com.example.book.exception.CustomBookException;
import com.example.book.entity.Author;
import com.example.book.helper.AuthorChild;

import java.util.HashMap;
import java.util.List;

public interface AuthorInterface {
    List<Author> getAllAuthors();

    Author addAuthor(Author author);

    Author updateAuthor ( int id , Author author) throws CustomBookException;

    String deleteAuthor (int id) throws Exception;

    HashMap<Integer, String> getAllAuthorAvgRating();

    List<AuthorChild> getAllAuthorAvgPrice();

}
