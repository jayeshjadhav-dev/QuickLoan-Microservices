package com.quickloan.identity_service.controller;

import com.quickloan.identity_service.entity.UserCredential;
import com.quickloan.identity_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

   // Add inside AuthController
    @Autowired
    private com.quickloan.identity_service.repository.UserCredentialRepository repository; // Direct repo access for simplicity

    @GetMapping("/validate/{userId}")
    public boolean validateUser(@PathVariable("userId") Long userId) {
        return repository.existsById(userId);
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential credential) {
        return service.saveUser(credential);
    }
}