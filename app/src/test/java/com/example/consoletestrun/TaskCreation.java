package com.example.consoletestrun;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskCreation {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<String> titles = new ArrayList<>();
    static ArrayList<String> descriptions = new ArrayList<>();
    static ArrayList<String> dueDates = new ArrayList<>();
    static ArrayList<String> priorities = new ArrayList<>();
    static ArrayList<Boolean> completed = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("==========================");
            System.out.println("       TASK MANAGER");
            System.out.println("==========================");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.println("==========================");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

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

        System.out.println("\n===== CREATE TASK =====");

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter due date (MM/DD/YYYY): ");
        String dueDate = scanner.nextLine();

        System.out.print("Enter priority (Low/Medium/High): ");
        String priority = scanner.nextLine();

        titles.add(title);
        descriptions.add(description);
        dueDates.add(dueDate);
        priorities.add(priority);
        completed.add(false);

        System.out.println("\nTask created successfully!");
    }

    // VIEW TASKS
    public static void viewTasks() {

        System.out.println("\n===== YOUR TASKS =====");

        if (titles.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < titles.size(); i++) {

            System.out.println("\nTask #" + (i + 1));
            System.out.println("Title       : " + titles.get(i));
            System.out.println("Description : " + descriptions.get(i));
            System.out.println("Due Date    : " + dueDates.get(i));
            System.out.println("Priority    : " + priorities.get(i));
            System.out.println("Status      : " +
                    (completed.get(i) ? "Completed" : "Pending"));
        }
    }

    // COMPLETE TASK
    public static void completeTask() {

        if (titles.isEmpty()) {
            System.out.println("\nNo tasks available.");
            return;
        }

        viewTasks();

        System.out.print("\nEnter task number to complete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if (taskNumber >= 1 && taskNumber <= titles.size()) {

            completed.set(taskNumber - 1, true);

            System.out.println("Task completed successfully!");

        } else {
            System.out.println("Invalid task number.");
        }
    }
}