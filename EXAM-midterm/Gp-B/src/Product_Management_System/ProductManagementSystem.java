package Product_Management_System;

import java.util.Scanner;

public class ProductManagementSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Product Management System!");
        Scanner scanner = new Scanner(System.in);
        int choice;
        Inventory inventory = new Inventory();

        do{
            System.out.println("-----------------------------------");
            System.out.println("1. Add a new product");
            System.out.println("2. Update a product information");
            System.out.println("3. Delete a product");
            System.out.println("4. Display all products");
            System.out.println("5. Sell a product");
            System.out.println("6. Restock a product");
            System.out.println("7. Exit");

            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    inventory.addProduct();
                    break;
                case 2:
                    System.out.println("-----------------------------------");
                    System.out.println("Update product information");
                    System.out.print("Please enter the product code: ");
                    String productCode = scanner.nextLine();
                    System.out.print("Please enter the new unit price: ");
                    double unitPrice = scanner.nextDouble();
                    inventory.updateProductInfo(productCode, unitPrice);
                    break;
                case 3:
                    System.out.println("-----------------------------------");
                    System.out.println("Delete a product");
                    System.out.print("Please enter the product code: ");
                    productCode = scanner.nextLine();
                    inventory.deleteProduct(productCode);
                    break;
                case 4:
                    System.out.println("-----------------------------------");
                    System.out.println("Display all products");
                    inventory.displayAllProducts();
                    break;
                case 5:
                    System.out.println("-----------------------------------");
                    System.out.println("Sell a product");
                    System.out.print("Please enter the product code: ");
                    productCode = scanner.nextLine();
                    System.out.print("Please enter the quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.sellProduct(productCode, quantity);
                    break;
                case 6:
                    System.out.println("-----------------------------------");
                    System.out.println("Restock a product");
                    System.out.print("Please enter the product code: ");
                    productCode = scanner.nextLine();
                    System.out.print("Please enter the quantity: ");
                    quantity = scanner.nextInt();
                    inventory.restockProduct(productCode, quantity);
                    break;
                case 7:
                    System.out.println("-----------------------------------");
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (choice != 7);
    }
}
