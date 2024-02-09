package com.jay.LibraryMamagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jay.LibraryMamagement.entity.Books;

public interface BooksRepository extends CrudRepository<Books, Integer> {

    // @Query("SELECT b FROM books b WHERE b.genre = ?1")
    List<Books> findByGenre(String genre);

    // @Query("SELECT b FROM books b WHERE b.suitable_audience = ?1")
    List<Books> findBySuitableAudience(String suitableAudience);

    // @Query("SELECT DISTINCT genre FROM books")
    // List<String> getGenreList();

}
