package com.jay.LibraryMamagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.jay.LibraryMamagement.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    User findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
