package War_Secret;

import java.util.ArrayList;

public class Sentence {
    private String sentence;
    private ArrayList<String> words = new ArrayList<String>();

    public Sentence(String sentence) {
        this.sentence = sentence;
        String[] words = sentence.split(" ");
        for (String word : words) {
            this.words.add(word);
        }
    }

    public void encrypt(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String newWord = "";
            for (int j = 0; j < word.length(); j++) {
                char letter = word.charAt(j);
                if (letter >= 'a' && letter <= 'z') {
                    if (letter == 'a') {
                        letter = ('z');
                    } else if (letter == 'b') {
                        letter = ('y');
                    } else if (letter == 'c') {
                        letter = ('x');
                    } else {
                        letter = (char) (letter - 3);
                    }
                } else if (letter >= 'A' && letter <= 'Z') {
                    if (letter == 'A') {
                        letter = ('Z');
                    } else if (letter == 'B') {
                        letter = ('Y');
                    } else if (letter == 'C') {
                        letter = ('X');
                    } else {
                        letter = (char) (letter - 3);
                    }
                }
                newWord += letter;
            }
            words.set(i, newWord);
        }
    }

    public String encryptedString(ArrayList<String> words) {
        String encryptedString = "";
        for (String word : words) {
            encryptedString += word + " ";
        }
        return encryptedString;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
}
