import java.util.Scanner;

public class Exercise5 {
    Scanner scanner = new Scanner(System.in);
    Ex5_Services Ex5 = new Ex5_Services();
    public int choice;

    public Exercise5() {
        do {
            System.out.println("1. Show all product");
            System.out.println("2. Add new product");
            System.out.println("3. Remove product by index");
            System.out.println("4. Update product price by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Ex5.showAllProduct();
                    break;
                case 2:
                    Ex5.addProduct();
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    Ex5.removeProductByIndex(index);
                    break;
                case 4:
                    do {
                        System.out.println("--------------------------");
                        System.out.println("To update product price, Please input 1\nTo update product quantity, Please input 2");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.print("Enter product ID: ");
                                String ID = scanner.nextLine();
                                System.out.print("Enter new price: ");
                                double price = scanner.nextDouble();
                                Ex5.updateProductPrice(ID, price);
                                System.out.println("--------------------------");
                                break;
                            case 2:
                                System.out.print("Enter product ID: ");
                                String ID1 = scanner.nextLine();
                                System.out.print("Enter new quantity: ");
                                int quantity = scanner.nextInt();
                                Ex5.updateProductQuantity(ID1, quantity);
                                System.out.println("--------------------------");
                                break;
                            default:
                                System.out.println("--------------------------");
                                System.out.println("Invalid choice!");
                                System.out.println("--------------------------");
                                break;
                        }
                    } while (choice != 1 && choice != 2);
                    break;
                case 0:
                    System.out.println("--------------------------");
                    System.out.println("Goodbye!");
                    System.out.println("--------------------------");
                    break;
                default:
                    System.out.println("--------------------------");
                    System.out.println("Invalid choice!");
                    System.out.println("--------------------------");
                    break;
            }
        } while (choice != 0);
    }
}
