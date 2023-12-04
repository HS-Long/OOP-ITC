import java.util.ArrayList;
import java.util.Scanner;

public class BankAccounts {
    private String cardNumber;
    private String cardHolder;
    private String pin;
    private double balance;

    public BankAccounts(String cardNumber, String cardHolder, String pin, double balance) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.pin = pin;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Balance: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getPin() {
        return pin;
    }



    public static BankAccounts login(ArrayList<BankAccounts> accounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLogin:");
        System.out.print("Enter Card Number: ");
        String enteredCardNumber = scanner.next();
        System.out.print("Enter PIN: ");
        String enteredPIN = scanner.next();

        for (BankAccounts account : accounts) {
            if (account.getCardNumber().equals(enteredCardNumber) && account.getPin().equals(enteredPIN)) {
                System.out.println("Login successful. Welcome, " + account.getCardHolder() + "!");
                return account;
            }
        }

        System.out.println("Invalid card number or PIN. Login failed.");
        return null;
    }

    public static void performATMOperations(BankAccounts account, Scanner scanner) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\nATM Operations Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.displayAccountInfo();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    logout = true;
                    System.out.println("Logout successful. Goodbye, " + account.getCardHolder() + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
