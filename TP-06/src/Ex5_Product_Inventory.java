public class Ex5_Product_Inventory {
    private String ID;
    private String name;
    private double price;
    private int quantity;

    public Ex5_Product_Inventory(String ID, String name, double price, int quantity){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
