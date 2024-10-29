package com.dkcodie.ewallet.controller;

import com.dkcodie.ewallet.dto.TransactionDto;
import com.dkcodie.ewallet.entity.Transaction;
import com.dkcodie.ewallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    //Create Transaction Endpoint
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }



    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto transactionDto) {
        Transaction transaction = transactionService.createTransaction(transactionDto);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>> listUserTransactions(@PathVariable Long userId) {
        List<Transaction> transactions = transactionService.findTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Transaction>> searchTransactions(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Double amount) {
        List<Transaction> transactions = transactionService.searchTransactions(userId, date, amount);
        return ResponseEntity.ok(transactions);
    }

}
