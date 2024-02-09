package com.jay.LibraryMamagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jay.LibraryMamagement.dto.LoginDto;
import com.jay.LibraryMamagement.dto.SignupDto;
import com.jay.LibraryMamagement.entity.User;
import com.jay.LibraryMamagement.repository.UserRepository;
import com.jay.LibraryMamagement.utils.JwtUtil;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {

        // checking for email exists in a database
        if (!userRepository.existsByEmail(loginDto.getEmail())) {
            return new ResponseEntity<>("Email not found!", HttpStatus.BAD_REQUEST);
        }

        try {
            User user = userRepository.findByEmail(loginDto.getEmail());

            if (!loginDto.getPassword().equals(user.getPassword())) {
                return new ResponseEntity<>("Password does not match!", HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(JwtUtil.generateToken(user.getUsername()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occured while login user: " + e, HttpStatus.BAD_GATEWAY);

        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupDto signUpDto) {
        // checking for email exists in a database
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
        }
        // creating user object
        try {
            User user = new User();
            user.setName(signUpDto.getName());
            user.setUsername(signUpDto.getUsername());
            user.setEmail(signUpDto.getEmail());
            user.setPassword(signUpDto.getPassword());
            userRepository.save(user);
            return new ResponseEntity<>(JwtUtil.generateToken(signUpDto.getUsername()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occured while creating user: " + e, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/currentUser")
    public User currentUser(@RequestParam String token) {
        String username = JwtUtil.extractSubject(token);
        return userRepository.findByUsername(username);
    }

}