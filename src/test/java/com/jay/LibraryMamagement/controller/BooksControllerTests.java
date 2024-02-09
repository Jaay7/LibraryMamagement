package com.jay.LibraryMamagement.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// import com.fasterxml.jackson.databind.ObjectMapper;
import com.jay.LibraryMamagement.entity.Books;
import com.jay.LibraryMamagement.service.BooksService;

@WebMvcTest
public class BooksControllerTests {

    @Autowired
    private MockMvc mvc;

    // @Autowired
    // private ObjectMapper mapper;

    @MockBean
    private BooksService booksService;

    // Date myDate = ;

    // @Test
    // void testAddBook() throws Exception {
    // Books book = new Books();
    // book.setId(1);
    // book.setName("Sample Book");
    // book.setDescription("A sample book description");
    // book.setPrice(19.99);
    // book.setAuthor("John Doe");
    // book.setGenre("Fiction");
    // book.setCountofpages(300);
    // book.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd
    // HH:mm:ss").parse("2024-01-01 12:00:00"));
    // book.setCoverPhoto("book-cover.jpg");
    // book.setSuitableAudience("Adults");
    // book.setFirebaseFile("firebase-file-url");

    // // Mock service method
    // Mockito.when(booksService.addBook(Mockito.any(Books.class))).thenReturn(book);

    // // Perform the POST request
    // mvc.perform(post("/api/books")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(new ObjectMapper().writeValueAsString(book)))
    // .andExpect(MockMvcResultMatchers.status().isOk())
    // .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
    // .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sample Book"))
    // .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("John Doe"));
    // }

    // @Test
    // void testDelete() {

    // }

    @Test
    public void givenListOfBooks_whenGetAllBooks_thenReturnBooksList() throws Exception {
        Books book_1 = new Books(
                1,
                "Srimad Bhagavatam",
                "The Bhagavata Purana, like other puranas, discusses a wide range of topics including cosmology, astronomy, genealogy, geography, legend, music, dance, yoga and culture.",
                7500.00,
                "Veda Vyasa Maharshi",
                "Religious",
                16000,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-01-01 12:00:00"),
                "https://firebasestorage.googleapis.com/v0/b/online-library-6b47b.appspot.com/o/cover_photos%2FBhagavatam%20Cover%20Photo.jpg?alt=media&token=c4d475a7-2186-4210-b1a3-c8d6a724de55",
                "All age",
                "https://firebasestorage.googleapis.com/v0/b/online-library-6b47b.appspot.com/o/files%2Fpotana_bhagavatam_vol_1.pdf?alt=media&token=94e071d1-9a51-4959-a990-0ef1d30382e1");

        List<Books> allBooks = Arrays.asList(book_1);

        Mockito.when(booksService.getAllBooks()).thenReturn(allBooks);

        mvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(allBooks.size())))
                .andDo(print());
    }

    // @Test
    // void testGetBooksByGenre() {

    // }

    // @Test
    // void testGetBooksBySuitableAudience() {

    // }
}
