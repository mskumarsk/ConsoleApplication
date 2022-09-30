import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateContact {
    Connection con;

    public void updateContact() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        con = databaseConnection.Database();
        try {
            System.out.println("================================>> UPDATE CONTACT DETAILS <<=====================" +
                    "===========");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter hotel name:");
            String name = scanner.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter phone number:");
            long phone1 = scanner1.nextLong();
            String phone = String.valueOf(phone1);
            System.out.println("Enter A/C rooms:");
            int acRoom1 = scanner1.nextInt();
            String acRoom = String.valueOf(acRoom1);
            System.out.println("Enter A/C rooms amount:");
            int acRoomAmount1 = scanner1.nextInt();
            String acRoomAmount = String.valueOf(acRoomAmount1);
            System.out.println("Enter Non A/C rooms:");
            int rooms1 = scanner1.nextInt();
            String rooms = String.valueOf(rooms1);
            System.out.println("Enter Non A/C rooms amount:");
            int roomAmount1 = scanner1.nextInt();
            String roomAmount = String.valueOf(roomAmount1);
            System.out.println("Enter address:");
            String address = scanner.nextLine();
            try {
                int id = 1;
                String query3 = "update contactdetails set hotelname='" + name + "',phone='" + phone + "'," +
                        "acrooms='" + acRoom + "',rooms='" + rooms + "',acroomsamount='" + acRoomAmount + "'," +
                        "roomsamount='" + roomAmount + "',address='" + address + "' where id='" + id + "'";
                PreparedStatement preparedStatement1 = con.prepareStatement(query3);
                preparedStatement1.executeUpdate();
                System.out.println("Contact update successfully...");
            } catch (Exception e) {
                System.out.println("Database error...");
            }

        } catch (Exception e) {
            System.out.println("Please check your details...");
            updateContact();
        }
    }
}
