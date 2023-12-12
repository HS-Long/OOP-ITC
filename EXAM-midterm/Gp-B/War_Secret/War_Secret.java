package War_Secret;

import java.util.Scanner;

public class War_Secret {
    public int n_Lines;
    private String sentence;
    Scanner sc = new Scanner(System.in);

    public War_Secret() {
        System.out.println("Welcome to the War Secret!");
        System.out.print("Please enter the number of lines: ");
        n_Lines = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n_Lines; i++) {
            System.out.print("Please enter the sentence: ");
            this.sentence = sc.nextLine();
            Sentence sentence = new Sentence(this.sentence);
            sentence.encrypt(sentence.getWords());
            System.out.println(sentence.encryptedString(sentence.getWords()));
        }
    }

    public static void main(String[] args) {
        new War_Secret();
    }
}
