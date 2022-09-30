import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookedRoomDetails {
    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    Connection con;

    public void bookedRoom() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String query2 = "select * from bookingdetails";
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);
            System.out.println("==================================================>>  BOOKED ROOMS  <<==============" +
                    "==================================");
            System.out.print(" =====================================================================================" +
                    "===============================================================================================" +
                    "============================");
            System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(20,
                    "PHOME") + " | " + centerString(20, "MAIL") + " | " + centerString(20,
                    "ROOMS") + " | " + centerString(20, "ROOM TYPE") + " | " + centerString(20,
                    "DAYS") + " | " + centerString(20, "DATE") + " | " + centerString(20,
                    "AMOUNT") + " | " + centerString(20, "BOOKED DATE") + " | ");
            System.out.print("\n =====================================================================================" +
                    "===============================================================================================" +
                    "============================");
            while (resultSet2.next()) {
                String userName = resultSet2.getString("username");
                String phone = resultSet2.getString("phone");
                String mail = resultSet2.getString("mail");
                String rooms = resultSet2.getString("rooms");
                String roomType = resultSet2.getString("roomtype");
                String days = resultSet2.getString("days");
                String date = resultSet2.getString("startdate");
                String amount = resultSet2.getString("amount");
                String bookingDate = resultSet2.getString("bookingdate");
                System.out.printf("\n | " + centerString(20, userName) + " | " + centerString(20,
                        phone) + " | " + centerString(20, mail) + " | " + centerString(20,
                        rooms) + " | " + centerString(20, roomType) + " | " + centerString(20,
                        days) + " | " + centerString(20, date) + " | " + centerString(20,
                        amount) + " | " + centerString(20, bookingDate) + " | ");
            }
            System.out.print("\n =====================================================================================" +
                    "===============================================================================================" +
                    "============================");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
