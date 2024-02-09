package com.jay.LibraryMamagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jay.LibraryMamagement.entity.Books;
import com.jay.LibraryMamagement.repository.BooksRepository;

import jakarta.transaction.Transactional;

import java.util.*;

@Service
@Transactional
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books::add);
        return books;
    }

    public Books addBook(Books book) {
        return booksRepository.save(book);
    }

    public Books getBook(Integer bookID) {
        return booksRepository.findById(bookID).get();
    }

    public void deleteBook(Integer bookID) {
        booksRepository.deleteById(bookID);
    }

    public List<Books> getBooksByGenre(String genre) {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findByGenre(genre).forEach(books::add);
        return books;
    }

    public List<Books> getBooksBySuitableAudience(String suitableAudience) {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findBySuitableAudience(suitableAudience).forEach(books::add);
        return books;
    }

    // public List<String> getGenreList() {
    // List<String> genres = new ArrayList<String>();
    // booksRepository.getGenreList().forEach(genres::add);
    // return genres;
    // }
}
