package com.quickloan.loan_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wallet-service")
public interface WalletClient {

    // Matches the Controller we just tested in wallet-service
    @PostMapping("/wallet/add")
    void addMoney(@RequestParam("userId") Long userId, @RequestParam("amount") Double amount);
}