import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number to check whether it is prime number: ");
        int inputNumber = scanner.nextInt();

        PrimeNumber primeNumber = new PrimeNumber(inputNumber);
        boolean isPrime = primeNumber.isPrime();

        if (isPrime) {
            System.out.println(inputNumber + " is prime number.");
        } else {
            System.out.println(inputNumber + " is not prime number, because it is divisible by other numbers.");
        }
    }
}