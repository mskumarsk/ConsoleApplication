import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FacultyLogin {
    Connection con;

    public void facultyLogin() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            System.out.println("=================================== FACULTY LOGIN ===================================");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the faculty name:");
            String name = scanner.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter the faculty id:");
            int id1 = scanner1.nextInt();
            String id = String.valueOf(id1);
            String sql = "select * from faculty where id='"+id+"' and username='"+name+"';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String facultyId = resultSet.getString("id");
                String facultyName = resultSet.getString("username");
                if (facultyId.equals(id)) {
                    if (facultyName.equals(name)) {
                        new ClassDetails().classDetails();
                    } else {
                        System.out.println("Please check your name...");
                    }
                } else {
                    System.out.println("Please check your id...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Please check your details...");
        }
    }
}
