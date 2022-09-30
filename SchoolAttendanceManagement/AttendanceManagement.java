import java.util.Scanner;

public class AttendanceManagement extends AdminDetails {
    public static void main(String[] args) {
        AttendanceManagement attendanceManagement = new AttendanceManagement();
        attendanceManagement.attendanceManagement();
    }

    public void attendanceManagement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================>> SCHOOL ATTENDANCE MANAGEMENT <<===========" +
                "==============================");
        while (true) {
            try {
                System.out.println("1) ADMIN");
                System.out.println("2) FACULTY");
                System.out.println("Enter the number:");
                String number1 = scanner.nextLine();
                int number = Integer.parseInt(number1);
                if (number == 1) {
                    while (true) {
                        System.out.println("================================>> ADMIN PAGE  <<======================" +
                                "==========");
                        System.out.println("================================>> LOGIN PAGE  <<======================" +
                                "==========");
                        System.out.println("Enter the admin name:");
                        String adminName = scanner.nextLine();
                        if (adminName.equals(getAdminName())) {
                            System.out.println("Enter the password:");
                            String adminPassword = scanner.nextLine();
                            if (adminPassword.equals(getAdminPassword())) {
                                new AdminPage().adminPage();
                            } else {
                                System.out.println("Incorrect password...");
                            }
                        } else {
                            System.out.println("Admin name is wrong...");
                        }
                    }
                } else if (number == 2) {
                    new FacultyLogin().facultyLogin();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
                attendanceManagement();
            }
        }
    }
}
