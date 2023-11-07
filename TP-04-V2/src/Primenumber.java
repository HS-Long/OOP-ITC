import java.util.Scanner;

class checkprime {

    private int number;

    public checkprime(int number) {
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


