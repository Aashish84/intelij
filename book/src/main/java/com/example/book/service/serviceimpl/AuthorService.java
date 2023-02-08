package com.example.book.service.serviceimpl;

import com.example.book.exception.CustomBookException;
import com.example.book.entity.Author;
import com.example.book.helper.AuthorChild;
import com.example.book.entity.Book;
import com.example.book.repository.AuthorRepository;
import com.example.book.service.AuthorInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService implements AuthorInterface {

    public final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        List<Author> allAuthor = authorRepository.findAll();
        return allAuthor;
    }

    @Override
    public Author addAuthor(Author author) {
        Author save = authorRepository.save(author);
        return save;
    }

    @Override
    public Author updateAuthor(int id, Author author) throws CustomBookException {
//       new author after update
//        Author newAuthor = null;
////        searching author and update after found
//        Optional<Author> authorById = authorRepository.findById(id);
//
//        if (authorById.isPresent()) {
//            author.setId(id);
//            newAuthor = authorRepository.save(author);
//        }else{
//            throw new CustomBookException("no author found to update");

        author.setId(id);
        Author newAuthor = authorRepository.save(author);
        return newAuthor;
    }

    @Override
    public String deleteAuthor(int id) throws Exception {
        Author author = authorRepository.findById(id).get();
        if(author.getBooks().size() !=0){
            throw new CustomBookException("authors has book");
        }
//        System.out.println(author);
        authorRepository.deleteById(id);
        return "author deleted of id : " + id;
    }

    @Override
    public HashMap<Integer, String> getAllAuthorAvgRating() {
        HashMap<Integer, String> map = new HashMap<>();
        List<Author> allAuthors = authorRepository.findAll();
        for (Author author : allAuthors) {
            double authorRatingTotal = 0;
            List<Book> books = author.getBooks();
            for (Book book : books) {
                authorRatingTotal += book.getRating();
            }
            double avgRating = 0.0;

            if(books.size() != 0){
                avgRating = authorRatingTotal / books.size();
            }
            map.put(author.getId(), author.getFirstName() + " average rating : " + avgRating);
        }

        return map;
    }

    @Override
    public List<AuthorChild> getAllAuthorAvgPrice() {
        List<Author> allAuthors = authorRepository.findAll();
        List<AuthorChild> authorChildList = new ArrayList<>();
        for(Author author : allAuthors){
            double totalPrice = 0.0;
            for(Book book : author.getBooks()){
                totalPrice += book.getPrice();
            }
            double avgPrice = totalPrice / author.getBooks().size();
            AuthorChild authorChild = new AuthorChild();

            authorChild.setId(author.getId());
            authorChild.setCountry(author.getCountry());
            authorChild.setLastName(author.getLastName());
            authorChild.setFirstName(author.getFirstName());
            authorChild.setBooks(author.getBooks());

            authorChild.setAvgPrice(avgPrice);
            authorChildList.add(authorChild);
        }
        Collections.sort(authorChildList, new Comparator<AuthorChild>() {
            @Override
            public int compare(AuthorChild o1, AuthorChild o2) {
                return (int) (o2.getAvgPrice()-o1.getAvgPrice());
            }
        });
        return authorChildList;
    }
}
