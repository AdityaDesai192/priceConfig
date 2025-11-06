import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/price_db";
    static final String USER = "root";
    static final String PASS = "Enter your password";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Connected to MySQL successfully!");
            return con;
        } catch (ClassNotFoundException cnf) {
            System.out.println(" Driver class not found: " + cnf.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println(" Connection failed: " + e.getMessage());
            return null;
        }
    }
}
