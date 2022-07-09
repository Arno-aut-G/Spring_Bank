package com.dachsbau.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.dachsbau.model.Transaction;

public class TransactionService {

    private List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(Integer amount, String reference) {
        LocalDateTime timeStamp = LocalDateTime.now();
        Transaction transaction = new Transaction(amount, reference, timeStamp);
        transactions.add(transaction);
        return transaction;
    }
}
