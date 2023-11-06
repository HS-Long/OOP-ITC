import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            System.out.println("Program for testing for lucky number.");
            System.out.println("Please input 6 digits number: ");
            int inputnum = input.nextInt();
            LuckyNumber luckynum = new LuckyNumber(inputnum);

            if (luckynum.isvalid()) {
                if (luckynum.isLucky()) {
                    System.out.println(inputnum + " is lucky number");

                } else {
                    System.out.println(inputnum + " is not lucky number");
                }
            } else {
                System.out.println("Invalid input number, please input only 6 digits number.");
            }
            input.close();


    }
}