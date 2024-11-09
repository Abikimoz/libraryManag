package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        DatabaseManager connects = new DatabaseManager();
        connects.connect();
    }
}