package com.dkcodie.ewallet.service;

import com.dkcodie.ewallet.dto.TransactionDto;
import com.dkcodie.ewallet.entity.Transaction;


import java.util.List;

public interface TransactionService {
    Transaction createTransaction(TransactionDto transactionDto);
    List<Transaction> findTransactionsByUserId(Long userId);
    List<Transaction> searchTransactions(Long userId, String date, Double amount);

    void createTransaction(Long id, String email, Double amount);
}

