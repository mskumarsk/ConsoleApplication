import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookedTickets {
    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    Connection con;

    public void bookedTickets() {
        try {
            System.out.println("================================>>  BOOKED TICKET  <<================================");
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String sql = "select * from ticket";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print(" ===================================================================================" +
                    "=================================================================================================");
            System.out.printf("\n | " + centerString(15, "ID") + " | " + centerString(20,
                    "NAME") + " | " + centerString(20, "  AGE") + " | " + centerString(20,
                    "PHONE NO") + " | " + centerString(20, "MAIL") + " | " + centerString(20,
                    "TICKETS") + " | " + centerString(20, "AMOUNT") + " | " + centerString(20,
                    "BOOKING DATE") + " | ");
            System.out.print("\n ====================================================================================" +
                    "================================================================================================");
            while (resultSet.next()) {
                String seatNo = resultSet.getString("id");
                String username = resultSet.getString("username");
                String age = resultSet.getString("age");
                String phoneno2 = resultSet.getString("phoneno");
                String mail = resultSet.getString("mail");
                String ticket = resultSet.getString("tickets");
                String ticketAmount = resultSet.getString("amount");
                String date = resultSet.getString("booking_date");
                System.out.printf("\n | " + centerString(15, seatNo) + " | " + centerString(20,
                        username) + " | " + centerString(20, age) + " | " + centerString(20,
                        phoneno2) + " | " + centerString(20, mail) + " | " + centerString(20,
                        ticket) + " | " + centerString(20, ticketAmount) + " | " + centerString(20,
                        date) + " | ");
            }
            System.out.print("\n ===================================================================================" +
                    "=================================================================================================");
            System.out.println();

        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
