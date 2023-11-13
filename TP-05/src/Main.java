import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Welcome to My Project!");
            System.out.println("1. Primenumber.");
            System.out.println("2. Odd_Numbers.");
            System.out.println("3. Even_Numbers.");
            System.out.println("4. Company_Profits.");
            System.out.println("5. Palindrome.");
            System.out.println("6. String_Mirroring");
            System.out.println("7. Escape Characters Replacement.");
            System.out.println("8. Exit.");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:

                    Scanner scanner1 = new Scanner(System.in);
                    Primenumber primenumber = new Primenumber();
                    System.out.println("Input number to list prime numbers from 2 to itInput number to list prime numbers from 2 to it: ");
                    int intput_number = scanner1.nextInt();
                    Primenumber.ListPrime(intput_number);

                    break;

                case 2:

                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Please input start number: ");
                    int start_number = scanner2.nextInt();
                    System.out.println("Please input end number: ");
                    int end_number = scanner2.nextInt();
                    Odd_number.print_odd(start_number, end_number);
                    break;

                case 3:

                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Please input start number: ");
                    int startt_number = scanner3.nextInt();
                    System.out.println("Please input end number: ");
                    int endd_number = scanner3.nextInt();
                    Even_number.print_even(startt_number, endd_number);
                    break;

                case 4:

                    Company_Profits companyProfits = new Company_Profits();
                    companyProfits.calculateProfits();
                    break;

                case 5:

                    Scanner scanner4 = new Scanner(System.in);

                    System.out.print("Please enter a word to check: ");
                    String input = scanner4.nextLine();

                    System.out.print("Choose method (REV, LOOP): ");
                    String method = scanner4.nextLine().toUpperCase();

                    if (method.equals("REV")) {
                        if (Palindrome.UsingReverse(input)) {
                            System.out.println(input + " is a Palindrome.");
                        } else {
                            System.out.println(input + " is not a Palindrome.");
                        }
                    } else if (method.equals("LOOP")) {
                        if (Palindrome.UsingLoop(input)) {
                            System.out.println(input + " is a Palindrome.");
                        } else {
                            System.out.println(input + " is not a Palindrome.");
                        }
                    } else {
                        System.out.println("Invalid method choice. Please choose either REV or LOOP.");
                    }
                    break;

                case 6:

                    Scanner scanner5 = new Scanner(System.in);
                    System.out.print("Please enter a word: ");
                    String userInput = scanner5.nextLine();
                    String result = PalindromeMaker.makePalindrome(userInput);
                    System.out.println("Palindrome: " + result);
                    break;

                case 7:

                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Please enter a sentence: ");
                    String inputSentence = scanner.nextLine();
                    String replacedSentence = Escape_Characters_Replacement.replaceEscapeCharacters(inputSentence);
                    System.out.println(replacedSentence);
                    break;

                case 8:
                    System.out.println("Good Bye!.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (choice != 8);

    }
}





















