package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args) {
        // MySQL server URL (without DB name)
    String serverUrl = "jdbc:mysql://localhost:3306/<your_database_name>";
    // TODO: Write your own database name below
    String dbName = "<your_database_name>";
        // TODO: Replace with your MySQL username
        String user = "<your_mysql_username>";
        // TODO: Replace with your MySQL password
        String password = "<your_mysql_password>";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 1: Connect to MySQL server (no DB specified)
            Connection conn = DriverManager.getConnection(serverUrl, user, password);
            Statement stmt = conn.createStatement();

            // Step 2: Create database if not exists
            String createDB = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(createDB);
            System.out.println("✅ Database connected.");

            // Close first connection
            conn.close();

            // Step 3: Connect to the database
            String dbUrl = serverUrl + dbName;
            Connection dbConn = DriverManager.getConnection(dbUrl, user, password);

            if (dbConn != null) {
                System.out.println("✅ Connected to database: " + dbName + " successfully!");
            } else {
                System.out.println("❌ Failed to connect to the database.");
            }

            // Close the database connection
            dbConn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database operation failed.");
            e.printStackTrace();
        }
    }
}
