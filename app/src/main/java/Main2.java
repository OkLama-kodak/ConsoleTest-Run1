import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main2 {
    public static void main(String[] args) {

        int rows = 3;
        int columns = 3;
        String word = "*";

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
            } else {
                System.out.println("No input available. Using default: 3");
            }

            System.out.print("Enter the number of columns: ");
            if (scanner.hasNextInt()) {
                columns = scanner.nextInt();
            } else {
                System.out.println("No input available. Using default: 3");
            }

            System.out.print("Enter the word to be printed: ");
            if (scanner.hasNext()) {
                word = scanner.next();
            } else {
                System.out.println("No input available. Using default: *");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No standard input provided. Using defaults.");
        }

        System.out.println("\nResult Grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(word);
            }
            System.out.println();
        }

        scanner.close();
    }
}

