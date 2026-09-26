package com.example.consoletestrun;


import java.io.IOException;

public class MenuLoop {
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Say Hello");
            System.out.println("2. Say Goodbye");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                // Read a single character byte from the console
                int input = System.in.read();

                // Consume any leftover newline characters (\r or \n) in the buffer
                while (System.in.available() > 0) {
                    System.in.read();
                }

                // Convert byte back to char and evaluate
                char choice = (char) input;

                switch (choice) {
                    case '1':
                        System.out.println("-> Hello World!");
                        break;
                    case '2':
                        System.out.println("-> Goodbye World!");
                        break;
                    case '3':
                        System.out.println("-> Exiting program...");
                        running = false;
                        break;
                    default:
                        System.out.println("-> Invalid choice. Please try again.");
                        break;
                }

            } catch (IOException e) {
                System.out.println("Error reading input.");
            }
        }
    }
}
