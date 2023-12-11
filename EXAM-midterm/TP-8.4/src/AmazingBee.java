
import java.util.Scanner;

        public class AmazingBee {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int years;

                do {
                    System.out.print("Enter the number of years (0 to 30, -1 to exit): ");
                    years = scanner.nextInt();

                    if (years != -1) {
                        long[] result = calculateBeesAfterNYears(years);
                        System.out.println("Number of males: " + result[0]);
                        System.out.println("Total number of bees: " + result[1]);
                    }

                } while (years != -1);

                System.out.println("Exiting the program.");
                scanner.close();
            }

            private static long[] calculateBeesAfterNYears(int n) {
                if (n == 0) {
                    return new long[]{0, 1}; // Initial condition when N is 0
                }

                long maleBees = 1;
                long femaleBees = 0;

                for (int i = 1; i <= n; i++) {
                    long newFemaleBees = femaleBees + 1;
                    long newMaleBees = maleBees + femaleBees;

                    maleBees = newMaleBees;
                    femaleBees = newFemaleBees;
                }

                return new long[]{maleBees, maleBees + femaleBees};
            }
        }

