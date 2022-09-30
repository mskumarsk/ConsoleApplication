package Bank;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        BankMain bankMain = new BankMain();
        bankMain.mainPage();
    }
    public void mainPage() {
        while (true) {
            System.out.println("================================>> WELCOME  <<================================");
            System.out.println("1) ADMIN");
            System.out.println("2) USER");
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number:");
                int no = scanner.nextInt();
                if (no == 1) {
                    new AdminMainPage().adminPage();
                } else {
                    new UserMainPage().userPage();
                }
            }catch (Exception e){
                System.out.println("Please enter number...");
            }
        }
    }
}
