import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("What is your Name?");
        String name = input.nextLine();
        System.out.println("Hi My name is " + name);

        System.out.println("-------------------------------------------------");

        System.out.println("What is your favorite subject?");
        String subject = input.nextLine();
        System.out.println("My favorite subject is " + subject);

        System.out.println("-------------------------------------------------");

        System.out.println("Pleas Enter Number1: ");
        int number1 = input.nextInt();
        System.out.println("Pleas Enter Number2:");
        int number2 = input.nextInt();
        int result = number1 + number2;
        System.out.println("The result is " + result);

        System.out.println("TP2.1 -------------------------------------------------");

        Scanner scan = new Scanner(System.in);
        System.out.println("input your name: ");
        String Name = scan.nextLine();
        System.out.println("Hello" + " " + Name +"!");

        System.out.println("TP2.2 -------------------------------------------------");

        System.out.println("Program for calculating perimeter and surface of a Rectangle.");
        System.out.println("Please input width (in meter): ");
        int width = scan.nextInt();
        System.out.println("Please input height (in meter): ");
        int height = scan.nextInt();
        int Perimeter = (width + height) * 2;
        int surface = width * height;
        System.out.println("The result of Perimeter is: " + Perimeter +"m");
        System.out.println("The result of surface is: " + surface +"m^2");

        System.out.println("TP2.3 -------------------------------------------------");
        System.out.println("Program for calculating equation 1/x = 1/y + 1/z");
        System.out.println("Please Input y: ");
        float y = scan.nextFloat();
        System.out.println("Please input z: ");
        float z = scan.nextFloat();
        float results = (y*z)/(y+z);
        System.out.println("Result x = " + results);

        System.out.println("TP2.4 -------------------------------------------------");
        System.out.println("Program for counting the number of hundreds.");
        System.out.println("Please input a positive number: ");
        int Numpositive = scan.nextInt();
        int Hundreds = Numpositive / 100;
        System.out.println("There are " + Hundreds + " in number " + Numpositive + ".");


        System.out.println(" TP2.5 -------------------------------------------------");
        System.out.println("Program for counting the number of hundreds.");
        System.out.println("Pleas Input a positive number: ");
        int positiveNum = scan.nextInt();
        int total = positiveNum + 1;
        System.out.println("I got " + total + "." + " I am luckier.");
        for (int i = 0; i < 3; i++) {

            System.out.println(" TP2.6-A-------------------------------------------------");
            System.out.print("Enter the start number: ");
            int start = scan.nextInt();

            System.out.print("Enter the end number: ");
            int end = scan.nextInt();

            System.out.print("Enter the increment: ");
            int increment = scan.nextInt();

            // Calculate the number of terms in the sequence
            int numberOfTerms = ((end - start) / increment) + 1;

            // Calculate the summation without using a loop
            int summation = (numberOfTerms * (2 * start + (numberOfTerms - 1) * increment)) / 2;

            // Output the result
            System.out.println("The summation is: " + summation);
        }
    }
}