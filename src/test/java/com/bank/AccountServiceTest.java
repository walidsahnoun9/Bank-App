/*
 * Copyright (c) 2024.
 * All rights reserved.
 */

package com.bank;

import com.bank.exception.InsufficientFundsException;
import com.bank.model.Account;
import com.bank.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Walid
 */

public class AccountServiceTest {
    private Account account;
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        account = new Account();
        accountService = new AccountService(account);
    }

    @Test
    public void testDeposit() {
        accountService.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        accountService.deposit(1000);
        accountService.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        accountService.deposit(500);

        // Expecting InsufficientFundsException
        assertThrows(InsufficientFundsException.class, () -> {
            accountService.withdraw(600);
        });
    }

    @Test
    public void testWithdrawNegativeAmount() {
        // Expecting IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            accountService.withdraw(-100);
        });
    }

    @Test
    public void testConcurrentAccess() throws InterruptedException {
        // Initial deposit
        accountService.deposit(1000);

        // Create a thread pool with 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Simulate 5 threads depositing 100 and 5 threads withdrawing 50 concurrently
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> accountService.deposit(100));
            executorService.submit(() -> accountService.withdraw(50));
        }

        // Shut down executor and wait for threads to finish
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        // After concurrent operations, the final balance should be:
        // initial 1000 + (5 * 100) - (5 * 50) = 1250
        assertEquals(1250, account.getBalance());
    }

    @Test
    public void testStatement() {
        accountService.deposit(1000);
        accountService.withdraw(300);
        assertEquals(2, account.getTransactions().size());
    }
}
