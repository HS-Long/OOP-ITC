import java.sql.*;

public class Exercise3 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vehicles_v2";
    private static final String USER = "root";
    private static final String PASS = "@seaklong2001@";
    public static void sellVehicle(String vehicleNumber, String customerName) {
        String checkVehicleSql = "SELECT COUNT(*) FROM vehicle WHERE vehicle_number = ?";
        String insertSoldVehicleSql = "INSERT INTO soldvehicle (vehicle_number, vehicle_type_id, year_of_creation, price, date_of_availability, date_sold, customer_name) " +
                "SELECT vehicle_number, vehicle_type_id, year_of_creation, price, date_of_availability, NOW(), ? FROM vehicle WHERE vehicle_number = ?";
        String deleteVehicleSql = "DELETE FROM vehicle WHERE vehicle_number = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement checkStmt = conn.prepareStatement(checkVehicleSql)) {

            checkStmt.setString(1, vehicleNumber);

            // Check if vehicle exists
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Vehicle exists, proceed with selling
                try (PreparedStatement insertStmt = conn.prepareStatement(insertSoldVehicleSql);
                     PreparedStatement deleteStmt = conn.prepareStatement(deleteVehicleSql)) {

                    // Insert into soldvehicle table
                    insertStmt.setString(1, customerName);
                    insertStmt.setString(2, vehicleNumber);
                    insertStmt.executeUpdate();

                    // Delete from vehicle table
                    deleteStmt.setString(1, vehicleNumber);
                    deleteStmt.executeUpdate();

                    System.out.println("Vehicle sold successfully.");
                }
            } else {
                // Vehicle does not exist
                System.out.println("Vehicle number not found!");
            }
        } catch (SQLException e) {
            System.out.println("SQL error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("A general error occurred: " + e.getMessage());
        }
    }

    public static void listAllSoldVehicle() {
        String sql = "SELECT sv.vehicle_number, vt.name as vehicle_type_name, sv.year_of_creation, sv.price, sv.date_of_availability, sv.date_sold, sv.customer_name " +
                "FROM soldvehicle sv " +
                "JOIN VehicleType vt ON sv.vehicle_type_id = vt.id";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.printf("| %-15s | %-15s | %-16s | %-10s | %-25s | %-15s | %-15s |\n", "Vehicle Number", "Vehicle Type", "Year of Creation", "Price", "Date of Availability", "Date Sold", "Customer Name");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("| %-15s | %-15s | %-16s | %-10.2f | %-25s | %-15s | %-15s |\n",
                        rs.getString("vehicle_number"),
                        rs.getString("vehicle_type_name"),
                        rs.getInt("year_of_creation"),
                        rs.getDouble("price"),
                        rs.getDate("date_of_availability"),
                        rs.getDate("date_sold"),
                        rs.getString("customer_name"));
            }
            if (!found) {
                System.out.println("No record found!");
            }else{
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("A general error occurred: " + e.getMessage());
        }
    }

}
