
package app;

import model.BankAccount;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("ACC101", "Santhiya", 1000.0);

        BankAccountService service =
                new BankAccountService();

        System.out.println("Initial account:");
        service.printBalance(account);

        service.deposit(account, 200.0);
        System.out.println("\nAfter deposit of Rs. 200:");
        service.printBalance(account);

        service.withdraw(account, 100.0);
        System.out.println("\nAfter withdrawal of Rs. 100:");
        service.printBalance(account);

        BankAccount another =
                new BankAccount("ACC101", "Another Holder", 500.0);

        System.out.println("\nSame account number? "
                + account.equals(another));

        System.out.println("Total accounts created: "
                + BankAccount.getAccountCount());
    }
}