import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AvailableTicket {
    Connection con;
    int seat = 50;

    public void availableTicket() {
        try {
            System.out.println("================================>> AVAILABLE TICKET  <<===========================" +
                    "=====");
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String sql = "select count(id) as count from ticket";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int seatCount = resultSet.getInt("count");
                int availableSeat = seat - seatCount;
                System.out.println("TOTAL SEAT     :  " + seat);
                System.out.println("AVAILABLE SEAT :  " + availableSeat);
            }
        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
