package org.example.labainfinity;

import java.sql.*;

public class DB {
    private Connection con;

    // Метод для выборки данных из таблицы
    ResultSet SelectData() throws SQLException {
        String sql = "SELECT * FROM Books";
        Statement stmt = con.createStatement();
        return stmt.executeQuery(sql);
    }

    // Метод для создания или подключения к базе данных
    void create_or_connection() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:Books.SQLite"); // Подключаемся к Books.SQLite

            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Books (\n" +
                    "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tname TEXT NOT NULL,\n" +
                    "\tage INTEGER NOT NULL,\n" +
                    "\tauthor TEXT NOT NULL,\n" +
                    "\tgenre TEXT NOT NULL\n" +
                    ");";
            stmt.execute(sql);
            stmt.close();
            System.out.println("Table 'Books' created or already exists.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Метод для вставки данных в таблицу
    void insert_data(String name, int age, String author, String genre) throws SQLException {
        String sql = "INSERT INTO Books (name, age, author, genre) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.setString(3, author);
        pstmt.setString(4, genre);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Inserted data into 'Books'.");
    }


    // Метод для очистки всех данных из таблицы Books
    void clearAllData() {
        try {
            String sql = "DELETE FROM Books"; // Удаляем все данные
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("All data cleared from 'Books'.");
        } catch (SQLException e) {
            System.out.println("Error while clearing data: " + e.getMessage());
        }
    }

    // Метод для закрытия соединения с базой данных
    void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while closing the connection: " + e.getMessage());
        }
    }
}
