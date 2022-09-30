import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveFaculty {
    Connection con;

    public void removeFaculty() {
        System.out.println("================================>> REMOVE FACULTY  <<================================");
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter faculty name:");
            String name = scanner.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter faculty id:");
            int id = scanner1.nextInt();
            String facultyId = String.valueOf(id);
            String query3 = "delete from faculty where username='" + name + "' and id='" + facultyId + "'";
            PreparedStatement preparedStatement1 = con.prepareStatement(query3);
            preparedStatement1.executeUpdate();
            System.out.println("Faculty remove successfully...");
        } catch (Exception e) {
            System.out.println("Please check details...");
            removeFaculty();
        }
    }
}
