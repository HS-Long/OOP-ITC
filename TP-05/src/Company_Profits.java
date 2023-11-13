import java.util.Scanner;

public class Company_Profits {
    Scanner scanner = new Scanner(System.in);
    public static void calculateProfits() {
        double[] profits = new double[12];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < profits.length; i++) {
            System.out.println("Enter the profit for month " + (i + 1) + ": ");
            profits[i] = scanner.nextDouble();
        }

        double totalProfits = 0;
        for (double profit : profits) {
            totalProfits += profit;
        }

        System.out.println("Total profits for 12 months: " + totalProfits);
    }
}


