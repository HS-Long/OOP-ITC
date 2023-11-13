public class Palindrome {

        public static boolean UsingReverse(String str) {
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equalsIgnoreCase(reversed);
        }
        public static boolean UsingLoop(String str) {
            int length = str.length();
            for (int i = 0; i < length / 2; i++) {
                if (str.charAt(i) != str.charAt(length - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }


