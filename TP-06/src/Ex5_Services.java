import java.util.ArrayList;
import java.util.Scanner;

public class Ex5_Services {
    private ArrayList<Ex5_Product_Inventory> product = new ArrayList<Ex5_Product_Inventory>();
    Scanner scanner = new Scanner(System.in);

    public Ex5_Services(){
        // default gift inventory
        addProduct("1", "Chocolate", 3.99, 1000);
        addProduct("2", "Flower", 5.99, 1000);
        addProduct("3", "Teddy Bear", 7.99, 250);
        addProduct("4", "Lollipop", 1.99, 1000);
        addProduct("5", "Candy", 0.99, 400);
        addProduct("6", "Cake", 9.99, 100);
        addProduct("7", "Ice Cream", 2.99, 1000);
    }

    public void addProduct(){
        String ID, name;
        double price;
        int quantity;
        System.out.println("--------------------------");
        System.out.print("Enter product ID: ");
        ID = scanner.nextLine();
        System.out.print("Enter product name: ");
        name = scanner.nextLine();
        System.out.print("Enter product price: ");
        price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        quantity = scanner.nextInt();
        scanner.nextLine();
        product.add(new Ex5_Product_Inventory(ID, name, price, quantity));
        System.out.println("Product added successfully!");
        System.out.println("--------------------------");
    }

    public void addProduct(String ID, String name, double price, int quantity){
        product.add(new Ex5_Product_Inventory(ID, name, price, quantity));
    }

    public void showAllProduct(){
        System.out.println("--------------------------");
        System.out.println("Product Inventory");
        System.out.println("--------------------------");
        System.out.printf("%-10s%-20s%-10s%-10s\n", "ID", "Name", "Price", "Quantity");
        for (Ex5_Product_Inventory product : product) {
            System.out.printf("%-10s%-20s%-10.2f%-10d\n", product.getID(), product.getName(), product.getPrice(), product.getQuantity());
        }
        System.out.println("--------------------------");
    }

    public void removeProductByIndex(int index){
        product.remove(index);
        System.out.println("--------------------------");
        System.out.println("Product removed successfully!");
        System.out.println("--------------------------");
    }

    public void updateProductPrice(String ID, double price){
        for (Ex5_Product_Inventory product : product) {
            if (product.getID().equals(ID)) {
                product.setPrice(price);
            }
        }
    }

    public void updateProductQuantity(String ID, int quantity){
        for (Ex5_Product_Inventory product : product) {
            if (product.getID().equals(ID)) {
                product.setQuantity(quantity);
            }
        }
    }
}
