import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Maxnum = Integer.MIN_VALUE;
        System.out.println("Please Enter 8 integers: ");
        for( int i = 0 ; i < 8 ; i++){
            int number = input.nextInt();
            if (number > Maxnum){
                Maxnum = number;
            }
        }
        System.out.println("The maximum is: " + Maxnum);
    }
}