import java.util.Scanner;

public class AdminPage {
    public void adminPage() {
        while (true) {
            try {
                System.out.println("=================================== ADMIN PAGE ===================================");
                System.out.println("1) FACULTY");
                System.out.println("2) VIEW ATTENDANCE");
                System.out.println("3) EXIT");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number:");
                int number = scanner.nextInt();
                if (number == 1) {
                    new Faculty().faculty();
                } else if (number == 2) {
                    new Attendance().attendance();
                } else if (number == 3) {
                    new AttendanceManagement().attendanceManagement();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
                adminPage();
            }
        }
    }
}
