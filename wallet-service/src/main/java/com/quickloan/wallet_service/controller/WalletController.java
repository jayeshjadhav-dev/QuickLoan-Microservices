package com.quickloan.wallet_service.controller;

import com.quickloan.wallet_service.entity.Wallet;
import com.quickloan.wallet_service.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService service;

    @PostMapping("/add")
    public Wallet addMoney(@RequestParam Long userId, @RequestParam Double amount) {
        return service.addMoney(userId, amount);
    }
}