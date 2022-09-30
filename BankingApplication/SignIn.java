package Bank;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SignIn {
    Connection con;

    public void signIn() {
        try {
            System.out.println("================================>> SIGN IN <<================================");
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String userName = scanner.nextLine();
            System.out.println("Enter your mail id:");
            String userMail = scanner.nextLine();
            System.out.println("Enter the password:");
            String userPassword = scanner.nextLine();
            String sql = "insert into user_sign(user_name,mail,user_password) values(?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userMail);
            preparedStatement.setString(3, userPassword);
            preparedStatement.executeUpdate();
            System.out.println("Sing in successfully...");
            System.out.println("Do you want to new account?");
            System.out.println("1) YES");
            System.out.println("2) NO");
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter the number:");
                int no = scanner1.nextInt();
                if (no == 1) {
                    new NewAccount().newAccount();
                } else if (no == 2) {
                    new UserMainPage().userPage();
                }
            }catch (Exception e){
                System.out.println("Please enter number...");
                signIn();
            }
        } catch (Exception e) {
            System.out.println("Please check your id and password...");
        }
    }
}
