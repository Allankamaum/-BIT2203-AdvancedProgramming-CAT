package com.jkuat.cat.q2;

import java.sql.*;

public class UniversityDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/university_db";
        String user = "admin";
        String password = "secure123";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String createTable = "CREATE TABLE IF NOT EXISTS courses (" +
                    "course_id INT PRIMARY KEY, " +
                    "course_name VARCHAR(100), " +
                    "credits INT, " +
                    "department VARCHAR(50))";
            stmt.executeUpdate(createTable);

            stmt.executeUpdate("INSERT INTO courses VALUES (1, 'Data Structures', 3, 'Computer Science')");
            stmt.executeUpdate("INSERT INTO courses VALUES (2, 'Financial Accounting', 3, 'Business')");
            stmt.executeUpdate("INSERT INTO courses VALUES (3, 'Database Systems', 4, 'Computer Science')");

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM courses WHERE department = 'Computer Science'");
            while (rs.next()) {
                System.out.println(rs.getInt("course_id") + " - " +
                        rs.getString("course_name") + " (" + rs.getInt("credits") + " credits)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}