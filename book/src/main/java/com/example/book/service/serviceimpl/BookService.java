package com.example.book.service.serviceimpl;

import com.example.book.exception.CustomBookException;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookInterface;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookInterface {
   private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> all = bookRepository.findAll();
        return all;
    }

    @Override
    public Book saveBook(Book book) {
        Book save = bookRepository.save(book);
        return save;
    }

    @Override
    public Book updateBook(int id, Book book) throws CustomBookException {
        Book newBook = null;
        Optional<Book> bookById = bookRepository.findById(id);

        if(bookById.isPresent()){
            book.setId(id);
            newBook = bookRepository.save(book);
        }else{
            throw new CustomBookException("no book found to update of given id");
        }

        return newBook;
    }

    @Override
    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "book deleted of id : "+id;
    }

    @Override
    public List<Book> findAllByPageSortByPrice(int page_no , int page_size) {
        Pageable sortedByPriceDesc = PageRequest.of(page_no , page_size , Sort.by("price").descending());
        List<Book> allBooks = bookRepository.findAll(sortedByPriceDesc).getContent();
        return allBooks;
    }
}
