/*
 * Copyright (c) 2024.
 * All rights reserved.
 */

package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.model.Account;
import com.bank.service.AccountService;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Walid
 */

public class StatementPrinterTest {
    private AccountService accountService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        Account account = new Account();
        accountService = new AccountService(account);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintStatement() {
        accountService.deposit(1000);
        accountService.withdraw(300);
        accountService.printStatement();
        String output = outContent.toString();
        assertTrue(output.contains("DEPOSIT"));
        assertTrue(output.contains("WITHDRAWAL"));
    }
}
