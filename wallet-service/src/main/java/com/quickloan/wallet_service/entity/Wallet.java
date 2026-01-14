package com.quickloan.wallet_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double balance;
}