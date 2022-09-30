import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentsAttendance {
    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    Connection con;

    public void studentAttendance() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            System.out.println("==================================================>>  INDIVIDUAL ATTENDANCE  <<=====" +
                    "===========================================");
            try {
                Scanner scanner1 = new Scanner(System.in);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter standard:");
                int standard1 = scanner.nextInt();
                String standard = String.valueOf(standard1);
                System.out.println("Enter section:");
                String section = scanner1.nextLine();
                String query2 = "select * from student where standard='" + standard + "' and section='" + section + "'";
                Statement statement2 = con.createStatement();
                ResultSet resultSet2 = statement2.executeQuery(query2);
                System.out.print(" ===============================================================================" +
                        "===================================================================================");
                System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(20,
                        "STUDENT ID") + " | " + centerString(20, "STANDARD") + " | " + centerString(20,
                        "SECTION") + " | " + centerString(20, "ABSENT") + " | " + centerString(20,
                        "PRESENT") + " | " + centerString(20, "ATTENDACNE") + " | ");
                System.out.print("\n =============================================================================" +
                        "=====================================================================================");
                while (resultSet2.next()) {
                    String studentName = resultSet2.getString("studentname");
                    String studentId = resultSet2.getString("studentid");
                    String standard2 = resultSet2.getString("standard");
                    String section1 = resultSet2.getString("section");
                    String absent = resultSet2.getString("absent");
                    String present = resultSet2.getString("present");
                    String attendance = resultSet2.getString("attendance");
                    System.out.printf("\n | " + centerString(20, studentName) + " | " + centerString(20,
                            studentId) + " | " + centerString(20, standard2) + " | " + centerString(20,
                            section1) + " | " + centerString(20, absent) + " | " + centerString(20,
                            present) + " | " + centerString(20, attendance) + " | ");
                }
                System.out.print("\n ============================================================================" +
                        "======================================================================================");
                System.out.println();
            } catch (Exception e) {
                System.out.println("Please check details...");
            }
        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
