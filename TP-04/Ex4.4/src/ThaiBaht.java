public class ThaiBaht {
    private double amount;
    ThaiBaht(double amount){
        this.amount = amount;
    }
    double toReils(){
        return amount * 30;
    }
    double toDollar(){
        return amount / 30;
    }
}
