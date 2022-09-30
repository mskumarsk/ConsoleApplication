import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentAttendance {
    Connection con;

    public void studentAttendance() {
        try {
            System.out.println("=================================== ATTENDANCE ===================================");
            try {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                con = databaseConnection.Database();
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter faculty name:");
                String facultyName = scanner.nextLine();
                System.out.println("Enter faculty id:");
                int facultyId1 = scanner1.nextInt();
                String facultyId = String.valueOf(facultyId1);
                System.out.println("Enter standard:");
                int standard1 = scanner1.nextInt();
                String standard = String.valueOf(standard1);
                System.out.println("Enter section:");
                String section = scanner.nextLine();
                String sql = "select * from student where standard='" + standard + "' and section='" + section + "'";
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String studentName = resultSet.getString("studentname");
                    String studentId = resultSet.getString("studentid");
                    System.out.println("=======================  STUDENT DETAILS =======================");
                    System.out.println("STUDENT NAME                  :  " + studentName);
                    System.out.println("STUDENT ID                    :  " + studentId);
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("1) PRESENT");
                    System.out.println("2) ABSENT");
                    System.out.println("Enter the number:");
                    int num = scanner2.nextInt();
                    if (num == 1) {
                        String present = "PRESENT";
                        String query = "insert into studentattendance (studentname,studentid,standard,section," +
                                "attendance,facultyname,facultyid) values (?,?,?,?,?,?,?)";
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, studentName);
                        preparedStatement.setString(2, studentId);
                        preparedStatement.setString(3, standard);
                        preparedStatement.setString(4, section);
                        preparedStatement.setString(5, present);
                        preparedStatement.setString(6, facultyName);
                        preparedStatement.setString(7, facultyId);
                        preparedStatement.executeUpdate();

                        String sql1 = "select * from student where studentname='" + studentName + "' and " +
                                "studentid='" + studentId + "'";
                        Statement statement1 = con.createStatement();
                        ResultSet resultSet1 = statement1.executeQuery(sql1);
                        String attendance = "";
                        if (resultSet1.next()) {
                            attendance = resultSet1.getString("present");
                        }
                        int totalAttendance = 1 + Integer.parseInt(attendance);
                        String present1 = String.valueOf(totalAttendance);
                        String query3 = "update student set present='" + present1 + "' where " +
                                "studentname='" + studentName + "' and studentid='" + studentId + "'";
                        PreparedStatement preparedStatement1 = con.prepareStatement(query3);
                        preparedStatement1.executeUpdate();
                        System.out.println("Successfully...");
                    } else if (num == 2) {
                        System.out.println("2");
                        String absent = "ABSENT";
                        String query1 = "insert into studentattendance (studentname,studentid,standard,section," +
                                "attendance,facultyname,facultyid) values (?,?,?,?,?,?,?)";
                        PreparedStatement preparedStatement = con.prepareStatement(query1);
                        preparedStatement.setString(1, studentName);
                        preparedStatement.setString(2, studentId);
                        preparedStatement.setString(3, standard);
                        preparedStatement.setString(4, section);
                        preparedStatement.setString(5, absent);
                        preparedStatement.setString(6, facultyName);
                        preparedStatement.setString(7, facultyId);
                        preparedStatement.executeUpdate();

                        String sql2 = "select * from student where studentname='" + studentName + "' and " +
                                "studentid='" + studentId + "'";
                        Statement statement1 = con.createStatement();
                        ResultSet resultSet1 = statement1.executeQuery(sql2);
                        String attendance = "";
                        if (resultSet1.next()) {
                            attendance = resultSet1.getString("absent");
                        }
                        int totalAttendance = 1 + Integer.parseInt(attendance);
                        String present1 = String.valueOf(totalAttendance);
                        String query4 = "update student set absent='" + present1 + "' where " +
                                "studentname='" + studentName + "' and studentid='" + studentId + "'";
                        PreparedStatement preparedStatement1 = con.prepareStatement(query4);
                        preparedStatement1.executeUpdate();
                        System.out.println("Successfully...");
                    }
                }
            } catch (Exception e) {
                System.out.println("Please check details...");
                studentAttendance();
            }
        } catch (Exception e) {
            System.out.println("Please check details...");
        }
    }
}
