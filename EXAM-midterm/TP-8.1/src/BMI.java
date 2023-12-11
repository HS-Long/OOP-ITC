import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please input weight: ");
            float weight = sc.nextFloat();
            System.out.println("Please input height: ");
            float height = sc.nextFloat();
            float BMI = weight / ((height) * (height));
            if (BMI < 18.5) {
                System.out.printf("%.2f Underweight \n", BMI);
            } else if (BMI < 24.9 && BMI > 18.5) {
                System.out.printf("%.2f Normal weight \n", BMI);
            } else if (BMI < 29.9 && BMI > 25) {
                System.out.printf("%.2f Overweight \n", BMI);
            } else if (BMI > 30) {
                System.out.printf("%.2f Obesity \n", BMI);
            } else {
                System.out.printf("Invalid BMI \n");
            }
        }
    }
}
