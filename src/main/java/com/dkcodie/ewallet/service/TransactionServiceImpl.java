package com.dkcodie.ewallet.service;

import com.dkcodie.ewallet.dto.TransactionDto;
import com.dkcodie.ewallet.entity.Transaction;
import com.dkcodie.ewallet.entity.User;
import com.dkcodie.ewallet.repository.TransactionRepository;
import com.dkcodie.ewallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Transaction createTransaction(TransactionDto transactionDto) {
        // Fetch sender and receiver from the database
        Optional<User> senderOpt = userRepository.findById(transactionDto.getSenderId());
        Optional<User> receiverOpt = userRepository.findById(transactionDto.getReceiverId());

        if (senderOpt.isPresent() && receiverOpt.isPresent()) {
            User sender = senderOpt.get();
            User receiver = receiverOpt.get();

            // Check if sender has enough balance
            if (sender.getWalletBalance() >= transactionDto.getAmount()) {
                // Deduct from sender, add to receiver
                sender.setWalletBalance(sender.getWalletBalance() - transactionDto.getAmount());
                receiver.setWalletBalance(receiver.getWalletBalance() + transactionDto.getAmount());

                // Save updated user balances
                userRepository.save(sender);
                userRepository.save(receiver);

                // Create and save the transaction
                Transaction transaction = new Transaction();
                transaction.setSender(sender);
                transaction.setReceiver(receiver);
                transaction.setAmount(transactionDto.getAmount());
                return transactionRepository.save(transaction); // Save and return transaction
            } else {
                throw new RuntimeException("Insufficient balance for the transaction");
            }
        } else {
            throw new RuntimeException("Sender or receiver not found");
        }
    }

    @Override
    public List<Transaction> findTransactionsByUserId(Long userId) {
        // Retrieve transactions where user is either sender or receiver
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return transactionRepository.findBySenderOrReceiver(user, user); // Find transactions
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<Transaction> searchTransactions(Long userId, String date, Double amount) {
        // Implement search logic (e.g., using a custom repository method or criteria)
        // Placeholder return, adjust as per your actual search implementation
        return transactionRepository.findAll(); // Example: return all transactions as a placeholder
    }

    @Override
    public void createTransaction(Long id, String email, Double amount) {

    }
}
