package Product_Management_System;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    ArrayList<Product> products = new ArrayList<Product>();
    Scanner scanner = new Scanner(System.in);

    public Inventory(){
        addProduct("Apple", "001", 1.5, 100);
        addProduct("Banana", "002", 2.5, 100);
        addProduct("Orange", "003", 3.5, 100);
        addProduct("Pineapple", "004", 4.5, 100);
        addProduct("Watermelon", "005", 5.5, 100);
        addProduct("Mango", "006", 6.5, 100);
        addProduct("Strawberry", "007", 7.5, 100);
        addProduct("Grape", "008", 8.5, 100);
    }
    public void addProduct() {
        System.out.println("-----------------------------------");
        System.out.println("Add product");
        System.out.println("please enter the product information");
        System.out.print("Product name: ");
        String productName = scanner.nextLine();
        System.out.print("Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Unit price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Quantity in stock: ");
        int quantityInStock = scanner.nextInt();
        Product product = new Product(productName, productID, unitPrice, quantityInStock);
        products.add(product);
    }

    public void addProduct(String productName, String productID, double unitPrice, int quantityInStock) {
        Product product = new Product(productName, productID, unitPrice, quantityInStock);
        products.add(product);
    }

    public void updateProductInfo(String productCode, double unitPrice){
        boolean found = false;
        for (Product product : products) {
            if (product.getProductID().equals(productCode)) {
                product.setUnitPrice(unitPrice);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(String productCode){
        boolean found = false;
        for (Product product : products) {
            if (product.getProductID().equals(productCode)) {
                products.remove(product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }

    public void displayAllProducts(){
        System.out.println("-----------------------------------");
        System.out.println("Display all products");
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Product name", "Product ID", "Unit price", "Quantity in stock");
        for (Product product : products) {
            System.out.printf("%-20s%-20s%-20s%-20s\n", product.getProductName(), product.getProductID(), product.getUnitPrice(), product.getQuantityInStock());
        }
    }

    public void sellProduct(String productCode, int quantity){
        boolean found = false;
        for (Product product : products) {
            if (product.getProductID().equals(productCode)) {
                if (product.getQuantityInStock() >= quantity) {
                    product.setQuantityInStock(product.getQuantityInStock() - quantity);
                    found = true;
                    break;
                } else {
                    System.out.println("Not enough quantity");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }

    public void restockProduct(String productCode, int quantity){
        boolean found = false;
        for (Product product : products) {
            if (product.getProductID().equals(productCode)) {
                product.setQuantityInStock(product.getQuantityInStock() + quantity);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }
}
