/*
 * Copyright (c) 2024.
 * All rights reserved.
 */

package com.bank;

import com.bank.model.Account;
import com.bank.service.AccountService;

/**
 * @author Walid
 */

public class BankAppApplication {

	public static void main(String[] args) {

		Account account = new Account();
		AccountService service = new AccountService(account);

		service.deposit(1000);
		service.withdraw(300);
		service.printStatement();
	}

}
