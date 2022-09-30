import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RoomCancel {
    Connection con;

    public void roomCancel() {
        System.out.println("================================>> ROOM CANCEL  <<================================");
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter phone number:");
            long phone1 = scanner1.nextLong();
            String phone = String.valueOf(phone1);
            String query3 = "delete from bookingdetails where username='" + name + "' and phone='" + phone + "'";
            PreparedStatement preparedStatement1 = con.prepareStatement(query3);
            preparedStatement1.executeUpdate();
            System.out.println("Room cancel successfully...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Please check your name and phone number...");
            roomCancel();
        }
    }
}
