public class PalindromeMaker {
    public static String makePalindrome(String input) {
        StringBuilder reverseCopy = new StringBuilder(input).reverse();
        String palindrome = input + reverseCopy.toString();
        return palindrome;
    }
}
