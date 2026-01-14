package com.quickloan.loan_service.controller;

import com.quickloan.loan_service.entity.Loan;
import com.quickloan.loan_service.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping("/apply")
    public Loan apply(@RequestBody Loan loan) {
        return service.applyForLoan(loan);
    }

    @PutMapping("/{loanId}/approve")
    public Loan approveLoan(@PathVariable Long loanId) {
        return service.approveLoan(loanId);
    }
}