package Bank;

import java.net.PortUnreachableException;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.Scanner;

public class UserMainPage {
    public void userPage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("================================>> USER PAGE  <<================================");
                System.out.println("1) LOGIN");
                System.out.println("2) SIGN IN");
                System.out.println("3) NEW ACCOUNT");
                System.out.println("4) EXIT");
                System.out.println("Enter the number:");
                int no = scanner.nextInt();
                if (no == 1) {
                    new UserLogin().userLogin();
                } else if (no == 2) {
                    new SignIn().signIn();
                } else if (no == 3) {
                    new NewAccount().newAccount();
                } else if (no == 4) {
                    new BankMain().mainPage();
                }
            }catch (Exception e){
                System.out.println("Please enter number...");
            }
        }
    }
}
