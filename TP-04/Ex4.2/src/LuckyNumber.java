public class LuckyNumber {
    private int num;
    public LuckyNumber(int num){
        this.num = num;
    }
    public boolean isLucky() {
        int firstHalf = num / 1000;
        int secondHalf = num % 1000;
        int sumfirstHalf = 0;
        int sumsecondHalf = 0;
        while (firstHalf > 0) {
            sumfirstHalf= sumfirstHalf + firstHalf % 10;
            firstHalf = firstHalf / 10;
        }
        while (secondHalf > 0) {
            sumsecondHalf = sumsecondHalf + secondHalf % 10;
            secondHalf = secondHalf / 10;
        }
        return sumfirstHalf == sumsecondHalf;
    }
    public boolean isvalid(){
        return num >= 100000 && num <= 999999;
    }

}

