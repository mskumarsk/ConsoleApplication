import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    Connection con;

    public Connection Database() {
        try {
            String url = "jdbc:mysql://localhost:3306/BusTicket";
            String user = "root";
            String pass = "8056812985msk";
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Database connection error...");
        }
        return con;
    }
}
