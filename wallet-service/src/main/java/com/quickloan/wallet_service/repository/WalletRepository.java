package com.quickloan.wallet_service.repository;

import com.quickloan.wallet_service.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    // Spring Data JPA magic: It looks at your Wallet entity, finds the "userId" field,
    // and automatically writes the SQL query: "SELECT * FROM wallet WHERE user_id = ?"
    Wallet findByUserId(Long userId);
}