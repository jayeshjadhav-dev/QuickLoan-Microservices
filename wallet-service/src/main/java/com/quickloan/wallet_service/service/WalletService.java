package com.quickloan.wallet_service.service;

import com.quickloan.wallet_service.entity.Wallet;
import com.quickloan.wallet_service.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository repository;

    public Wallet addMoney(Long userId, Double amount) {
        Wallet wallet = repository.findByUserId(userId);

        if (wallet == null) {
            // Create new wallet if first time
            wallet = new Wallet();
            wallet.setUserId(userId);
            wallet.setBalance(0.0);
        }

        wallet.setBalance(wallet.getBalance() + amount);
        return repository.save(wallet);
    }
}