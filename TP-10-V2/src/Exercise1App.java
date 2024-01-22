import java.sql.Date;
import java.util.Scanner;

public class Exercise1App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Exercise1 vehicle = new Exercise1();

        do {
            System.out.println("Vehicle Management System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. List Vehicles");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Remove Vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter vehicle number: ");
                        String vehicleNumber = scanner.nextLine();
                        System.out.println("ID of vehicle type:");
                        Exercise2.listVehicleTypes();
                        System.out.print("Enter vehicle type: ");
                        String vehicleType = scanner.nextLine();
                        System.out.print("Enter year of creation: ");
                        int yearOfCreation = scanner.nextInt();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter date of availability (yyyy-mm-dd): ");
                        String dateStr = scanner.next();
                        Date dateOfAvailability = Date.valueOf(dateStr); // Assumes the date is entered in the format yyyy-mm-dd

                        vehicle = new Exercise1(vehicleNumber, vehicleType, yearOfCreation, price, dateOfAvailability);
                        vehicle.addVehicle();
                        System.out.println("Vehicle added successfully.");
                        break;
                    case 2:
                        if (vehicle != null) {
                            vehicle.listVehicles();
                        } else {
                            System.out.println("No vehicle records available.");
                        }
                        break;
                    case 3: // Update Vehicle
                        System.out.print("Enter vehicle number to update: ");
                        String vehicleNumberToUpdate = scanner.nextLine();
                        boolean isUpdateSuccessful = vehicle.updateVehicle(vehicleNumberToUpdate);
                        if (isUpdateSuccessful) {
                            System.out.println("Vehicle updated successfully.");
                        } else {
                            System.out.println("Vehicle number not found or update failed.");
                        }
                        break;
                    case 4: // Remove Vehicle
                        System.out.print("Enter vehicle number to remove: ");
                        String vehicleNumberToRemove = scanner.nextLine();
                        boolean isRemoveSuccessful = vehicle.removeVehicle(vehicleNumberToRemove);
                        if (isRemoveSuccessful) {
                            System.out.println("Vehicle removed successfully.");
                        } else {
                            System.out.println("Vehicle number not found or remove failed.");
                        }
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
