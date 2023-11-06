import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program for reversing a 4-digit number.");
        System.out.print("Please input 4 digits number: ");
        int number = scanner.nextInt();
        NumberReversal numberRev = new NumberReversal();
        if (numberRev.isValidNumber(number)) {
            int reversedNumber = numberRev.reverseNumber(number);
            System.out.println("After reverse: " + reversedNumber);
        } else {
            System.out.println("Error: invalid number, please input only 4 digits number.");
        }
    }
}