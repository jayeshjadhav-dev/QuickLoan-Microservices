package com.quickloan.loan_service.service;

import com.quickloan.loan_service.client.UserClient;
import com.quickloan.loan_service.entity.Loan;
import com.quickloan.loan_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    @Autowired
    private UserClient userClient; // Inject the Feign Client

    @Autowired
    private com.quickloan.loan_service.client.WalletClient walletClient;

    public Loan applyForLoan(Loan loan) {
        // 1. Call Identity Service via Network
        boolean userExists = userClient.validateUser(loan.getUserId());

        if (!userExists) {
            throw new RuntimeException("User not found. Cannot create Loan.");
        }

        // 2. If valid, proceed
        loan.setAppliedAt(LocalDateTime.now());
        loan.setStatus("PENDING");
        return repository.save(loan);
    }

    public Loan approveLoan(Long loanId) {
        // 1. Fetch the loan
        Loan loan = repository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        // 2. Check if already approved
        if ("APPROVED".equals(loan.getStatus())) {
            return loan;
        }

        // 3. Call Wallet Service to add money (Synchronous communication)
        walletClient.addMoney(loan.getUserId(), loan.getAmount());

        // 4. Update Status
        loan.setStatus("APPROVED");
        return repository.save(loan);
    }
}