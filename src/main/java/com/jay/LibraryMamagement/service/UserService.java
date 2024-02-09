package com.jay.LibraryMamagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.LibraryMamagement.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

}