package com.jay.LibraryMamagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jay.LibraryMamagement.entity.MyLibrary;

public interface MyLibraryRepository extends CrudRepository<MyLibrary, Integer> {

    List<MyLibrary> findAllMyLibraryByuserId(Integer userId);
}
