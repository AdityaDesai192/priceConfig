import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) {
                out.println("<h3>Database not connected!</h3>");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO products (name, price) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.executeUpdate();

            out.println("<h3>✅ Product Added Successfully!</h3>");
            out.println("<a href='index.html'>Back</a>");

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
