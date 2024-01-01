import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleStore {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vehicles";
    private static final String USER = "root";
    private static final String PASSWORD = "@seaklong2001@";

    public List<VehicleType> listAllVehicleTypes() throws SQLException {
        List<VehicleType> vehicleTypes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM vehicle_types";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                VehicleType vehicleType = new VehicleType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                vehicleTypes.add(vehicleType);
            }
        }
        return vehicleTypes;
    }

    public void addVehicleType(VehicleType vehicleType) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO vehicle_types (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, vehicleType.getName());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                vehicleType.setId(generatedKeys.getInt(1));
            }
        }
    }

    public void removeVehicleType(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicle_types WHERE id = ?")) {

            removeVehiclesByTypeId(id);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
    }

    private void removeVehiclesByTypeId(int typeId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE vehicle_type_id = ?")) {

            preparedStatement.setInt(1, typeId);

            preparedStatement.executeUpdate();
        }
    }

    public List<Vehicle> listAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM vehicles";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getString("vehicle_number"),
                        getVehicleType(resultSet.getInt("vehicle_type_id")),
                        resultSet.getInt("year_of_creation"),
                        resultSet.getDouble("price"),
                        resultSet.getString("date_of_availability")
                );
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    private VehicleType getVehicleType(int typeId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicle_types WHERE id = ?")) {

            preparedStatement.setInt(1, typeId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new VehicleType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        }
        return null;
    }

    public void addVehicle(Vehicle vehicle) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO vehicles (vehicle_number, vehicle_type_id, year_of_creation, price, date_of_availability) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, vehicle.getVehicleNumber());
            preparedStatement.setInt(2, vehicle.getVehicleType().getId());
            preparedStatement.setInt(3, vehicle.getYearOfCreation());
            preparedStatement.setDouble(4, vehicle.getPrice());
            preparedStatement.setString(5, vehicle.getDateOfAvailability());

            preparedStatement.executeUpdate();
        }
    }

    public void removeVehicle(String vehicleNumber) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE vehicle_number = ?")) {

            preparedStatement.setString(1, vehicleNumber);

            preparedStatement.executeUpdate();
        }
    }

    public void updateVehicle(Vehicle vehicle) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE vehicles SET vehicle_type_id = ?, year_of_creation = ?, price = ?, date_of_availability = ? WHERE vehicle_number = ?")) {

            preparedStatement.setInt(1, vehicle.getVehicleType().getId());
            preparedStatement.setInt(2, vehicle.getYearOfCreation());
            preparedStatement.setDouble(3, vehicle.getPrice());
            preparedStatement.setString(4, vehicle.getDateOfAvailability());
            preparedStatement.setString(5, vehicle.getVehicleNumber());

            preparedStatement.executeUpdate();
        }
    }

    public List<Vehicle> listVehiclesInType(int typeId) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM vehicles WHERE vehicle_type_id = ?")) {

            preparedStatement.setInt(1, typeId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getString("vehicle_number"),
                        getVehicleType(resultSet.getInt("vehicle_type_id")),
                        resultSet.getInt("year_of_creation"),
                        resultSet.getDouble("price"),
                        resultSet.getString("date_of_availability")
                );
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public void sellVehicleToCustomer(Vehicle vehicle, Customer customer) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO sales (vehicle_number, customer_name, sale_date) VALUES (?, ?, NOW())")) {

            preparedStatement.setString(1, vehicle.getVehicleNumber());
            preparedStatement.setString(2, customer.getName());

            preparedStatement.executeUpdate();
        }
    }
}