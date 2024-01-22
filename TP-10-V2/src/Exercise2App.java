import java.util.Scanner;

public class Exercise2App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Exercise2 vehicleTypeManager = new Exercise2();

        do {
            System.out.println("Vehicle_Type Management System");
            System.out.println("1. Add Vehicle Type");
            System.out.println("2. List Vehicle Types");
            System.out.println("3. Remove Vehicle Type");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter vehicle type ID: ");
                        int typeId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter vehicle type name: ");
                        String typeName = scanner.nextLine();
                        vehicleTypeManager.addVehicleType(new VehicleType(typeId, typeName));
                        System.out.println("Vehicle type added successfully.");
                        break;
                    case 2:
                        Exercise2.listVehicleTypes();
                        break;
                    case 3:
                        System.out.print("Enter vehicle type ID to remove: ");
                        int typeId1 = scanner.nextInt();
                        vehicleTypeManager.deleteVehicleType(typeId1);
                        System.out.println("Vehicle type removed successfully.");
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
