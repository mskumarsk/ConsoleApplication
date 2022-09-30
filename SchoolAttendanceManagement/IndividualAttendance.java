import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class IndividualAttendance {
    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    Connection con;

    public void individualAttendance() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            System.out.println("==================================================>>  INDIVIDUAL ATTENDANCE  <<======" +
                    "==========================================");
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter student name:");
                String name = scanner1.nextLine();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter student id:");
                int id1 = scanner.nextInt();
                String id = String.valueOf(id1);
                System.out.println("Enter standard:");
                int standard1 = scanner.nextInt();
                String standard = String.valueOf(standard1);
                System.out.println("Enter section:");
                String section = scanner1.nextLine();
                String query2 = "select * from studentattendance where studentname='" + name + "' and " +
                        "studentid='" + id + "' and standard='" + standard + "' and section='" + section + "'";
                Statement statement2 = con.createStatement();
                ResultSet resultSet2 = statement2.executeQuery(query2);
                System.out.print(" ================================================================================" +
                        "==========================================================================================" +
                        "===============");
                System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(20,
                        "STUDENT ID") + " | " + centerString(20, "STANDARD") + " | " + centerString(20,
                        "SECTION") + " | " + centerString(20, "ATTENDACNE") + " | " + centerString(20,
                        "FACULTY NAME") + " | " + centerString(20, "FACULTY ID") + " | " + centerString(20,
                        "ATTENDANCE DATE") + " | ");
                System.out.print("\n ==============================================================================" +
                        "==========================================================================================" +
                        "=================");
                while (resultSet2.next()) {
                    String studentName = resultSet2.getString("studentname");
                    String studentId = resultSet2.getString("studentid");
                    String standard2 = resultSet2.getString("standard");
                    String section1 = resultSet2.getString("section");
                    String attendance = resultSet2.getString("attendance");
                    String facultyName = resultSet2.getString("facultyname");
                    String facultyId = resultSet2.getString("facultyid");
                    String attendanceDate = resultSet2.getString("attendancedate");
                    System.out.printf("\n | " + centerString(20, studentName) + " | " + centerString(20,
                            studentId) + " | " + centerString(20, standard2) + " | " + centerString(20,
                            section1) + " | " + centerString(20, attendance) + " | " + centerString(20,
                            facultyName) + " | " + centerString(20, facultyId) + " | " + centerString(20,
                            attendanceDate) + " | ");
                }
                System.out.print("\n =============================================================================" +
                        "=========================================================================================" +
                        "===================");
                System.out.println();
            } catch (Exception e) {
                System.out.println("Please check details...");
            }
        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
