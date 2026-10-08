package org.example;

/**
 * Hello world!
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int attempts=0;
        int balance=0;
        int choice;
        boolean login=false;
        ArrayList<String> transactions=new ArrayList<>();
        System.out.println("set a 4 digit pin:");
        final int pin=sc.nextInt();
        while(attempts<3 && login!=true){
            System.out.println("Enter your pin:");
            int pinvalidation=sc.nextInt();
            if(pinvalidation==pin){
                login=true;
                System.out.println("Login Successfull!");
                break;
            }
            else if(pinvalidation!=pin && attempts<3){
                attempts++;
                continue;
            }

        }
        if(login==false){
            System.out.print("Card Blocked .");
        }
        if(login==true){
            do{
                System.out.println("=====ATM MENU=====");
                System.out.println("1.balance check");
                System.out.println("2.deposit");
                System.out.println("3.withdraw");
                System.out.println("4.miniStatement");
                System.out.println("5.logout");
                System.out.println("enter your choice:");
                 choice=sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("your balance is "+ balance);
                        break;
                    case 2:
                        System.out.println("Enter your deposit Amount:");
                        if(!sc.hasNextInt()){
                            System.out.println("invalid input");
                            sc.next();
                            continue;
                        }
                        int deposite=sc.nextInt();
                        if(deposite>0){
                            balance+=deposite;
                            transactions.add("deposit:+"+deposite);
                            System.out.println("Amount:"+deposite+" successfully deposited!");
                            System.out.println("Your current balance is:"+balance);

                        }
                        break;
                    case 3:
                        System.out.println("Enter your withdrawal Amount:");
                        if(!sc.hasNextInt()){
                            System.out.println("invalid input");
                            sc.next();
                            continue;
                        }
                        int withdrawal=sc.nextInt();

                        if(withdrawal>0 && withdrawal<=balance){
                            balance-=withdrawal;
                            transactions.add("withdrawal:-"+withdrawal);
                            System.out.println("Amount:"+withdrawal+" successfully withdraw!");
                            System.out.println("Your current balance is:"+balance);
                        }
                        break;
                    case 4:
                        System.out.println("======MINI STATEMENT======");
                        for(String transaction:transactions){
                            System.out.println(transaction);
                        }
                        System.out.println("Your current balance is:"+balance);
                        break;
                    case 5:
                        System.out.println("Thanks for using the ATM!");
                        break;
                    default:
                        System.out.println("invalid choice enter 1-5");
                        break;
                }

            }while(choice!=5);

        }

        sc.close();

    }
}
