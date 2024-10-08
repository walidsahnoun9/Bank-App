package com.bank.service;

import com.bank.model.Transaction;
import java.util.List;

public class StatementPrinter {
    public void print(List<Transaction> transactions) {
        System.out.println("DATE | OPERATION | AMOUNT | BALANCE AFTER");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }
}
