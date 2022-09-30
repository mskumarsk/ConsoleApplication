import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CancelTickets {
    Connection con;

    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void cancelTickets() {
        try {
            System.out.println("====================================================>>  CANCEL TICKETS  <<==========" +
                    "==========================================");
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();

            String sql = "select * from ticketcancel";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print(" =====================================================================================" +
                    "===============================================================================================" +
                    "=======================");
            System.out.printf("\n | " + centerString(15, "ID") + " | " + centerString(20,
                    "NAME") + " | " + centerString(20, "  AGE") + " | " + centerString(20,
                    "PHONE NO") + " | " + centerString(20, "MAIL") + " | " + centerString(20,
                    "TICKETS") + " | " + centerString(20, "AMOUNT") + " | " + centerString(20,
                    "BOOKING DATE") + " | " + centerString(20, "CANCEL DATE") + " | ");
            System.out.print("\n ===================================================================================" +
                    "===============================================================================================" +
                    "=========================");
            while (resultSet.next()) {
                String seatNo = resultSet.getString("id");
                String username = resultSet.getString("username");
                String age = resultSet.getString("age");
                String phoneno2 = resultSet.getString("phoneno");
                String mail = resultSet.getString("mail");
                String ticket = resultSet.getString("tickets");
                String ticketAmount = resultSet.getString("amount");
                String date = resultSet.getString("booking_date");
                String cancelDate = resultSet.getString("cancel_date");
                System.out.printf("\n | " + centerString(15, seatNo) + " | " + centerString(20,
                        username) + " | " + centerString(20, age) + " | " + centerString(20,
                        phoneno2) + " | " + centerString(20, mail) + " | " + centerString(20,
                        ticket) + " | " + centerString(20, ticketAmount) + " | " + centerString(20,
                        date) + " | " + centerString(20, cancelDate) + " | ");
            }
            System.out.print("\n ==================================================================================" +
                    "==============================================================================================" +
                    "===========================");
            System.out.println();

        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
