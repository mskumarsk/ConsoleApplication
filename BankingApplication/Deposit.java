package Bank;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Deposit {
    Connection con;

    public void deposit() {
        System.out.println("================================>> DEPOSIT <<================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        System.out.println("Enter your id:");
        String userId = scanner.nextLine();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String sql = "select * from new_account where user_name='" + name + "' and id='" + userId + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                try {
                    System.out.println("Enter deposit amount:");
                    String depositAmount = scanner.nextLine();
                    System.out.println("0  -> OK");
                    System.out.println("1  -> CANCEL");
                    System.out.println("Enter the number:");
                    int no = scanner.nextInt();
                    if (no == 0) {
                        String query = "insert into deposit (user_id,user_name,deposit) values (?,?,?);";
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, userId);
                        preparedStatement.setString(2, name);
                        preparedStatement.setString(3, depositAmount);
                        preparedStatement.executeUpdate();
                        System.out.println("Deposit successfully...");
                        try {
                            String query1 = "select * from amount where user_id='" + userId + "'";
                            Statement statement1 = con.createStatement();
                            ResultSet resultSet1 = statement1.executeQuery(query1);
                            if (resultSet1.next()) {
                                String amount = resultSet1.getString("deposit");
                                int amo = Integer.parseInt(amount);
                                int totAmount = amo + Integer.parseInt(depositAmount);
                                String query3 = "update amount set deposit='" + totAmount + "' where user_id='" + userId + "'";
                                PreparedStatement preparedStatement1 = con.prepareStatement(query3);
                                preparedStatement1.executeUpdate();
                            } else {
                                String query4 = "insert into amount (user_id,user_name,deposit) values (?,?,?);";
                                PreparedStatement preparedStatement2 = con.prepareStatement(query4);
                                preparedStatement2.setString(1, userId);
                                preparedStatement2.setString(2, name);
                                preparedStatement2.setString(3, depositAmount);
                                preparedStatement2.executeUpdate();
                            }
                        } catch (Exception e) {
                            System.out.println("Please check your id...");
                        }
                    } else if (no == 1) {
                        System.out.println("Cancel...");
                    }
                }catch (Exception e){
                    System.out.println("Please enter number...");
                }
            } else {
                System.out.println("Please check your user name and password...");
            }
        } catch (Exception e) {
            System.out.println("Database connection error...");
        }
    }
}
