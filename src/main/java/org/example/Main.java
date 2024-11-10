package org.example;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager  = new DatabaseManager();
        try {
            dbManager.connect();
//            dbManager.addBook("Nineteen Eighty-Four", "George Orwell", Date.valueOf("1949-06-08"), "978-0451524935");
//            System.out.println(dbManager.findBookByTitle("War and Peace"));
//            dbManager.deleteBook(1);
            System.out.println(dbManager.getAllBooks());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbManager.disconnect();
        }
    }
}