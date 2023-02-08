package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.exception.CustomBookException;
import com.example.book.service.BookInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

//    @Autowired
//    BookInterface bookInterface;

    private final BookInterface bookInterface;
    public BookController(BookInterface bookInterface){
        this.bookInterface = bookInterface;
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookInterface.getAllBooks() , HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        System.out.println(book);
        return new ResponseEntity<>(bookInterface.saveBook(book) , HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book) throws CustomBookException {
        return new ResponseEntity<>(bookInterface.updateBook(id,book) , HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id){
        return new ResponseEntity<>(bookInterface.deleteBook(id) , HttpStatus.OK);
    }

    @GetMapping("/book-pagination")
    public ResponseEntity<?> findBookByPage(@RequestParam("page_no") int page_no , @RequestParam("page_size") int page_size){
        return new ResponseEntity<>(bookInterface.findAllByPageSortByPrice(page_no , page_size), HttpStatus.OK);
    }
}
