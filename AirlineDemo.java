import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AirlineDemo {
    public static void main(String[] args) {

        String sql = "SELECT economy_price FROM flight WHERE Departure='Lahore'";
        String url = "jdbc:mysql://localhost:3306/airlines";
        String username = "Adm";
        String password = "xxxx";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                String id = rs.getString(1);
                System.out.println("Flight Number: " + id);
            } else {
                System.out.println("No flights found from Lahore.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

