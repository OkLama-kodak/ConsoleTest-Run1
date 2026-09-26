package com.example.consoletestrun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedInput {
    public static void main(String[] args) throws IOException {
        // Set up the reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter data: ");
        String data = reader.readLine(); // Reads the whole line

        System.out.println("Automated Input Received: " + data);
    }
}

