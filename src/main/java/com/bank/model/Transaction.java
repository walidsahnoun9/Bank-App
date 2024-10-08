/*
 * Copyright (c) 2024.
 * All rights reserved.
 */

package com.bank.model;

import java.time.LocalDate;

/**
 * @author Walid
 */

public class Transaction {
    private final LocalDate date;
    private final String type;
    private final double amount;
    private final double balance;

    public Transaction(LocalDate date, String type, double amount, double balance) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + amount + " | " + balance;
    }
}
