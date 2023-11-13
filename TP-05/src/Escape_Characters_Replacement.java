public class Escape_Characters_Replacement {
    public static String replaceEscapeCharacters(String sentence) {
        sentence = sentence.replaceAll("\\\\n", "(new_line)")
                .replaceAll("\\\\t", "(tab)")
                .replaceAll("\\\\\\\\", "(slash)")
                .replaceAll("//", "(comment_line)")
                .replaceAll(":\\)", "(smile)");

        return sentence;
    }
}
