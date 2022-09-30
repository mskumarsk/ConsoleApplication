package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AccountBlock {
    Connection con;

    public void accountBlock() {
        System.out.println("================================>> ACCOUNT BLOCK  <<================================");
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter customer account number:");
            int accountNumber = scanner.nextInt();
            String query3 = "delete from new_account where id='" + accountNumber + "'";
            PreparedStatement preparedStatement1 = con.prepareStatement(query3);
            preparedStatement1.executeUpdate();
            System.out.println("Account delete successfully...");
        } catch (Exception e) {
            System.out.println("Please check your account number...");
        }
    }
}
