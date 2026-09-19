package com.example.consoletestrun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int rows;
        int columns;
        char symbol;

        System.out.println("Enter the # of rows");
        rows = scanner.nextInt();

        System.out.println("Enter the # of columns");
        columns = scanner.nextInt();

        System.out.println("Enter your symbol");
        symbol = scanner.next().charAt(0);

        scanner.close();
    }
}
