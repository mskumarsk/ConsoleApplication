import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContactDetails {
    Connection con;

    public void contact() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        con = databaseConnection.Database();
        try {
            System.out.println("================================>> CONTACT DETAILS <<================================");
            String query2 = "select * from contactdetails";
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);
            if (resultSet2.next()) {
                String hotelName = resultSet2.getString("hotelname");
                String phone = resultSet2.getString("phone");
                String acRooms = resultSet2.getString("acrooms");
                String rooms = resultSet2.getString("rooms");
                String acRoomsAmount = resultSet2.getString("acroomsamount");
                String roomsAmount = resultSet2.getString("roomsamount");
                String address = resultSet2.getString("address");
                System.out.println("HOTEL NAME               :  " + hotelName);
                System.out.println("PHONE NO                 :  " + phone);
                System.out.println("AC ROOMS                 :  " + acRooms);
                System.out.println("AC ROOM AMOUNT           :  " + acRoomsAmount);
                System.out.println("NON AC ROOMS             :  " + rooms);
                System.out.println("NON AC ROOMS AMOUNT      :  " + roomsAmount);
                System.out.println("ADDRESS                  :  " + address);
            }
        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
