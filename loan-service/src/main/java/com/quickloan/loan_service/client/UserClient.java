package com.quickloan.loan_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "identity-service" matches the spring.application.name in the other project
@FeignClient(name = "identity-service")
public interface UserClient {

    @GetMapping("/auth/validate/{userId}")
    boolean validateUser(@PathVariable("userId") Long userId);
}