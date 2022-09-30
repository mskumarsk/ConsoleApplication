package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Withdraw {
    Connection con;

    public void withdraw() {
        System.out.println("================================>> WITHDRAW <<================================");
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter user name:");
            String name = scanner.nextLine();
            System.out.println("Enter your id:");
            String userId = scanner.nextLine();
            String sql = "select * from amount where user_id='" + userId + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("YOUR DEPOSIT AMOUNT   :  " + resultSet.getString("deposit"));
                System.out.println("Enter withdraw amount:");
                String withdrawAmount = scanner.nextLine();
                String query = "select * from amount where user_id='" + userId + "'";
                Statement statement1 = con.createStatement();
                ResultSet resultSet1 = statement1.executeQuery(query);
                if (resultSet1.next()) {
                    String deposit = resultSet1.getString("deposit");
                    if (Integer.parseInt(withdrawAmount) <= Integer.parseInt(deposit)) {
                        int amount = Integer.parseInt(deposit) - Integer.parseInt(withdrawAmount);
                        String query3 = "update amount set deposit='" + amount + "' where user_id='" + userId + "'";
                        PreparedStatement preparedStatement4 = con.prepareStatement(query3);
                        preparedStatement4.executeUpdate();
                        String query4 = "insert into withdraw (user_id,user_name,withdraw) values (?,?,?);";
                        PreparedStatement preparedStatement2 = con.prepareStatement(query4);
                        preparedStatement2.setString(1, userId);
                        preparedStatement2.setString(2, name);
                        preparedStatement2.setString(3, withdrawAmount);
                        preparedStatement2.executeUpdate();
                        System.out.println("Withdraw successfully...");
                    }
                }
            } else {
                System.out.println("Please check your id...");
            }
        } catch (Exception e) {
            System.out.println("Please check your name and account id...");
        }
    }
}
