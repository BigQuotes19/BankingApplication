import java.sql.SQLOutput;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        BankingMenu custBank = new BankingMenu("245679", "Joe");
        custBank.mainMenu();
    }
}

class BankingMenu {
    String customerId;
    String customerName;
    int balance;
    int previousBalance;
    int amount;

    Scanner scanner = new Scanner(System.in);

    public BankingMenu(String cid, String cname) {
        customerId = cid;
        customerName = cname;
    }

    void deposit(int amount) {
        balance = balance + amount;
        previousBalance = amount;
    }

    void withdraw(int amount) {
        balance = balance - amount;
        previousBalance = -amount;
    }

    void checkBalance() {
        System.out.println("Your balance is "+balance);
    }

    void checkPrevBalance() {
        if (previousBalance > 0) {
            System.out.println("Deposited: " + previousBalance);
        } else {
            System.out.println("Withdrew: " + Math.abs(previousBalance));
        }
    }

    void mainMenu() {
        System.out.println("*********************************************************");
        System.out.println("Welcome to my Banking Application: "+customerId+" "+customerName);
        System.out.println("*********************************************************");
        System.out.println("A - Check Balance ");
        System.out.println("B - Deposit ");
        System.out.println("C - Withdraw");
        System.out.println("D - Previous Balance");
        System.out.println("E - Exit");
        System.out.println("*********************************************************");

        char option;
        do {
            System.out.println("Select an option: ");
            option = scanner.next().charAt(0);
            switch (option) {
                case 'A':
                     checkBalance();
                    System.out.println("*********************************************************");
                    break;
                case 'B':
                    System.out.println("Enter the amount you want to deposit: ");
                    amount = scanner.nextInt();
                    System.out.println("*********************************************************");
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("Enter the amount you want to withdraw: ");
                    amount = scanner.nextInt();
                    System.out.println("*********************************************************");
                    withdraw(amount);
                    break;
                case 'D':
                    checkPrevBalance();
                    break;
                case 'E':
                    System.out.println("Thank you for using the Banking Application.");
                    System.out.println("*********************************************************");
                    break;

            }

        } while (option != 'E');
    }
}
