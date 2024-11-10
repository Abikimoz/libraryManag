package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseManager {

    private Connection connection;

    public void connect () throws IOException {
        Properties prop = new Properties();
        Path envFilePath = Paths.get("src/main/java/org/example/example.env");
        try (var inputStram = Files.newInputStream(envFilePath)) {
            prop.load(inputStram);
        }
        String connectionString = "jdbc:postgresql://localhost:5432/";
        String dbName = (String) prop.get("DB_NAME");
        String dbUser = (String) prop.get("DB_USER");
        String dbPassword = (String) prop.get("DB_PASSWORD");

        try {
            connection = DriverManager.getConnection(connectionString + dbName, dbUser, dbPassword);
            if (connection != null) {
                System.out.println("Connection done!");
            }
            else {
                System.out.println("Connection failed");
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
        else {
            System.out.println("Connection is missing");
        }
    }

    public void addBook(String title, String author, Date publishedDate, String isbn) throws SQLException {
        String query = "INSERT INTO books (title, author, \"publishedDate\", isbn) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setDate(3, publishedDate);
            stmt.setString(4, isbn);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBooks() {
        List<String> books = new ArrayList<>();
        String query = "SELECT title FROM books";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                books.add(rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

}
