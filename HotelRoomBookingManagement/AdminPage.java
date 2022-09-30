import java.util.Scanner;

public class AdminPage {
    public void admin() {
        while (true) {
            try {
                System.out.println("=================================== ADMIN PAGE ===================================");
                System.out.println("1) BOOKED ROOMS");
                System.out.println("2) CONTACT UPLOAD");
                System.out.println("3) EXIT");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number:");
                int number = scanner.nextInt();
                if (number == 1) {
                    new BookedRoomDetails().bookedRoom();
                } else if (number == 2) {
                    new UpdateContact().updateContact();
                } else if (number == 3) {
                    new HotelRoomBooking().hotelRoomBooking();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
                admin();
            }
        }
    }
}
