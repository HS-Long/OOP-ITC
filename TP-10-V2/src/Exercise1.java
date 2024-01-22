import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class Exercise1 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vehicles_v2";
    private static final String USER = "root";
    private static final String PASS = "@seaklong2001@";

    private String vehicleNumber;
    private String vehicleType;
    private int yearOfCreation;
    private double price;
    private Date dateOfAvailability;

    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Exercise1(String vehicleNumber, String vehicleType, int yearOfCreation, double price, Date dateOfAvailability) throws IllegalArgumentException {
        // Validate inputs
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle number cannot be null or empty.");
        }
        if (vehicleType == null || vehicleType.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle type cannot be null or empty.");
        }
        if (yearOfCreation < 1886) { // Assuming the first car was made in 1886
            throw new IllegalArgumentException("Year of creation is not valid.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        if (dateOfAvailability == null || dateOfAvailability.after(new Date(Calendar.getInstance().getTimeInMillis()))) {
            throw new IllegalArgumentException("Date of availability is not valid.");
        }

        // Set the attributes
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.yearOfCreation = yearOfCreation;
        this.price = price;
        this.dateOfAvailability = dateOfAvailability;
    }

    public Exercise1() {
        // initialise database connection and table
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String sql ="CREATE TABLE VehicleType (" +
                    "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255) NOT NULL)";
            String sql1 = "CREATE TABLE Vehicle (" +
                    "vehicle_number VARCHAR(10) NOT NULL PRIMARY KEY," +
                    "vehicle_type_id INT NOT NULL," +
                    "year_of_creation INT NOT NULL," +
                    "price DOUBLE NOT NULL," +
                    "date_of_availability DATE NOT NULL," +
                    "FOREIGN KEY (vehicle_type_id) REFERENCES VehicleType(id))";
            String sql2 = "CREATE TABLE SoldVehicle (" +
                    "vehicle_number VARCHAR(10) NOT NULL PRIMARY KEY," +
                    "vehicle_type_id INT NOT NULL," +
                    "year_of_creation INT NOT NULL," +
                    "price DOUBLE NOT NULL," +
                    "date_of_availability DATE NOT NULL," +
                    "customer_name VARCHAR(255) NOT NULL," +
                    "date_sold TIMESTAMP NOT NULL," +
                    "FOREIGN KEY (vehicle_type_id) REFERENCES VehicleType(id))";

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
        }catch (SQLException e){
            System.out.println();
        }
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfAvailability() {
        return dateOfAvailability;
    }

    public void setDateOfAvailability(Date dateOfAvailability) {
        this.dateOfAvailability = dateOfAvailability;
    }

    public void listVehicles() throws SQLException {
        String sql = "SELECT v.vehicle_number, vt.name as vehicle_type_name, v.year_of_creation, v.price, v.date_of_availability " +
                "FROM Vehicle v JOIN VehicleType vt ON v.vehicle_type_id = vt.id";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasData = false;
            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Vehicle Number", "Vehicle Type", "Year of Creation", "Price", "Date of Availability");
            System.out.println("-------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                hasData = true;
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n", rs.getString("vehicle_number"), rs.getString("vehicle_type_name"), rs.getInt("year_of_creation"), rs.getDouble("price"), rs.getDate("date_of_availability"));
            }

            if (!hasData) {
                System.out.println("No vehicle records available.");
            }else {
                System.out.println("-------------------------------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("An SQL error occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("A general error occurred: " + e.getMessage());
            throw e;
        }
    }

    public void addVehicle() throws SQLException {
        String sql = "INSERT INTO Vehicle (vehicle_number, vehicle_type_id, year_of_creation, price, date_of_availability) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, this.vehicleNumber);
            pstmt.setString(2, this.vehicleType);
            pstmt.setInt(3, this.yearOfCreation);
            pstmt.setDouble(4, this.price);
            pstmt.setDate(5, this.dateOfAvailability);

            pstmt.executeUpdate();
        }
    }

    public boolean removeVehicle(String vehicleNumber) {
        int rowsAffected = 0;
        String sql = "DELETE FROM Vehicle WHERE vehicle_number = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicleNumber);
            rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected > 0;
    }

    public boolean updateVehicle(String vehicleNumber) throws SQLException {
        int rowsAffected = 0;
        String sql = "UPDATE Vehicle SET vehicle_type_id = ?, year_of_creation = ?, price = ?, date_of_availability = ? WHERE vehicle_number = ?";

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
        Date dateOfAvailability = Date.valueOf(dateStr);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicleType);
            pstmt.setInt(2, yearOfCreation);
            pstmt.setDouble(3, price);
            pstmt.setDate(4, dateOfAvailability);
            pstmt.setString(5,  vehicleNumber);

            rowsAffected = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected > 0;
    }
}