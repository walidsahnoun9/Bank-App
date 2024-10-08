/*
 * Copyright (c) 2024.
 * All rights reserved.
 */

package com.bank;

import com.bank.model.Account;
import com.bank.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Walid
 */

class BankAppApplicationTests {

	private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private AccountService accountService;

	@BeforeEach
	public void setUp() {
        Account account = new Account();
		accountService = new AccountService(account);
		System.setOut(new PrintStream(outputContent));
	}

	@Test
	public void testBankApp() {
		// Simulate the main functionality of BankApp
		accountService.deposit(1000);
		accountService.withdraw(300);
		accountService.printStatement();

		String transactionOutput = outputContent.toString();

		// Verify that the deposit operation was recorded
		assertTrue(transactionOutput.contains("DEPOSIT"));
		assertTrue(transactionOutput.contains("1000.0"));

		// Verify that the withdrawal operation was recorded
		assertTrue(transactionOutput.contains("WITHDRAWAL"));
		assertTrue(transactionOutput.contains("300.0"));

		// Verify the balance after operations
		assertTrue(transactionOutput.contains("700.0"));
	}

}
