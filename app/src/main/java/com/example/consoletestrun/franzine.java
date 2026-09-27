package com.example.consoletestrun;



public class franzine {
    public static void main(String[] args) {
        // Simulated input sequence (commands and ticket amounts in sequence)
        String[] simulatedInputs = {
                "1",   // Buy Tokens
                "2",   // Claim Prize
                "200", // Ticket count (< 500)
                "2",   // Claim Prize
                "500", // Ticket count (>= 500)
                "3"    // Exit
        };

        boolean running = true;
        int inputIndex = 0;


        while (running && inputIndex < simulatedInputs.length) {
            // Display Main Menu
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Buy Tokens");
            System.out.println("2. Claim Prize");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Read next menu choice from array
            String menuChoice = simulatedInputs[inputIndex++].trim();
            System.out.println(menuChoice); // Echo simulated user input

            switch (menuChoice) {
                case "1":
                    System.out.println("-> [Action] Processing Token Purchase...");
                    break;

                case "2":
                    System.out.println("-> [Action] Opening Prize Submenu...");
                    System.out.print("Enter your ticket count: ");

                    // Ensure there is a simulated input available for the ticket count
                    if (inputIndex < simulatedInputs.length) {
                        String ticketInput = simulatedInputs[inputIndex++].trim();
                        System.out.println(ticketInput); // Echo simulated ticket input

                        int ticketCount = Integer.parseInt(ticketInput);

                        if (ticketCount < 500) {
                            System.out.println("-> Keep Playing! (Need at least 500 tickets)");
                        } else {
                            System.out.println("-> Claiming prize!");
                        }
                    } else {
                        System.out.println("-> Error: Missing ticket count input.");
                    }
                    break;

                case "3":
                    System.out.println("-> Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("-> Invalid option.");
                    break;
            }
        }

        if (inputIndex >= simulatedInputs.length && running) {
            System.out.println("\n[SYSTEM] No more simulated inputs available.");
        }
    }
}
