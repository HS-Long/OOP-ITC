public class Question {
    private String text;
    private String optA;
    private String optB;
    private String correctAns;

    public Question(String text, String optA, String optB, String correctAns) {
        this.text = text;
        this.optA = optA;
        this.optB = optB;
        this.correctAns = correctAns;
    }

    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAns);
    }

    public String getText() {
        return text;
    }
}
