import java.util.Scanner;

public class Faculty {
    public void faculty() {
        while (true) {
            try {
                System.out.println("1) ADD FACULTY");
                System.out.println("2) REMOVE FACULTY");
                System.out.println("3) EXIT");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number:");
                int number = scanner.nextInt();
                if (number == 1) {
                    new AddFaculty().addFaculty();
                } else if (number == 2) {
                    new RemoveFaculty().removeFaculty();
                } else if (number == 3) {
                    new AdminPage().adminPage();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
            }
        }
    }
}
