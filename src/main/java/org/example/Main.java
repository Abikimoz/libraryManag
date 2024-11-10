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
//            dbManager.addBook("The Master and Margarita", "Mikhail Bulgakov", Date.valueOf("1966-11-26"), "978-0141180144");
//            dbManager.addBook("Crime and Punishment", "Fyodor Dostoevsky", Date.valueOf("1866-12-21"), "978-0486415871");
//            dbManager.addBook("War and Peace", "Leo Tolstoy", Date.valueOf("1867-01-01"), "978-0679600848");
//            dbManager.addBook("The Lord of the Rings", "J.R.R. Tolkien", Date.valueOf("1954-07-29"), "978-0547928241");
            System.out.println(dbManager.findBookByTitle("War and Peace"));
//            dbManager.deleteBook(1);
            System.out.println(dbManager.getAllBooks());

//            dbManager.addReader("Иван Иванов", "ivan_ivanov@example.com");
//            dbManager.addReader("Марина Петрова", "marina_petrova@example.com");
//            dbManager.addReader("Алексей Сидоров", "alexey_sidorov@example.com");
//            dbManager.addReader("Елена Васильева", "elena_vasileva@example.com");
//            dbManager.addReader("Дмитрий Кузнецов", "dmitry_kuznetsov@example.com");
            System.out.println(dbManager.getAllReaders());
            System.out.println(dbManager.findReaderByEmail("elena_vasileva@example.com"));
//            dbManager.deleteReader(3);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbManager.disconnect();
        }
    }
}