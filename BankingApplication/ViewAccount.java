package Bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

public class ViewAccount {
    Connection con;

    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void view() {
        System.out.println("================================>> VIEW ACCOUNTS <<================================");
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.Database();
            String query1 = "select * from new_account";
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(query1);
            System.out.println("========================================================================" +
                    "=============>>  ACCOUNTS DETAILS  <<============================================" +
                    "============================");
            System.out.print(" =============================================================================" +
                    "==========================================================================================" +
                    "=============");
            System.out.printf("\n | " + centerString(15, "ID") + " | " + centerString(20,
                    "NAME") + " | " + centerString(20, "DATE OF BIRTH") + " | " + centerString(20,
                    "PHONE NO") + " | " + centerString(20, "GENDER") + " | " + centerString(20,
                    "COUNTRY") + " | " + centerString(20, "STATE") + " | " + centerString(20,
                    "AADHAR") + " | ");
            System.out.print("\n =========================================================================" +
                    "=====================================================================================" +
                    "======================");
            while (resultSet1.next()) {
                String id = resultSet1.getString("id");
                String user_name = resultSet1.getString("user_name");
                String date_of_birth = resultSet1.getString("date_of_birth");
                String phone_no = resultSet1.getString("phone_no");
                String gender = resultSet1.getString("gender");
                String country = resultSet1.getString("country");
                String state = resultSet1.getString("state");
                String aadhar = resultSet1.getString("aadhar");
                System.out.printf("\n | " + centerString(15, id) + " | " + centerString(20,
                        user_name) + " | " + centerString(20, date_of_birth) + " | " + centerString(20,
                        phone_no) + " | " + centerString(20, gender) + " | " + centerString(20,
                        country) + " | " + centerString(20, state) + " | " + centerString(20, aadhar) + " | ");
            }
            System.out.print("\n ==============================================================================" +
                    "==========================================================================================" +
                    "============");
            System.out.println();
            String query2 = "select * from amount";
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);
            System.out.println("==================================================>>  AMOUNT DETAILS  <<=======" +
                    "=========================================");
            System.out.print(" =================================================================");
            System.out.printf("\n | " + centerString(15, "ID") + " | " + centerString(20,
                    "NAME") + " | " + centerString(20, "AMOUNT") + " | ");
            System.out.print("\n =================================================================");
            while (resultSet2.next()) {
                String id = resultSet2.getString("user_id");
                String user_name = resultSet2.getString("user_name");
                String amount = resultSet2.getString("deposit");
                System.out.printf("\n | " + centerString(15, id) + " | " + centerString(20,
                        user_name) + " | " + centerString(20, amount) + " | ");
            }
            System.out.print("\n =================================================================");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Database error...");
        }
    }
}
