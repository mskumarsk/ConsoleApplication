import java.util.Scanner;

public class BusTicketReservation extends AdminLogin {
    public static void main(String[] args) {
        BusTicketReservation busTicketReservation = new BusTicketReservation();
        busTicketReservation.mainPage();
    }

    public void mainPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================>> BSU TICKET RESERVATION <<===================" +
                "======================");
        while (true) {
            try {
                System.out.println("1) ADMIN");
                System.out.println("2) USER");
                System.out.println("Enter the number:");
                String no1 = scanner.nextLine();
                int no = Integer.parseInt(no1);
                if (no == 1) {
                    while (true) {
                        System.out.println("================================>> ADMIN PAGE  <<=======================" +
                                "=========");
                        System.out.println("================================>> LOGIN PAGE  <<=======================" +
                                "=========");
                        System.out.println("Enter the admin name:");
                        String adminName = scanner.nextLine();
                        if (adminName.equals(getAdminName())) {
                            System.out.println("Enter the password:");
                            String adminPassword = scanner.nextLine();
                            if (adminPassword.equals(getAdminPassword())) {
                                new AdminPage().adminPage();
                            } else {
                                System.out.println("Incorrect Password");
                            }
                        } else {
                            System.out.println("Admin name is wrong...");
                        }
                    }
                } else if (no == 2) {
                    new UserPage().userPage();
                }
            }catch (Exception e){
                System.out.println("Please enter number...");
                mainPage();
            }
        }
    }
}
