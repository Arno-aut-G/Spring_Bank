package com.dachsbau.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    private String id, reference;

    @JsonProperty("bankslogan")
    private String bankSlogan;

    private Integer amount;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'")
    private LocalDateTime timeStamp;

    public Transaction() {}

    @Autowired
    public Transaction(Integer amount, String reference, LocalDateTime timeStamp, String bankSlogan) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.reference = reference;
        this.timeStamp = timeStamp;
        this.bankSlogan = bankSlogan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBankSlogan() {
        return bankSlogan;
    }

    public void setBankSlogan(String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }
}
