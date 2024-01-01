import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            VehicleStore vehicleStore = new VehicleStore();

            // Add vehicle types
            VehicleType carType = new VehicleType(0, "Car");
            vehicleStore.addVehicleType(carType);

            VehicleType bikeType = new VehicleType(1, "Bike");
            vehicleStore.addVehicleType(bikeType);

            // List all vehicle types
            List<VehicleType> allVehicleTypes = vehicleStore.listAllVehicleTypes();
            System.out.println("All Vehicle Types:");
            for (VehicleType type : allVehicleTypes) {
                System.out.println(type.getName());
            }

            // Add vehicles
            Vehicle car1 = new Vehicle("Long-7777", carType, 2022, 25000.0, "2023-01-01");
            vehicleStore.addVehicle(car1);

            Vehicle bike1 = new Vehicle("Long-8888", bikeType, 2021, 12000.0, "2023-02-01");
            vehicleStore.addVehicle(bike1);

            Vehicle car2 = new Vehicle("Long-6666", carType, 2024, 35000.0, "2024-01-01");
            vehicleStore.addVehicle(car2);

            Vehicle bike2 = new Vehicle("Long-9999", bikeType, 2024, 42000.0, "2024-02-01");
            vehicleStore.addVehicle(bike2);

            // List all vehicles
            List<Vehicle> allVehicles = vehicleStore.listAllVehicles();
            System.out.println("\nAll Vehicles:");
            for (Vehicle vehicle : allVehicles) {
                System.out.println(vehicle.getVehicleNumber() + " - " + vehicle.getVehicleType().getName());
            }

            // List vehicles in a specific type
            List<Vehicle> carVehicles = vehicleStore.listVehiclesInType(carType.getId());
            System.out.println("\nCar Vehicles:");
            for (Vehicle vehicle : carVehicles) {
                System.out.println(vehicle.getVehicleNumber());
            }

            // Sell a vehicle to a customer
            Customer customer = new Customer("Seak long");
            vehicleStore.sellVehicleToCustomer(bike1, customer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}