package AmazingBee;

public class AmazingBee {
    private long maleBees = 0;
    private long femaleBees = 1;

    public void calculateBee(int n_Years) {
        for (int i = 0; i < n_Years; i++) {
            long newMaleBees = femaleBees + maleBees;
            long newFemaleBees = maleBees + 1;
            maleBees = newMaleBees;
            femaleBees = newFemaleBees;
        }
    }

    public AmazingBee() {
        System.out.println("Welcome to the Amazing Bee!");
        System.out.print("Please enter the number of years: ");
        int n_Years = new java.util.Scanner(System.in).nextInt();
        calculateBee(n_Years);
        System.out.println("Number of female bees: " + femaleBees);
        System.out.println("Total number of bees: " + (maleBees + femaleBees));
    }

    public static void main(String[] args) {
        new AmazingBee();
    }
}
