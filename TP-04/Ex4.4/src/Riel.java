public class Riel {
    private double amount;
    Riel (double amount){
        this.amount = amount;
    }
    double todollar(){
        return amount / 4000;
    }
    double tothainath(){
        return amount / 30;
    }
}
