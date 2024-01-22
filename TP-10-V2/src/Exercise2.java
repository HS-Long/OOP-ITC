import java.sql.*;

public class Exercise2 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vehicles_v2";
    private static final String USER = "root";
    private static final String PASS = "@seaklong2001@";

    public void addVehicleType(VehicleType vehicleType) throws SQLException {
        String sql = "INSERT INTO VehicleType (id, name) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, vehicleType.getId());
            pstmt.setString(2, vehicleType.getName());
            pstmt.executeUpdate();
        }
    }

    public static void listVehicleTypes() throws SQLException {
        String sql = "SELECT * FROM VehicleType";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        }
    }

    public void deleteVehicleType(int id) throws SQLException {
        String sql = "DELETE FROM VehicleType WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
