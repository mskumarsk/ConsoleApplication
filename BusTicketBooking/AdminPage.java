import java.sql.Connection;
import java.util.Scanner;

public class AdminPage {
    Connection con;

    public void adminPage() {
        while (true) {
            try {
                System.out.println("===================================>> ADMIN PAGE  <<============================" +
                        "=======");
                System.out.println("1) BOOKED TICKETS");
                System.out.println("2) AVAILABLE TICKETS");
                System.out.println("3) CANCEL TICKETS");
                System.out.println("4) EXIT");
                Scanner scanner = new Scanner(System.in);
                int no = scanner.nextInt();
                if (no == 1) {
                    new BookedTickets().bookedTickets();
                } else if (no == 2) {
                    new AvailableTicket().availableTicket();
                } else if (no == 3) {
                    new CancelTickets().cancelTickets();
                } else if (no == 4) {
                    new BusTicketReservation().mainPage();
                }
            }catch (Exception e){
                System.out.println("Please enter number...");
                adminPage();
            }
        }
    }
}
