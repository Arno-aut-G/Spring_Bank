package com.dachsbau.context;

import com.dachsbau.services.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Application {

    public static TransactionService transactionService = new TransactionService();
    public static ObjectMapper objectMapper = new ObjectMapper();
}
