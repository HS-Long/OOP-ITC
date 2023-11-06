import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int chose;
        do {
            System.out.println("Wellcome to program Money Excheng!. ");
            System.out.println("1. Reila to dollar.");
            System.out.println("2. Reils to thaibaht.");
            System.out.println("3. Dollar to reils.");
            System.out.println("4. Dollar to thaibaht.");
            System.out.println("5. Thaibaht to Reils");
            System.out.println("6.Exit");
            chose = input.nextInt();
            switch (chose){
                case 1:
                    System.out.println("Input money in Reils: ");
                    double reilsAmount = input.nextDouble();
                    Riel riel = new Riel(reilsAmount);
                    System.out.printf("%.2f Reils = %.2f USD%n", reilsAmount, riel.todollar());
                case 2:
                    System.out.print("Input money in RIELS: ");
                    double rielsAmount2 = input.nextDouble();
                    Riel riels2 = new Riel(rielsAmount2);
                    System.out.printf("%.2f RIELS = %.2f Thai Baht%n", rielsAmount2, riels2.tothainath());
                    break;
                case 3:
                    System.out.print("Input money in Dollars: ");
                    double dollarAmount = input.nextDouble();
                    Dollar dollar = new Dollar(dollarAmount);
                    System.out.printf("%.2f USD = %.2f RIELS%n", dollarAmount, dollar.toReils());
                    break;
                case 4:
                    System.out.print("Input money in Dollars: ");
                    double dollarAmount2 = input.nextDouble();
                    Dollar dollar2 = new Dollar(dollarAmount2);
                    System.out.printf("%.2f USD = %.2f Thai Baht%n", dollarAmount2, dollar2.toBaht());
                    break;
                case 5:
                    System.out.print("Input money in Thai Baht: ");
                    double thaiBahtAmount = input.nextDouble();
                    ThaiBaht thaiBaht = new ThaiBaht(thaiBahtAmount);
                    System.out.printf("%.2f Thai Baht = %.2f RIELS%n", thaiBahtAmount, thaiBaht.toReils());
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (chose != 6);
            }

        }

