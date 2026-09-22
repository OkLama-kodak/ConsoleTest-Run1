package com.example.consoletestrun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adobo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();
        List<String> notifications = new ArrayList<>();

        // Add default items
        tasks.add("Complete Peta 3");
        tasks.add("Fix Adminerva bug");

        notifications.add("You have 2 new messages.");
        notifications.add("Task deadline approaching.");

        int choice = 0;

        System.out.println("===============================");
        System.out.println("     WELCOME TO BUZZERS        ");
        System.out.println("===============================");

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. See task list");
            System.out.println("2. See notification list");
            System.out.println("3. Settings");
            System.out.println("4. Leave");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextLine()) {
                System.out.println("\nNo standard input provided. Exiting.");
                break;
            }

            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- TASK LIST ---");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;

                case 2:
                    System.out.println("\n--- NOTIFICATIONS ---");
                    if (notifications.isEmpty()) {
                        System.out.println("(No new notifications)");
                    } else {
                        for (int i = 0; i < notifications.size(); i++) {
                            System.out.println((i + 1) + ". " + notifications.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- SETTINGS ---");
                    System.out.println("A. Reset App");
                    System.out.println("B. Fix Bug/s");
                    System.out.print("Select an option: ");

                    if (!scanner.hasNextLine()) {
                        break;
                    }
                    String settingChoice = scanner.nextLine().trim().toUpperCase();
                    if (settingChoice.equals("A")) {
                        System.out.println("-> Resetting the app...");
                        choice = 4;
                    } else if (settingChoice.equals("B")) {
                        System.out.println("->Bug/s fixed!");
                    } else {
                        System.out.println("-> Returning to main menu.");
                    }
                    break;

                case 4:
                    System.out.println("\nGoodbye! Thanks for using Buzzers.");
                    break;

                default:
                    System.out.println("\nInvalid option! Please select 1, 2, 3, or 4.");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }
}