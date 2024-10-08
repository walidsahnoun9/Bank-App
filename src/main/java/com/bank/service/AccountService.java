package com.bank.service;

import com.bank.model.Account;

public class AccountService {
    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void printStatement() {
        StatementPrinter printer = new StatementPrinter();
        printer.print(account.getTransactions());
    }
}
