import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class UserPage {
    public void userPage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("================================>> USER PAGE  <<================================");
                System.out.println("1) ROOM BOOK");
                System.out.println("2) ROOM CANCEL");
                System.out.println("3) BOOKED ROOM");
                System.out.println("4) CONTACT DETAILS");
                System.out.println("5) EXIT");
                System.out.println("Enter the number:");
                String no1 = scanner.nextLine();
                int no = Integer.parseInt(no1);
                if (no == 1) {
                    new RoomBooking().roomBooking();
                } else if (no == 2) {
                    new RoomCancel().roomCancel();
                } else if (no == 3) {
                    new BookedDatails().details();
                } else if (no == 4) {
                    new ContactDetails().contact();
                } else if (no == 5) {
                    new HotelRoomBooking().hotelRoomBooking();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
                userPage();
            }
        }
    }
}
