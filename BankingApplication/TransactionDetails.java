package Bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDetails {
    Connection con;

    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void transaction() {
        System.out.println("================================>> TRANSACTION DETAILS <<================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your id:");
        String user_id = scanner.nextLine();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String query2 = "select * from deposit where user_id='" + user_id + "'";
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);
            System.out.println("==================================================>>  DEPOSIT DETAILS  <<=========" +
                    "=======================================");
            System.out.print(" ======================================================================");
            System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(20,
                    "DEPOSIT") + " | " + centerString(20, "DATE") + " | ");
            System.out.print("\n ======================================================================");
            while (resultSet2.next()) {
                String name = resultSet2.getString("user_name");
                String deposit = resultSet2.getString("deposit");
                String date = resultSet2.getString("deposit_date");
                System.out.printf("\n | " + centerString(20, name) + " | " + centerString(20,
                        deposit) + " | " + centerString(20, date) + " | ");
            }
            System.out.print("\n ======================================================================");
            System.out.println();

            String query3 = "select * from withdraw where user_id='" + user_id + "'";
            Statement statement3 = con.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(query3);
            System.out.println("==================================================>>  WITHDRAW DETAILS  <<=======" +
                    "=========================================");
            System.out.print(" ======================================================================");
            System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(20,
                    "WITHDRAW") + " | " + centerString(20, "DATE") + " | ");
            System.out.print("\n ======================================================================");
            while (resultSet3.next()) {
                String name = resultSet3.getString("user_name");
                String withdraw = resultSet3.getString("withdraw");
                String date = resultSet3.getString("withdraw_date");
                System.out.printf("\n | " + centerString(20, name) + " | " + centerString(20,
                        withdraw) + " | " + centerString(20, date) + " | ");
            }
            System.out.print("\n ======================================================================");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Please check your name and account id...");
        }
    }
}
