
package model;

import java.util.Objects;

public class BankAccount {
    private final String accountNumber;
    private final String holderName;
    private double balance;

    private static int accountCount = 0;

    // Constructor 1: no arguments
    public BankAccount() {
        this("UNKNOWN", "Guest", 0.0);
    }

    // Constructor 2: two arguments
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    // Constructor 3: full details
    public BankAccount(String accountNumber,
                       String holderName, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Account number cannot be empty");
        }
        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException(
                    "Holder name cannot be empty");
        }
        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException(
                    "Invalid opening balance");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        accountCount++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit must be positive and finite");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal must be positive and finite");
        }

        // BUG: intentionally planted for debugging practice
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalStateException(
                    "Insufficient balance");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BankAccount)) return false;

        BankAccount other = (BankAccount) obj;
        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}