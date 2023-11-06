import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a year: ");
        int year =scan.nextInt();
        if(year <1){
            System.out.println("Error please input again!.");
        }
        else{
            boolean Isleapyear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 4 == 0);
            if (Isleapyear) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }

    }
}