import java.util.Scanner;

public class Cas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("Welcome to Buzzers\n");

        // Fixed: Changed from (choice != 3) to (choice != 4) so 3 can run
        while (choice != 4) {
            System.out.println("--- MENU ---");
            System.out.println("1. See task list");
            System.out.println("2. See notification list");
            System.out.println("3. Settings");
            System.out.println("4. Leave");
            System.out.print("Enter your choice: ");

            // Read the user's menu choice
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.next(); // Clear invalid input
                continue;
            }

            // Handle the option selected by the user
            switch (choice) {
                case 1:
                    System.out.println("\n--- TASK LIST ---");
                    System.out.println("- Task 1: Complete Peta 3");
                    System.out.println("- Task 2: Fix Adminerva\n");
                    break;

                case 2:
                    System.out.println("\n--- NOTIFICATIONS ---");
                    System.out.println("- You have 2 new messages.");
                    System.out.println("- Task deadline approaching.\n");
                    break;

                case 3:
                    System.out.println("\n--- SETTINGS ---");
                    System.out.println("- Reset App.");
                    System.out.println("- Fix bug.\n");
                    break;

                case 4:
                    System.out.println("\nGoodbye! Thanks for using Buzzers.");
                    break;

                default:
                    System.out.println("\nInvalid option! Please select 1, 2, 3, or 4.\n");
                    break;
            }
        }

        scanner.close();
    }
}