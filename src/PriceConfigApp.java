import java.sql.*;
import java.util.Scanner;

public class PriceConfigApp {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.out.println("Database not connected.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                if (choice == 1) {
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO products (name, price) VALUES (?, ?)");
                    ps.setString(1, name);
                    ps.setDouble(2, price);
                    ps.executeUpdate();
                    System.out.println(" Product added successfully!");

                } else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM products");
                    System.out.println("\n--- Product List ---");
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id") +
                                " | Name: " + rs.getString("name") +
                                " | Price: ₹" + rs.getDouble("price"));
                    }

                } else if (choice == 3) {
                    System.out.print("Enter product ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                            "UPDATE products SET name=?, price=? WHERE id=?");
                    ps.setString(1, newName);
                    ps.setDouble(2, newPrice);
                    ps.setInt(3, id);
                    int rows = ps.executeUpdate();
                    System.out.println(rows > 0 ? " Product updated!" : " Product not found!");

                } else if (choice == 4) {
                    System.out.print("Enter product ID to delete: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                            "DELETE FROM products WHERE id=?");
                    ps.setInt(1, id);
                    int rows = ps.executeUpdate();
                    System.out.println(rows > 0 ? " Product deleted!" : " Product not found!");

                } else if (choice == 5) {
                    System.out.println("Exiting...");
                    sc.close();
                    con.close();
                    break;

                } else {
                    System.out.println("Invalid choice. Try again!");
                }

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
