import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddFaculty {
    Connection con;

    public void addFaculty() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            System.out.println("============================= ADD FACULTY =============================");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter faculty name:");
            String name = scanner.nextLine();
            System.out.println("Enter the phone number:");
            Scanner scanner1 = new Scanner(System.in);
            long phone1 = scanner1.nextLong();
            String phone = String.valueOf(phone1);
            System.out.println("Enter mail:");
            String mail = scanner.nextLine();
            try {
                System.out.println("1) OK");
                System.out.println("2) CANCEL");
                System.out.println("Enter the number:");
                int number = scanner1.nextInt();
                if (number == 1) {
                    String query = "insert into faculty (username,phone,mail) values (?,?,?);";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, phone);
                    preparedStatement.setString(3, mail);
                    preparedStatement.executeUpdate();
                    System.out.println("Faculty add successfully...");
                    String sql = "select * from faculty where username='" + name + "' and phone='" + phone + "' and " +
                            "mail='" + mail + "'";
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    String userName = "";
                    String userPhone = "";
                    String userMail = "";
                    String userId = "";
                    if (resultSet.next()) {
                        userId = resultSet.getString("id");
                        userName = resultSet.getString("username");
                        userPhone = resultSet.getString("phone");
                        userMail = resultSet.getString("mail");
                    }
                    System.out.println("============================ FACULTY DETAILS ============================");
                    System.out.println("FACULTY NAME               :  " + userName);
                    System.out.println("FACULTY PHONE NUMBER       :  " + userPhone);
                    System.out.println("FACULTY MAIL               :  " + userMail);
                    System.out.println("FACULTY ID                 :  " + userId);
                } else if (number == 2) {
                    addFaculty();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
            }
        } catch (Exception e) {
            System.out.println("Please check details...");
            addFaculty();
        }
    }
}
