import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ClassDetails {
    Connection con;

    public void classDetails() {
        while (true) {
            try {
                System.out.println("=================================== CLASS DETAILS ==============================" +
                        "=====");
                System.out.println("1) ADD STUDENT");
                System.out.println("2) REMOVE STUDENT");
                System.out.println("3) ATTENDANCE");
                System.out.println("4) VIEW ATTENDANCE");
                System.out.println("5) EXIT");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number:");
                int number = scanner.nextInt();
                if (number == 1) {
                    new AddStudent().addStudent();
                } else if (number == 2) {
                    new RemoveStudent().removeStudent();
                } else if (number == 3) {
                    new StudentAttendance().studentAttendance();
                } else if (number == 4) {
                    new Attendance().attendance();
                } else if (number == 5) {
                    new AttendanceManagement().attendanceManagement();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
            }
        }
    }
}
