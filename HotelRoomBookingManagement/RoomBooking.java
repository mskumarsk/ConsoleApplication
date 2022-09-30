import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RoomBooking {
    Connection con;

    public void roomBooking() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        con = databaseConnection.Database();
        try {
            System.out.println("========================================== ROOM BOOKING ===========================" +
                    "===============");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter your phone number:");
            long phone1 = scanner1.nextLong();
            String phone = String.valueOf(phone1);
            System.out.println("Enter your mail id:");
            String mail = scanner.nextLine();
            System.out.println("Enter rooms:");
            int rooms1 = scanner1.nextInt();
            String rooms = String.valueOf(rooms1);
            System.out.println("Room type:");
            System.out.println("1) A/C Room");
            System.out.println("2) Non A/C Room");
            String room = "";
            int rate = 0;
            System.out.println("Enter the number:");
            int roomType = scanner1.nextInt();
            int amount = 0;
            if (roomType == 1) {
                room = "A/C Room";
                try {
                    String sql = "select * from contactdetails";
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next()) {
                        String acRoomAmount = resultSet.getString("acroomsamount");
                        amount = Integer.parseInt(acRoomAmount);
                    }
                } catch (Exception e) {
                    System.out.println("Database error...");
                }
            } else if (roomType == 2) {
                room = "Non A/C Room";
                try {
                    String sql1 = "select * from contactdetails";
                    Statement statement1 = con.createStatement();
                    ResultSet resultSet1 = statement1.executeQuery(sql1);
                    if (resultSet1.next()) {
                        String roomAmount = resultSet1.getString("roomsamount");
                        amount = Integer.parseInt(roomAmount);
                    }
                } catch (Exception e) {
                    System.out.println("Database error...");
                }
            }
            System.out.println("Days:");
            int days1 = scanner1.nextInt();
            String days = String.valueOf(days1);
            System.out.println("Date:");
            String date = scanner.nextLine();
            int totalRooms = days1 * rooms1;
            int totalAmount1 = amount * totalRooms;
            String totalAmount = String.valueOf(totalAmount1);
            System.out.println("============================  DETAILS  ============================");
            System.out.println("ROOM          :  " + room);
            System.out.println("DAYS          :  " + days);
            System.out.println("DATE          :  " + date);
            System.out.println("AMOUNT        :  " + totalAmount1);
            System.out.println("1) OK");
            System.out.println("2) CANCEL");
            System.out.println("Enter the number:");
            int number = scanner1.nextInt();
            if (number == 1) {
                String query = "insert into bookingdetails (username,phone,mail,rooms,roomtype,days,startdate," +
                        "amount) values (?,?,?,?,?,?,?,?);";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, phone);
                preparedStatement.setString(3, mail);
                preparedStatement.setString(4, rooms);
                preparedStatement.setString(5, room);
                preparedStatement.setString(6, days);
                preparedStatement.setString(7, date);
                preparedStatement.setString(8, totalAmount);
                preparedStatement.executeUpdate();
                System.out.println("Room booking successfully...");
                new UserPage().userPage();
            } else if (number == 2) {
                roomBooking();
            }
        } catch (Exception e) {
            System.out.println("Please check your details...");
            roomBooking();
        }
    }
}
