package Bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AccountDetails {
    Connection con;

    public void accountDetails() {
        System.out.println("===========================>>  ACCOUNT DETAILS  <<===========================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        System.out.println("Enter your id:");
        String userId = scanner.nextLine();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String query = "select user_name,date_of_birth,phone_no,gender,country,state," +
                    "aadhar from new_account where id='" + userId + "'";
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(query);
            if (resultSet1.next()) {
                String user_name = resultSet1.getString("user_name");
                String date_of_birth = resultSet1.getString("date_of_birth");
                String phone_no = resultSet1.getString("phone_no");
                String gender = resultSet1.getString("gender");
                String country = resultSet1.getString("country");
                String state = resultSet1.getString("state");
                String aadhar = resultSet1.getString("aadhar");
                System.out.println("USER NAME           :  " + user_name);
                System.out.println("DATE OF BIRTH       :  " + date_of_birth);
                System.out.println("PHONE NO            :  " + phone_no);
                System.out.println("GENDER              :  " + gender);
                System.out.println("COUNTRY             :  " + country);
                System.out.println("STATE               :  " + state);
                System.out.println("AADHAR NUMBER       :  " + aadhar);
            }
            String query1 = "select deposit from amount where user_id='" + userId + "'";
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query1);
            if (resultSet2.next()) {
                String deposit = resultSet2.getString("deposit");
                System.out.println("AMOUNT              :  " + deposit);
            }
        } catch (Exception e) {
            System.out.println("Please check your name and account id...");
        }
    }
}
