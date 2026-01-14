package com.quickloan.loan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private Long userId; // We only store the ID, not the full User object
    private Double amount;
    private Double interestRate;
    private Integer daysToRepay;

    private String status; // PENDING, APPROVED, REJECTED

    private LocalDateTime appliedAt;
}