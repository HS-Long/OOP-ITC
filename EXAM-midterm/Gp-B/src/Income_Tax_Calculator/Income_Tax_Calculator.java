package Income_Tax_Calculator;

import java.util.Scanner;

public class Income_Tax_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Income Tax Calculator!");
        double income;

        do{
            System.out.println("-----------------------------------");
            System.out.print("Please enter your income: ");
            income = sc.nextDouble();
            if (income < 0) {
                System.out.println("Invalid income");
            } else {
                printDetail(income);
            }
        }while (true);
    }

    public static double taxAmt(double income) {
        double tax = 0;
        if (income <= 1500000) {
            tax = 0;
        } else if (income <= 2000000) {
            tax = (income - 1500000) * 0.05;
        } else if (income <= 8500000) {
            tax = (income - 2000000) * 0.1;
        } else if (income <= 12500000) {
            tax = (income - 8500000) * 0.15;
        } else {
            tax = (income - 12500000) * 0.2;
        }
        return tax;
    }

    public static double amtAfterTax(double income) {
        double amt = income - taxAmt(income);
        return amt;
    }

    public static String taxPercentage(double income) {
        if (income <= 1500000) {
            return "Tax percentage: 0%";
        } else if (income <= 2000000) {
            return "Tax percentage: 5%";
        } else if (income <= 8500000) {
            return "Tax percentage: 10%";
        } else if (income <= 12500000) {
            return "Tax percentage: 15%";
        } else {
            return "Tax percentage: 20%";
        }
    }

    public static void printDetail(double income) {
        System.out.println("-----------------------------------");
        System.out.println("Income: " + income);
        System.out.println("Tax amount: " + taxAmt(income));
        System.out.println(taxPercentage(income));
        System.out.println("Amount after tax: " + amtAfterTax(income));
        System.out.println("-----------------------------------");
    }
}
