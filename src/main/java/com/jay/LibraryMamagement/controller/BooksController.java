package com.jay.LibraryMamagement.controller;

import org.springframework.web.bind.annotation.*;

import com.jay.LibraryMamagement.entity.Books;
import com.jay.LibraryMamagement.service.BooksService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Books getBook(@PathVariable Integer id) {
        return booksService.getBook(id);
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Books book) {
        try {
            Books newBook = booksService.addBook(book);
            return new ResponseEntity<Books>(newBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // @GetMapping("/genres")
    // public List<String> getGenreList() {
    // return booksService.getGenreList();
    // }

    @GetMapping("/genres/{genreName}")
    public List<Books> getBooksByGenre(@PathVariable String genreName) {
        return booksService.getBooksByGenre(genreName);
    }

    @GetMapping("/suggestion/{audience}")
    public List<Books> getBooksBySuitableAudience(@PathVariable String audience) {
        return booksService.getBooksBySuitableAudience(audience);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            booksService.deleteBook(id);
            String message = "Book " + id + " has been deleted";
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
