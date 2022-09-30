import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserBooked {
    Connection con;

    public void bookedTicket() {
        try {
            System.out.println("================================>>  BOOKED TICKET  <<================================");
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name:");
            String name = scanner.nextLine();
            System.out.println("Enter phone number:");
            String phoneno = scanner.nextLine();

            String sql = "select * from ticket where username='" + name + "' and phoneno='" + phoneno + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String age = resultSet.getString("age");
                String phoneno2 = resultSet.getString("phoneno");
                String mail = resultSet.getString("mail");
                String ticket = resultSet.getString("tickets");
                String ticketAmount = resultSet.getString("amount");
                String date = resultSet.getString("booking_date");
                System.out.println("USER NAME          :  " + username);
                System.out.println("AGE                :  " + age);
                System.out.println("PHONE NUMBER       :  " + phoneno2);
                System.out.println("MAIL               :  " + mail);
                System.out.println("TICKETS            :  " + ticket);
                System.out.println("AMOUNT             :  " + ticketAmount);
                System.out.println("BOOKING DATE       :  " + date);
            }
        } catch (Exception e) {
            System.out.println("Please check your details...");
            bookedTicket();
        }
    }
}
