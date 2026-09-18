package com.example.consoletestrun;

import java.util.ArrayList;
import java.util.Scanner;

public class NotificationAdd { // Added class declaration

    private static final Scanner scanner = new Scanner(System.in);

    private static final ArrayList<String> titles = new ArrayList<>();
    private static final ArrayList<String> descriptions = new ArrayList<>();
    private static final ArrayList<String> dueDates = new ArrayList<>(); // Renamed variable usage below
    private static final ArrayList<String> priorities = new ArrayList<>();
    private static final ArrayList<Boolean> completed = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("==========================");
            System.out.println("        NOTIFICATIONS");
            System.out.println("==========================");
            System.out.println("1. Add Notification");
            System.out.println("2. View Notification");
            System.out.println("3. Edit Notification");
            System.out.println("4. Exit");
            System.out.println("==========================");

            System.out.print("Choose an option: ");

            // Check for valid integer input to prevent InputMismatchException
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                choice = 0;
                continue;
            }

            switch (choice) {

                case 1:
                    createTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    completeTask();
                    break;

                case 4:
                    System.out.println("\nExiting Task Manager...");
                    break;

                default:
                    System.out.println("\nInvalid option.");
            }

            System.out.println();

        } while (choice != 4);

        scanner.close();
    }

    // CREATE TASK
    public static void createTask() {

        System.out.println("\n===== CREATE NOTIFICATION =====");

        System.out.print("Enter notification name: ");
        String title = scanner.nextLine();

        System.out.print("Enter notification description: ");
        String description = scanner.nextLine();

        System.out.print("Enter due time (HH:MM/PM/AM): ");
        String dueDate = scanner.nextLine();

        System.out.print("Enter priority (Low/Medium/High): ");
        String priority = scanner.nextLine();

        titles.add(title);
        descriptions.add(description);
        dueDates.add(dueDate);
        priorities.add(priority);
        completed.add(false);

        System.out.println("\nNotification created successfully!");
    }

    // VIEW TASKS
    public static void viewTasks() {

        System.out.println("\n===== YOUR NOTIFICATION =====");

        if (titles.isEmpty()) {
            System.out.println("No notification available.");
            return;
        }

        for (int i = 0; i < titles.size(); i++) {

            System.out.println("\nNotification #" + (i + 1));
            System.out.println("Title       : " + titles.get(i));
            System.out.println("Description : " + descriptions.get(i));
            System.out.println("Due Time    : " + dueDates.get(i)); // Fixed: changed dueTime to dueDates
            System.out.println("Priority    : " + priorities.get(i));
            System.out.println("Status      : " +
                    (completed.get(i) ? "Completed" : "Pending"));
        }
    }

    // COMPLETE TASK
    public static void completeTask() {

        if (titles.isEmpty()) {
            System.out.println("\nNo Notification available.");
            return;
        }

        viewTasks();

        System.out.print("\nEnter Notification number to complete: ");

        if (scanner.hasNextInt()) {
            int taskNumber = scanner.nextInt();
            scanner.nextLine();

            if (taskNumber >= 1 && taskNumber <= titles.size()) {
                completed.set(taskNumber - 1, true);
                System.out.println("Notification Passed Successfully!");
            } else {
                System.out.println("Invalid Notification number.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid task number.");
            scanner.nextLine();
        }
    }
}