package com.dkcodie.ewallet.repository;

import com.dkcodie.ewallet.entity.Transaction;
import com.dkcodie.ewallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Find all transactions for a specific user (either as sender or receiver)
    List<Transaction> findBySenderOrReceiver(User sender, User receiver);

    // Retrieve transactions involving a specific user as the sender
    List<Transaction> findBySender(User sender);

    // Retrieve transactions involving a specific user as the receiver
    List<Transaction> findByReceiver(User receiver);
}
