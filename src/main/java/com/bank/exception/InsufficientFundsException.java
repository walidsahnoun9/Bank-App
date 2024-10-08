/*
 * Copyright (c) 2024.
 * All rights reserved.
 */

package com.bank.exception;

/**
 * @author Walid
 */

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
