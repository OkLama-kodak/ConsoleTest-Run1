package com.example.consoletestrun;

import java.util.Scanner;

public class ConsoleMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getUserChoice(scanner);

            // Traditional switch statement
            switch (choice) {
                case 1:
                    System.out.println("\n -> Starting a new game...");
                    break;
                case 2:
                    System.out.println("\n -> Loa ding settings...");
                    break;
                case 3:
                    System.out.println("\n -> Displaying leaderboard...");
                    break;
                case 4:
                    System.out.println("\nExiting application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\n[!] Invalid choice. Please select 1-4.");
                    break;
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=================================");
        System.out.println("            MAIN MENU            ");
        System.out.println("=================================");
        System.out.println("1. Start New Game");
        System.out.println("2. Load Settings");
        System.out.println("3. View Leaderboard");
        System.out.println("4. Exit");
        System.out.print("Enter choice (1-4): ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("\n[!] Error: Please enter a valid number.");
            System.out.print("Enter choice (1-4): ");
            scanner.next(); // Clear non-integer input
        }
        return scanner.nextInt();
    }
}