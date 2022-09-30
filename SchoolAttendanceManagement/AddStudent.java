import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddStudent {
    Connection con;

    public void addStudent() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            System.out.println("============================= ADD STUDENT =============================");
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
            try {
                System.out.println("1) OK");
                System.out.println("2) CANCEL");
                System.out.println("Enter the number:");
                int number = scanner1.nextInt();
                String value = "0";
                if (number == 1) {
                    String query = "insert into student (studentname,studentid,standard,section,absent," +
                            "present) values (?,?,?,?,?,?);";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, id);
                    preparedStatement.setString(3, standard);
                    preparedStatement.setString(4, section);
                    preparedStatement.setString(5, value);
                    preparedStatement.setString(6, value);
                    preparedStatement.executeUpdate();
                    System.out.println("Student add successfully...");
                    String sql = "select * from student where studentname='" + name + "' and " +
                            "studentid='" + id + "' and standard='" + standard + "'";
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    String studentName = "";
                    String studentId = "";
                    String studentStandard = "";
                    String studentSection = "";
                    if (resultSet.next()) {
                        studentName = resultSet.getString("studentname");
                        studentId = resultSet.getString("studentid");
                        studentStandard = resultSet.getString("standard");
                        studentSection = resultSet.getString("section");
                    }
                    System.out.println("============================ STUDENT DETAILS ============================");
                    System.out.println("STUDENT NAME               :  " + studentName);
                    System.out.println("STUDENT ID                 :  " + studentId);
                    System.out.println("STUDENT STANDARD           :  " + studentStandard);
                    System.out.println("STUDENT SECTION            :  " + studentSection);
                    System.out.println("=========================================================================");
                    try {
                        System.out.println("1) ADD STUDENT");
                        System.out.println("2) CANCEL");
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Enter the number:");
                        int num = scanner2.nextInt();
                        if (num == 1) {
                            addStudent();
                        } else if (num == 2) {
                            new ClassDetails().classDetails();
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter number...");
                    }
                } else if (number == 2) {
                    addStudent();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
            }
        } catch (Exception e) {
            System.out.println("Please check details...");
            addStudent();
        }

    }
}
