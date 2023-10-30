import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
                System.out.println("++++++++++++++++++++TP-3.1+++++++++++++++++");

            Scanner Input = new Scanner(System.in);
                System.out.println("Input Seconde: ");
                int Second = Input.nextInt();
                int hour = Second / 3600;
                int minute = Second % 3600 / 60;
                Second = Second % 60;
                System.out.println("Time is: " + hour + ":" + minute + ":" + Second);

                System.out.println("++++++++++++++++++++TP-3.2+++++++++++++++++");

                System.out.println("Program for converting time to seconds.");
                System.out.println("Pleas Input Hour");
                int Hour = Input.nextInt();
                System.out.println("Pleas Input Minute");
                int Minute = Input.nextInt();
                System.out.println("Pleas Input Second");
                int Seconds = Input.nextInt();
                int total = Hour * 3600 + Minute * 60 + Seconds;
                System.out.println("The second is: " +total);

                System.out.println("++++++++++++++++++++TP-3.3+++++++++++++++++");

                System.out.println("Program for calculating cost of a call.");
                System.out.println("Please input start hours: ");
                int StHours = Input.nextInt();
                System.out.println("Please input start minutes: ");
                int StMinutes = Input.nextInt();
                System.out.println("Please input start seconds: ");
                int StSeconds = Input.nextInt();

                System.out.println("Please input End hours: ");
                int EndHours = Input.nextInt();
                System.out.println("Please input End minutes: ");
                int EndMinutes = Input.nextInt();
                System.out.println("Please input End seconds: ");
                int EndSeconds = Input.nextInt();

                int totalCallDurationSeconds = (EndHours - StHours) * 3600 + (EndMinutes - StMinutes) * 60 + (EndSeconds - StSeconds);
                int totalhours = totalCallDurationSeconds / 3600;
                int totalCallDurationMinutes = totalCallDurationSeconds / 60;
                double totalCallCost = totalCallDurationMinutes * 0.05;

                System.out.println("Total call duration: " + totalhours + "h " + (totalCallDurationMinutes % 60) + "mn " + (totalCallDurationSeconds % 60) + "s");
                System.out.println("Total cost of this call: $" + totalCallCost);

                System.out.println("++++++++++++++++++++TP-3.4+++++++++++++++++");

                System.out.println("Program for converting money in Riels to Dollars.");
                System.out.println("Please input USD: ");
                float USD = Input.nextFloat();
                float convert_usd = USD * 4000 ;
                System.out.println("Conversion rate is: " + USD + " = " + convert_usd + "RIELS");
                System.out.println("Pleas input money in Riels: ");
                float Riels = Input.nextFloat();
                float convert_Riels = Riels / 4000;
                System.out.println(Riels + " RIELS = " + convert_Riels + " USD");

                System.out.println("++++++++++++++++++++TP-3.5+++++++++++++++++");

                System.out.println("Program for calculating duration of travel from ITC to Airport.");
                int distance = 7;
                int speed = 30;
                System.out.println("Please input traffic jam factor (in percentage [0-100]): ");
                int traffic_jam = Input.nextInt();
                double adjspeed = speed - (speed * (traffic_jam / 100));
                double duration = 2*(distance / adjspeed);
                int hours = (int) duration;
                int minutes = (int) ((duration - hours) * 60);
                int seconds = (int) (((duration - hours) * 60 - minutes) * 60);
                System.out.println(hours + ":" + minutes + ":" + seconds);

            System.out.println("++++++++++++++++++++TP-3.6+++++++++++++++++");

            System.out.println("Please input a floating-point number: ");
            float flaot_point = Input.nextFloat();
            float integral_part = String.valueOf((int) flaot_point).length();
            String[] num_Parts = String.valueOf(flaot_point).split("\\.");
            float frac_lPartS = num_Parts.length > 1 ? num_Parts[1].length() : 0;
            System.out.println("Number of digits in the integral part: " + integral_part);
            System.out.println("Number of digits in the fractional part: " + frac_lPartS);

            System.out.println("++++++++++++++++++++TP-3.7+++++++++++++++++");

            System.out.print("Enter the text: ");
            String string = Input.nextLine();

            System.out.print("Enter the letter(s) to find in words: ");
            String letters_ToFind = Input.nextLine();


            String[] words = string.split("\\s+|\\p{Punct}");

            ArrayList<String> wordsWithLetters = new ArrayList<>();
            for (String word : words) {
                for (char letter : letters_ToFind.toCharArray()) {
                    if (word.toLowerCase().contains(String.valueOf(letter).toLowerCase())) {
                        wordsWithLetters.add(word);
                        break;
                    }
                }
            }
            System.out.println("List of words containing letter(s) " + letters_ToFind + ":");
            System.out.print("|");
            for (String word : wordsWithLetters) {
                System.out.print(word + "|");
            }
            System.out.println();
            System.out.println("There are " + wordsWithLetters.size() + " word(s) containing letter(s) \"" + letters_ToFind + "\"");
        }
    }
}
