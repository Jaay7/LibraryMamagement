package com.jay.LibraryMamagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.LibraryMamagement.entity.MyLibrary;
import com.jay.LibraryMamagement.repository.MyLibraryRepository;
import com.jay.LibraryMamagement.repository.UserRepository;
import com.jay.LibraryMamagement.service.MyLibraryService;
import com.jay.LibraryMamagement.utils.JwtUtil;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class MyLibraryController {

    @Autowired
    private MyLibraryService myLibraryService;

    @Autowired
    private MyLibraryRepository myLibraryRepository;

    @Autowired
    private UserRepository userRepository;

    public Integer getCurrentUserId(String token) {
        Integer userId = userRepository.findByUsername(JwtUtil.extractSubject(token)).getId();
        return userId;
    }

    @GetMapping("/library")
    public List<MyLibrary> getAllLibrariesOfUser(@RequestParam String token) {
        return myLibraryService.findByUser(getCurrentUserId(token));
    }

    @PostMapping("/addToLibrary")
    public ResponseEntity<?> postMethodName(@RequestBody MyLibrary library) {
        try {
            MyLibrary newLibrary = myLibraryRepository.save(library);
            return new ResponseEntity<MyLibrary>(newLibrary, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteFromLibrary/{id}")
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        try {
            myLibraryService.deleteFromLibrary(id);
            String message = "Library " + id + " was successfully deleted";
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

}
