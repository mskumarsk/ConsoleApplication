import java.util.Scanner;

public class UserPage {
    public void userPage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("================================>> USER PAGE  <<================================");
                System.out.println("1) BOOKING");
                System.out.println("2) AVAILABLE TICKET");
                System.out.println("3) TICKET CANCEL");
                System.out.println("4) BOOKED TICKET");
                System.out.println("5) EXIT");
                System.out.println("Enter the number:");
                String no1 = scanner.nextLine();
                int no = Integer.parseInt(no1);
                if (no == 1) {
                    new TicketBook().ticketBook();
                } else if (no == 2) {
                    new AvailableTicket().availableTicket();
                } else if (no == 3) {
                    new TicketCancel().ticketCancel();
                } else if (no == 4) {
                    new UserBooked().bookedTicket();
                } else if (no == 5) {
                    new BusTicketReservation().mainPage();
                }
            }catch (Exception e){
                System.out.println("Please enter number...");
                userPage();
            }
        }
    }
}
