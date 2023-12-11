public class Purchase {
    private double cost;

    public Purchase(double cost) {
        this.cost = cost;
    }


    public double getDiscount() {
        if (cost >= 300) return 0.25 * cost;
        else if (cost >= 150) return 0.2 * cost;
        else if (cost >= 80) return 0.15 * cost;
        else if (cost >= 30) return 0.1 * cost;
        else if (cost >= 20) return 2;
        else return 0;
    }

    public double getTotal() {
        return cost - getDiscount();
    }
}
