package com.quickloan.identity_service.service;

import com.quickloan.identity_service.entity.UserCredential;
import com.quickloan.identity_service.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;

    public String saveUser(UserCredential credential) {
        repository.save(credential);
        return "User registered successfully";
    }
}