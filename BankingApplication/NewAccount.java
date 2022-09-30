package Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NewAccount {
    Connection con;

    public void newAccount() {
        System.out.println("================================>> NEW ACCOUNT <<================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        System.out.println("Enter your date of birth:");
        String userDateOfBirth = scanner.nextLine();
        System.out.println("Enter the phone number:");
        String userPhoneNumber = scanner.nextLine();
        System.out.println("Gender:");
        String userGender = scanner.nextLine();
        System.out.println("Enter country:");
        String userCountry = scanner.nextLine();
        System.out.println("Enter state:");
        String userState = scanner.nextLine();
        System.out.println("Enter your aadhar number:");
        String userAadharNumber = scanner.nextLine();
        try {
            System.out.println("0  -> OK");
            System.out.println("1  -> CANCEL");
            System.out.println("Enter the number:");
            int no = scanner.nextInt();
            if (no == 0) {
                try {
                    String sql = "insert into new_account(user_name,date_of_birth,phone_no,gender,country,state," +
                            "aadhar) values(?,?,?,?,?,?,?);";
                    DatabaseConnection databaseConnection = new DatabaseConnection();
                    con = databaseConnection.Database();
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, userDateOfBirth);
                    preparedStatement.setString(3, userPhoneNumber);
                    preparedStatement.setString(4, userGender);
                    preparedStatement.setString(5, userCountry);
                    preparedStatement.setString(6, userState);
                    preparedStatement.setString(7, userAadharNumber);
                    preparedStatement.executeUpdate();

                } catch (Exception e) {
                    System.out.println("Database error...");
                }
                try {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("New account create successfully...");
                    System.out.println("Enter your name:");
                    String name = scanner1.nextLine();
                    System.out.println("Enter your phone number:");
                    String phoneNumber = scanner1.nextLine();
                    System.out.println("0  -> OK");
                    System.out.println("1  -> CANCEL");
                    System.out.println("Enter the number:");
                    int number = scanner.nextInt();
                    if (number == 0) {
                        try {
                            System.out.println("Your account created...");
                            DatabaseConnection databaseConnection = new DatabaseConnection();
                            con = databaseConnection.Database();
                            String sql = "select id,user_name,phone_no from new_account where user_name='" + name + "' and " +
                                    "phone_no='" + phoneNumber + "'";
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            ResultSet resultSet = preparedStatement.executeQuery();
                            if (resultSet.next()) {
                                System.out.println("YOUR NAME   :  " + resultSet.getString("user_name"));
                                System.out.println("YOUR ID     :  " + resultSet.getString("id"));
                                new UserAccountPage().userAccount();
                            } else {
                                System.out.println("Please check your name and phone number...");
                            }
                        } catch (Exception e) {
                            System.out.println("Database error...");
                        }
                    } else if (number == 1) {
                        System.out.println("Cancel...");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter number...");
                }
            } else if (no == 1) {
                System.out.println("Cancel...");
            }
        } catch (Exception e) {
            System.out.println("Please enter number...");
        }

    }
}
