public class Dollar {
    private double amount;
    Dollar(double amount){
        this.amount = amount;
    }
    double toReils(){
        return amount * 4000;
    }
    double toBaht(){
        return amount * 30;
    }
}
