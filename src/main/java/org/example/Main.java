package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DatabaseManager dbManager  = new DatabaseManager();
        try {
            dbManager.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            dbManager.disconnect();
        }
    }
}