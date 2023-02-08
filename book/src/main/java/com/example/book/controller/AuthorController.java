package com.example.book.controller;

import com.example.book.entity.Author;
import com.example.book.exception.CustomBookException;
import com.example.book.service.AuthorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    private final AuthorInterface authorInterface;

    @Autowired
    public AuthorController(AuthorInterface authorInterface){
        this.authorInterface = authorInterface;
    }

    @GetMapping("/authors")
    public ResponseEntity<?> getAllAuthors(){
        return new ResponseEntity<>(authorInterface.getAllAuthors() , HttpStatus.OK);
    }

    @PostMapping("/authors")
    public ResponseEntity<?> addAuthor(@RequestBody Author author ){
        return new ResponseEntity<>(authorInterface.addAuthor(author) , HttpStatus.CREATED);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable ("id") int id , @RequestBody Author author) throws CustomBookException {
        return new ResponseEntity<> (authorInterface.updateAuthor(id , author) , HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable ("id") int id) throws Exception {
        return new ResponseEntity<>(authorInterface.deleteAuthor(id) , HttpStatus.OK);
    }

    @GetMapping("/author-avgRating")
    public ResponseEntity<?> getAuthorsAvgRating(){
        return new ResponseEntity<>(authorInterface.getAllAuthorAvgRating() , HttpStatus.OK);
    }

    @GetMapping("/author-avgPrice")
    public ResponseEntity<?> getAuthorsAvgPrice(){
        return new ResponseEntity<>(authorInterface.getAllAuthorAvgPrice() , HttpStatus.OK);
    }
}
