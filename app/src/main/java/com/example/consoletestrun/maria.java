package com.example.consoletestrun;

import java.io.IOException;

public class maria {
    public static void main(String[] args) {
        boolean running = true;
        int choice = 0; // Tracks menu state

        // Simulated input sequence running THREE scenarios back-to-back
        String[] simulatedInputs = {
                // Scenario 1: Low ticket count (< 500)
                "1",   // Step 1: Choose Buy Tokens
                "2",   // Step 2: Choose Claim Prize
                "200", // Step 2 cont: Enter 200 tickets (Expected: Keep Playing)

                // Scenario 2: Successful ticket count (>= 500)
                "2",   // Choose Claim Prize again
                "500", // Enter 500 tickets (Expected: Claiming prize!)

                // Scenario 3: Exit Option
                "3"    // Choose Exit (Expected: Exiting program...)
        };
        int inputIndex = 0; // Tracks the current position in our sequence

        while (running) {
            // Main menu display placeholder
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Buy Tokens");
            System.out.println("2. Claim Prize");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Replaces scanner.hasNextLine() check
            if (inputIndex >= simulatedInputs.length) {
                System.out.println("\n[SYSTEM] No more simulated inputs. Stopping.");
                break;
            }

            // Step 1 & 2: Replaces scanner.nextLine().trim() for menu choices
            String menuChoice = simulatedInputs[inputIndex++].trim();
            System.out.println(menuChoice); // Echo the choice

            if (menuChoice.equals("1")) {
                System.out.println("-> [Action] Processing Token Purchase...");
                // Add token buying logic here

            } else if (menuChoice.equals("2")) {
                System.out.println("-> [Action] Opening Prize Submenu...");
                System.out.print("Enter your ticket count: ");

                // Safety check before reading the next nested input
                if (inputIndex >= simulatedInputs.length) break;

                // Step 2 cont: Replaces the scanner read for ticket amounts
                String ticketInput = simulatedInputs[inputIndex++].trim();
                System.out.println(ticketInput); // Echo the ticket input

                // Convert string to integer manually
                int ticketCount = Integer.parseInt(ticketInput);

                // Evaluation logic
                if (ticketCount < 500) {
                    System.out.println("-> Keep Playing! (Need at least 500 tickets)");
                } else {
                    System.out.println("-> Claiming prize!");
                }
            } else if (menuChoice.equals("3")) {
                System.out.println("-> Exiting program...");
                running = false; // Gracefully breaks the while loop condition
            } else {
                System.out.println("-> Invalid option.");
            }
        }
    }
}

