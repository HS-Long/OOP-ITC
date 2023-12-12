package Product_Management_System;

public class Product {
    private String productName, productID;
    private double unitPrice;
    private int quantityInStock;

    public Product(String productName, String productID, double unitPrice, int quantityInStock) {
        this.productName = productName;
        this.productID = productID;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    public void displayInfo(){
        System.out.println("Product name: " + productName);
        System.out.println("Product ID: " + productID);
        System.out.println("Unit price: " + unitPrice);
        System.out.println("Quantity in stock: " + quantityInStock);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
