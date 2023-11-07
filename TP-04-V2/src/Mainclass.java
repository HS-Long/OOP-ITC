import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Welcome to My Project!");
            System.out.println("1. Primenumeber.");
            System.out.println("2. LuckyNumber.");
            System.out.println("3. Reversnumber.");
            System.out.println("4. MoneyXcheng.");
            System.out.println("5. Maximumnumber");
            System.out.println("6. Leapyear");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch(choice) {
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Input number to check whether it is a prime number: ");
                    int inputNumber = scanner.nextInt();

                    checkprime primeNumber = new checkprime(inputNumber);
                    boolean isPrime = primeNumber.isPrime();

                    if (isPrime) {
                        System.out.println(inputNumber + " is a prime number.");
                    } else {
                        System.out.println(inputNumber + " is not a prime number, because it is divisible by other numbers.");
                    }

                    break;

                case 2:
                    Scanner input = new Scanner(System.in);
                    System.out.println("Program for testing for lucky number.");
                    System.out.println("Please input 6 digits number: ");
                    int inputnum = input.nextInt();
                    Luckynumber luckynum = new Luckynumber(inputnum);

                    if (luckynum.isvalid()) {
                        if (luckynum.isLucky()) {
                            System.out.println(inputnum + " is lucky number");

                        } else {
                            System.out.println(inputnum + " is not lucky number");
                        }
                    } else {
                        System.out.println("Invalid input number, please input only 6 digits number.");
                    }
                    break;

                case 3:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Program for reversing a 4-digit number.");
                    System.out.print("Please input 4 digits number: ");
                    int number = sc.nextInt();
                    NumberReversal numberRev = new NumberReversal();
                    if (numberRev.isValidNumber(number)) {
                        int reversedNumber = numberRev.reverseNumber(number);
                        System.out.println("After reverse: " + reversedNumber);
                    } else {
                        System.out.println("Error: invalid number, please input only 4 digits number.");
                    }
                    break;

                case 4:
                    Scanner scann = new Scanner(System.in);
                    int chose;
                    do {
                        System.out.println("Welcome to the Money Exchange Program!");
                        System.out.println("1. Riels to Dollars");
                        System.out.println("2. Riels to Thai Baht");
                        System.out.println("3. Dollars to Riels");
                        System.out.println("4. Dollars to Thai Baht");
                        System.out.println("5. Thai Baht to Riels");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");
                        chose = scann.nextInt();

                        switch (chose){
                            case 1:
                                System.out.print("Input money in Riels: ");
                                double reilsAmount = scann.nextDouble();
                                MoneyXcheng.Riel riels = new MoneyXcheng().new Riel(reilsAmount);
                                System.out.printf("%.2f Riels = %.2f USD%n", reilsAmount, riels.todollar());
                                break;
                            case 2:
                                System.out.print("Input money in Riels: ");
                                double rielsAmount2 = scann.nextDouble();
                                MoneyXcheng.Riel riels2 = new MoneyXcheng().new Riel(rielsAmount2);
                                System.out.printf("%.2f Riels = %.2f Thai Baht%n", rielsAmount2, riels2.tothainath());
                                break;
                            case 3:
                                System.out.print("Input money in Dollars: ");
                                double dollarAmount = scann.nextDouble();
                                MoneyXcheng.Dollar dollar = new MoneyXcheng().new Dollar(dollarAmount);
                                System.out.printf("%.2f USD = %.2f Riels%n", dollarAmount, dollar.toReils());
                                break;
                            case 4:
                                System.out.print("Input money in Dollars: ");
                                double dollarAmount2 = scann.nextDouble();
                                MoneyXcheng.Dollar dollar2 = new MoneyXcheng().new Dollar(dollarAmount2);
                                System.out.printf("%.2f USD = %.2f Thai Baht%n", dollarAmount2, dollar2.toBaht());
                                break;
                            case 5:
                                System.out.print("Input money in Thai Baht: ");
                                double thaiBahtAmount = scann.nextDouble();
                                MoneyXcheng.ThaiBaht thaiBaht = new MoneyXcheng().new ThaiBaht(thaiBahtAmount);
                                System.out.printf("%.2f Thai Baht = %.2f Riels%n", thaiBahtAmount, thaiBaht.toReils());
                                break;
                            case 6:
                                System.out.println("Exiting program. Goodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose a valid option.");
                        }
                    } while (chose != 6);
                    break;

                case 5:
                    Scanner scaner = new Scanner(System.in);
                    int[] numbers = new int[8];
                    System.out.println("Please Enter 8 integers: ");
                    for (int i = 0; i < 8; i++) {
                        numbers[i] = scaner.nextInt();
                    }

                    MaxNumberFinder finder = new MaxNumberFinder();
                    int maxNumber = finder.findMaxNumber(numbers);
                    System.out.println("The maximum is: " + maxNumber);
                    break;

                case 6:
                    Scanner scannn = new Scanner(System.in);
                            System.out.print("Enter a year: ");
                            int year = scannn.nextInt();
                            if (Leapyear.isLeapYear(year)) {
                                System.out.println(year + " is a leap year.");
                            } else {
                                System.out.println(year + " is not a leap year.");
                            }
                            break;
                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while(choice != 7);

    }
}