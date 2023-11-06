import java.util.Scanner;

public class PrimeNumber {
    private int number;

    public PrimeNumber(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
