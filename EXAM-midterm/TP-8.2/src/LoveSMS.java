
import java.util.Scanner;
        public class LoveSMS {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Scanner scanner = new Scanner(System.in);
                System.out.println("The number of sentences input is 3 line ");
                System.out.print("Enter line 1 of message to send: ");
                String line1 = scanner.nextLine();
                System.out.print("Enter line 2 of message to send: ");
                String line2 = scanner.nextLine();
                System.out.print("Enter line 3 of message to send: ");
                String line3 = scanner.nextLine();

                System.out.print("Translated Line 1: ");
                for (int i = 0; i < line1.length(); i++) {
                    char letter1 = line1.charAt(i);
                    if (letter1 != ' ' && letter1 != '.') {
                        System.out.print((char) (letter1 + 3));
                    } else {
                        System.out.print(letter1);
                    }
                }
                System.out.print("Translated Line 2: ");
                for (int i = 0; i < line2.length(); i++) {
                    char letter2 = line2.charAt(i);
                    if (letter2 != ' ' && letter2 != '.') {
                        System.out.print((char) (letter2 + 3));
                    } else {
                        System.out.print(letter2);
                    }
                }
                System.out.print("Translated Line 3: ");
                for (int i = 0; i < line3.length(); i++) {
                    char letter3 = line3.charAt(i);
                    if (letter3 != ' ' && letter3 != '.') {
                        System.out.print((char) (letter3 + 3));
                    } else {
                        System.out.print(letter3);
                    }
                }
                scanner.close();
            }

        }
