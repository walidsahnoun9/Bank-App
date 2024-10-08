/*
 * Copyright (c) 2024.
 * All rights reserved.
 */

package com.bank.model;

import com.bank.exception.InsufficientFundsException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Walid
 */

public class Account {
    private double balance;
    private final List<Transaction> transactions;

    public Account() {
        this.balance = 0.0;
        this.transactions = Collections.synchronizedList(new ArrayList<>());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactions.add(new Transaction(LocalDate.now(), "DEPOSIT", amount, this.balance));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            transactions.add(new Transaction(LocalDate.now(), "WITHDRAWAL", amount, this.balance));
        } else if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds. Current balance: " + this.balance);
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions); // Return a copy to prevent external modification
    }

    public double getBalance() {
        return balance;
    }
}
