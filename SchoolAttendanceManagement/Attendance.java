import java.sql.Connection;
import java.util.Scanner;

public class Attendance {
    Connection con;

    public void attendance() {
        try {
            System.out.println("=================================== ATTENDANCE ===================================");
            System.out.println("1) STUDENT INDIVIDUAL ATTENDANCE");
            System.out.println("2) VIEW ATTENDANCE");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number:");
            int number = scanner.nextInt();
            if (number == 1) {
                new IndividualAttendance().individualAttendance();
            } else if (number == 2) {
                new StudentsAttendance().studentAttendance();
            }
        } catch (Exception e) {
            System.out.println("Please enter number...");
            attendance();
        }
    }
}
