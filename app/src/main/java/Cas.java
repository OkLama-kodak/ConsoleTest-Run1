import java.util.Scanner;

public class Cas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       int rows;
       int columns;
       String word;

       System.out.println("Enter the # of rows: ");
       rows = scanner.nextInt();

       System.out.println("Enter the # of columns: ");
       columns = scanner.nextInt();

       System.out.println("Enter your word: ");
       word = scanner.next();

       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < columns; j++) {
               System.out.print(word);
           }
           System.out.println();
       }


       scanner.close();
    }
}
