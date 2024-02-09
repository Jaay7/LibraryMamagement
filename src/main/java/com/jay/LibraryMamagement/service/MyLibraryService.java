package com.jay.LibraryMamagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.LibraryMamagement.entity.MyLibrary;
import com.jay.LibraryMamagement.repository.MyLibraryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MyLibraryService {

    @Autowired
    private MyLibraryRepository myLibraryRepository;

    public List<MyLibrary> findByUser(Integer userId) {
        List<MyLibrary> libraryList = new ArrayList<MyLibrary>();
        myLibraryRepository.findAllMyLibraryByuserId(userId).forEach(libraryList::add);
        System.out.println(libraryList);
        return libraryList;
    }

    public void deleteFromLibrary(Integer libraryID) {
        myLibraryRepository.deleteById(libraryID);
    }
}
