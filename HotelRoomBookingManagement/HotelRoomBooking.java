import java.util.Scanner;

public class HotelRoomBooking extends AdminLogin {
    public static void main(String[] args) {
        HotelRoomBooking hotelRoomBooking = new HotelRoomBooking();
        hotelRoomBooking.hotelRoomBooking();
    }

    public void hotelRoomBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================>> HOTEL ROOM BOOKING <<=======================" +
                "==================");
        while (true) {
            try {
                System.out.println("1) ADMIN");
                System.out.println("2) USER");
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
                                new AdminPage().admin();
                            } else {
                                System.out.println("Incorrect password...");
                            }
                        } else {
                            System.out.println("Admin name is wrong...");
                        }
                    }
                } else if (number == 2) {
                    new UserPage().userPage();
                }
            } catch (Exception e) {
                System.out.println("Please enter number...");
                hotelRoomBooking();
            }
        }
    }
}
