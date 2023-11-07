import java.util.Scanner;

class MoneyXcheng {

    public class Dollar {
        private double amount;
        Dollar(double amount){
            this.amount = amount;
        }
        double toReils(){
            return amount * 4000;
        }
        double toBaht(){
            return amount * 30;
        }
    }

    public class Riel {
        private double amount;
        Riel(double amount){
            this.amount = amount;
        }
        double todollar(){
            return amount / 4000;
        }
        double tothainath(){
            return amount / 30;
        }
    }

    public class ThaiBaht {
        private double amount;
        ThaiBaht(double amount){
            this.amount = amount;
        }
        double toReils(){
            return amount * 30;
        }
        double toDollar(){
            return amount / 30;
        }
    }
}

 class Main_Money {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int chose;
        do {
            System.out.println("Welcome to the Money Exchange Program!");
            System.out.println("1. Riels to Dollars");
            System.out.println("2. Riels to Thai Baht");
            System.out.println("3. Dollars to Riels");
            System.out.println("4. Dollars to Thai Baht");
            System.out.println("5. Thai Baht to Riels");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            chose = input.nextInt();

            switch (chose){
                case 1:
                    System.out.print("Input money in Riels: ");
                    double reilsAmount = input.nextDouble();
                    MoneyXcheng.Riel riels = new MoneyXcheng().new Riel(reilsAmount);
                    System.out.printf("%.2f Riels = %.2f USD%n", reilsAmount, riels.todollar());
                    break;
                case 2:
                    System.out.print("Input money in Riels: ");
                    double rielsAmount2 = input.nextDouble();
                    MoneyXcheng.Riel riels2 = new MoneyXcheng().new Riel(rielsAmount2);
                    System.out.printf("%.2f Riels = %.2f Thai Baht%n", rielsAmount2, riels2.tothainath());
                    break;
                case 3:
                    System.out.print("Input money in Dollars: ");
                    double dollarAmount = input.nextDouble();
                    MoneyXcheng.Dollar dollar = new MoneyXcheng().new Dollar(dollarAmount);
                    System.out.printf("%.2f USD = %.2f Riels%n", dollarAmount, dollar.toReils());
                    break;
                case 4:
                    System.out.print("Input money in Dollars: ");
                    double dollarAmount2 = input.nextDouble();
                    MoneyXcheng.Dollar dollar2 = new MoneyXcheng().new Dollar(dollarAmount2);
                    System.out.printf("%.2f USD = %.2f Thai Baht%n", dollarAmount2, dollar2.toBaht());
                    break;
                case 5:
                    System.out.print("Input money in Thai Baht: ");
                    double thaiBahtAmount = input.nextDouble();
                    MoneyXcheng.ThaiBaht thaiBaht = new MoneyXcheng().new ThaiBaht(thaiBahtAmount);
                    System.out.printf("%.2f Thai Baht = %.2f Riels%n", thaiBahtAmount, thaiBaht.toReils());
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
