package Bank;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
    Connection con;

    public void userLogin() {
        try {
            System.out.println("================================>> USER LOGIN <<================================");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name:");
            String userName = scanner.nextLine();
            System.out.println("Enter the password:");
            String userPassword = scanner.nextLine();
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String sql = "select user_name,user_password from user_sign where user_name='" + userName + "' and " +
                    "user_password='" + userPassword + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("Login successfully...");
                new UserAccountPage().userAccount();
            } else {
                System.out.println("Please check your user name and password...");
                userLogin();
            }
        } catch (Exception e) {
            System.out.println("Please check your name and account id...");
        }

    }
}
