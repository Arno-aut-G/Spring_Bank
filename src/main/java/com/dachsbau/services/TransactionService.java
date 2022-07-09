package com.dachsbau.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dachsbau.model.Transaction;

@Service
public class TransactionService {

    private List<Transaction> transactions = new CopyOnWriteArrayList<>();

    private final String bankSlogan;

    public TransactionService(@Value("${bank.slogan}") String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(Integer amount, String reference) {
        LocalDateTime timeStamp = LocalDateTime.now();
        Transaction transaction = new Transaction(amount, reference, timeStamp, bankSlogan);
        transactions.add(transaction);
        return transaction;
    }
}
