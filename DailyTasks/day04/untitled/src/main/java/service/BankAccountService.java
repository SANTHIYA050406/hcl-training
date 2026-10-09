
package service;

import model.BankAccount;

public class BankAccountService {

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }

    public void printBalance(BankAccount account) {
        System.out.println(
                account.getAccountNumber()
                        + " balance: Rs. "
                        + account.getBalance());
    }
}