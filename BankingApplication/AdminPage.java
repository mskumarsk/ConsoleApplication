package Bank;

import java.util.Scanner;

public class AdminPage {
    public void adminPage() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1) VIEW ACCOUNTS");
                System.out.println("2) ACCOUNT BLOCK");
                System.out.println("3) EXIT");
                System.out.println("Enter the number:");
                int no = scanner.nextInt();
                if (no == 1) {
                    new ViewAccount().view();
                } else if (no == 2) {
                    new AccountBlock().accountBlock();
                } else if (no == 3) {
                    BankMain bankMain = new BankMain();
                    bankMain.mainPage();
                }
            }catch (Exception e){
                System.out.println("Please enter number...");
            }
        }
    }
}
