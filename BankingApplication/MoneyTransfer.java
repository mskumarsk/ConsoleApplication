package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MoneyTransfer {
    Connection con;

    public void moneyTransfer() {
        System.out.println("================================>> MONEY TRANSFER <<================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String username = scanner.nextLine();
        System.out.println("Enter your id:");
        String userId = scanner.nextLine();
        System.out.println("Receiver account id:");
        String receiverId = scanner.nextLine();
        int amount = 0;
        String transferAmount = "";
        int deposit = 0;
        int senderDeposit = 0;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String sql = "select * from amount where user_id='" + userId + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("YOUR DEPOSIT AMOUNT   :  " + resultSet.getString("deposit"));
                String senderDepositAmount = resultSet.getString("deposit");
                senderDeposit = Integer.parseInt(senderDepositAmount);
            }
            System.out.println("Enter amount:");
            transferAmount = scanner.nextLine();
            String sql1 = "select * from amount where user_id='" + receiverId + "'";
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(sql1);
            if (resultSet1.next()) {
                deposit = Integer.parseInt(resultSet1.getString("deposit"));
                amount = deposit + Integer.parseInt(transferAmount);
            }
        } catch (Exception e) {
            System.out.println("Please check your name and account id...");
        }
        try {
            System.out.println("0  -> OK");
            System.out.println("1  -> CANCEL");
            System.out.println("Enter the number:");
            int no = scanner.nextInt();
            if (no == 0) {
                String query3 = "update amount set deposit='" + amount + "' where user_id='" + receiverId + "'";
                PreparedStatement preparedStatement1 = con.prepareStatement(query3);
                preparedStatement1.executeUpdate();

                int senderAmount = senderDeposit - Integer.parseInt(transferAmount);
                String query6 = "update amount set deposit='" + senderAmount + "' where user_id='" + userId + "'";
                PreparedStatement preparedStatement6 = con.prepareStatement(query6);
                preparedStatement6.executeUpdate();

                String query4 = "insert into withdraw (user_id,user_name,withdraw) values (?,?,?);";
                PreparedStatement preparedStatement2 = con.prepareStatement(query4);
                preparedStatement2.setString(1, userId);
                preparedStatement2.setString(2, username);
                preparedStatement2.setString(3, transferAmount);
                preparedStatement2.executeUpdate();
                System.out.println("Transfer successfully...");
            } else if (no == 1) {
                System.out.println("Cancel...");
            }
        } catch (Exception e) {
            System.out.println("Please enter number...");
        }
    }
}
