import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TicketCancel {
    Connection con;

    public void ticketCancel() {
        System.out.println("================================>> TICKET CANCEL  <<================================");
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name:");
            String name = scanner.nextLine();
            System.out.println("Enter phone number:");
            String phoneno = scanner.nextLine();
            System.out.println("Enter seat number:");
            String seatNumber = scanner.nextLine();

            String sql = "select * from ticket where username='" + name + "' and phoneno='" + phoneno + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String username = "";
            String age = "";
            String phoneno2 = "";
            String mail = "";
            String ticket = "";
            String ticketAmount = "";
            String date = "";
            if (resultSet.next()) {
                username = resultSet.getString("username");
                age = resultSet.getString("age");
                phoneno2 = resultSet.getString("phoneno");
                mail = resultSet.getString("mail");
                ticket = resultSet.getString("tickets");
                ticketAmount = resultSet.getString("amount");
                date = resultSet.getString("booking_date");
            }

            String query = "insert into ticketcancel(username,age,phoneno,mail,tickets,amount," +
                    "booking_date) values (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, age);
            preparedStatement.setString(3, phoneno);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, ticket);
            preparedStatement.setString(6, ticketAmount);
            preparedStatement.setString(7, date);
            preparedStatement.executeUpdate();
            String query3 = "delete from ticket where id='" + seatNumber + "' and username='" + name + "' and" +
                    " phoneno='" + phoneno + "'";
            PreparedStatement preparedStatement1 = con.prepareStatement(query3);
            preparedStatement1.executeUpdate();
            System.out.println("Cancel ticket successfully...");
        } catch (Exception e) {
            System.out.println("Please check your details...");
            ticketCancel();
        }
    }
}
