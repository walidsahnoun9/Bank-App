# Bank-App
# Bank Account Management

This project is a Java implementation of the **Bank Account Kata**, designed to showcase good coding practices such as Clean Code, TDD (Test-Driven Development), and thread-safe handling of concurrent access. The application simulates basic bank account operations such as deposits, withdrawals, and printing account statements.

## Features

- Deposit money into the account.
- Withdraw money from the account.
- View the transaction history (date, type, amount, balance).
- Thread-safe operations using synchronization mechanisms.
- Exception handling for insufficient funds and invalid input.
- Unit tests to validate the correctness of the implementation.

## Requirements

- Java 11 or higher (recommended 17)
- Maven 3.6 or higher

## Project Structure

- **Model**: Contains core business classes (`Account`, `Transaction`).
- **Service**: Contains business logic and services like `AccountService`.
- **Exception**: Custom exception handling for cases like `InsufficientFundsException`.
- **Test**: Unit tests for validating the functionality of the application.

## Setup

### Step 1: Clone the Repository
```bash
git clone <your-repo-url>
cd <your-folder>
