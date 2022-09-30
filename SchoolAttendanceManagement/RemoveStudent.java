import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveStudent {
    Connection con;

    public void removeStudent() {
        System.out.println("================================>> REMOVE STUDENT  <<================================");
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            System.out.println("Enter student id:");
            Scanner scanner1 = new Scanner(System.in);
            int id1 = scanner1.nextInt();
            String id = String.valueOf(id1);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter standard:");
            int standard1 = scanner1.nextInt();
            String standard = String.valueOf(standard1);
            System.out.println("Enter section:");
            String section = scanner.nextLine();
            String query3 = "delete from student where studentname='" + name + "' and studentid='" + id + "' and " +
                    "standard='" + standard + "' and section='" + section + "'";
            PreparedStatement preparedStatement1 = con.prepareStatement(query3);
            preparedStatement1.executeUpdate();
            System.out.println("Student remove successfully...");
        } catch (Exception e) {
            System.out.println("Please check details...");
            removeStudent();
        }
    }
}
