import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        int choicee;
        do {
            System.out.println("Welcome to My Project!");
            System.out.println("1. Rectangle.");
            System.out.println("2. BankAccount.");
            System.out.println("3. SMS_Encrypt.");
            System.out.println("4. Shape_Hierarchy.");
            System.out.println("5. ATM_Simulator.");
            System.out.println("6. Exit.");
            System.out.print("Enter your choice: ");
            choicee = scann.nextInt();
            switch (choicee) {
                case 1:
                    Rectangle rectangle = new Rectangle(5,8);
                    int perimeter = rectangle.calculatePerimeter();
                    System.out.println("Perimeter of the rectangle: " + perimeter);
                    int surface = rectangle.calculateSurface();
                    System.out.println("Surface area of the rectangle: " + surface);
                    break;

                case 2:
                    BankAccount account1 = new BankAccount("Visal" , 500.0);
                    BankAccount account2 = new BankAccount("You y" , 500.0);
                    System.out.println("Account 1 inoformation: ");
                    account1.displayAcc();
                    System.out.println("Account 2 inoformation: ");
                    account2.displayAcc();
                    account1.deposit(200.0);
                    account1.withdraw(50.0);

                    account2.deposit(100.0);
                    account2.withdraw(70.0);
                    System.out.println("Update account 1 inform:");
                    account1.displayAcc();
                    System.out.println("Update account 2 inform:");
                    account2.displayAcc();
                    BankAccount.displayTotalacc();
                    break;

                case 3:

                    Scanner scan = new Scanner(System.in);
                    SMSlist smsList = new SMSlist();

                    int choice;
                    do {
                        System.out.println("\nMenu:");
                        System.out.println("1. Send new SMS with Encrypted content");
                        System.out.println("2. View SMS detail");
                        System.out.println("3. List SMSes");
                        System.out.println("4. Remove SMSes by index");
                        System.out.println("5. Quit");

                        System.out.print("Enter your choice: ");
                        choice = scan.nextInt();

                        switch (choice) {
                            case 1:
                                smsList.sendNewSMS(smsList, scan);
                                break;
                            case 2:
                                smsList.viewSMSDetail(smsList, scan);
                                break;
                            case 3:
                                smsList.displaySMSList();
                                break;
                            case 4:
                                smsList.removeSMSByIndex(smsList, scan);
                                break;
                            case 5:
                                System.out.println("Quitting the program. Goodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                    } while (choice != 5);


                    break;

                case 4:
                    Circles circle = new Circles(5);
                    circle.displayShape();

                    Rectangles rectangles = new Rectangles(5, 10);
                    rectangles.displayShape();

                    Triangle triangle = new Triangle(5, 10, 5, 5);
                    triangle.displayShape();

                    break;

                case 5:

                    Scanner scannerr = new Scanner(System.in);
                    ArrayList<BankAccounts> accounts = new ArrayList<>();
                    // Create at least two BankAccount objects
                    BankAccounts bankAccounts = new BankAccounts("123456789", "John Doe", "1234", 1000.0);
                    BankAccounts bankAccounts1 = new BankAccounts("987654321", "Jane Smith", "5678", 1500.0);

                    // Add BankAccount objects to the ArrayList
                    accounts.add(bankAccounts);
                    accounts.add(bankAccounts1);

                    // ATM Simulator
                    boolean exit = false;
                    BankAccounts currentAccount = null;

                    while (!exit) {
                        System.out.println("\nATM Simulator Menu:");
                        System.out.println("1. Login");
                        System.out.println("2. Exit");
                        int chhoice = scannerr.nextInt();
                        switch (chhoice) {
                            case 1:
                                currentAccount = BankAccounts.login(accounts);
                                if (currentAccount != null) {
                                    BankAccounts.performATMOperations(currentAccount, scannerr);
                                }
                                break;
                            case 2:
                                exit = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }

                    System.out.println("Thank you for using the ATM Simulator!");

                    break;

                case 6:
                    System.out.println("Goodbye!.");

                    break;

                default:
                    System.out.println("Invalid choice");
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (choicee != 5);

    }
}


