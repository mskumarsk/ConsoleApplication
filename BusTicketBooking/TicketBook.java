import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TicketBook {
    int seat = 50;
    Connection con;

    public void ticketBook() {
        try {
            System.out.println("================================>> TICKET BOOKING  <<================================");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name:");
            String name = scanner.nextLine();
            System.out.println("Enter your age:");
            String age = scanner.nextLine();
            System.out.println("Enter your phone number:");
            String phoneno = scanner.nextLine();
            System.out.println("Enter your mail:");
            String mail = scanner.nextLine();
            String ticket = "1";
            System.out.println("Ticket:  " + ticket);
            System.out.println("1) OK");
            System.out.println("2) CANCEL");
            System.out.println("Enter the number:");
            String number = scanner.nextLine();
            int no = Integer.parseInt(number);
            if (no == 1) {
                try {
                    DatabaseConnection databaseConnection = new DatabaseConnection();
                    con = databaseConnection.Database();
                    String sql = "select count(id) as count from ticket";
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next()) {
                        String ticketAmount = "500";
                        int seatCount = resultSet.getInt("count");
                        if (seat >= seatCount) {
                            String query = "insert into ticket(username,age,phoneno,mail,tickets," +
                                    "amount) values (?,?,?,?,?,?);";
                            PreparedStatement preparedStatement = con.prepareStatement(query);
                            preparedStatement.setString(1, name);
                            preparedStatement.setString(2, age);
                            preparedStatement.setString(3, phoneno);
                            preparedStatement.setString(4, mail);
                            preparedStatement.setString(5, ticket);
                            preparedStatement.setString(6, ticketAmount);
                            preparedStatement.executeUpdate();

                            String sql1 = "select id from ticket where username='" + name + "' and " +
                                    "phoneno='" + phoneno + "'";
                            Statement statement1 = con.createStatement();
                            ResultSet resultSet1 = statement1.executeQuery(sql1);
                            if (resultSet1.next()) {
                                String seatNo = resultSet1.getString("id");
                                System.out.println("YOUR SEAT NO:  " + seatNo);
                                System.out.println("Ticket booked successfully...");
                            }
                        } else {
                            System.out.println("Ticket not available...");
                        }

                    }
                } catch (Exception e) {
                    System.out.println("Database error...");
                }
            } else {
                System.out.println("Cancel...");
            }
        }catch (Exception e){
            System.out.println("Please enter number...");
            ticketBook();
        }
    }
}
