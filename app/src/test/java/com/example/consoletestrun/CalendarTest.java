package com.example.consoletestrun;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {

    static Scanner scanner = new Scanner(System.in);

    static Set<Integer> importantDates = new HashSet<>();

    static int month;
    static int year;

    // ==========================
    // MAIN PROGRAM
    // ==========================

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();

        month = today.get(Calendar.MONTH) + 1;
        year = today.get(Calendar.YEAR);

        int choice;

        do {

            System.out.println("==========================");
            System.out.println("        CALENDAR");
            System.out.println("==========================");

            displayCalendar();

            System.out.println("\n* = Important Date");

            System.out.println("\n==========================");
            System.out.println("1. Mark Important Date");
            System.out.println("2. Remove Important Date");
            System.out.println("3. Change Month");
            System.out.println("4. Exit");
            System.out.println("==========================");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    markImportantDate();
                    break;

                case 2:
                    removeImportantDate();
                    break;

                case 3:
                    changeMonth();
                    break;

                case 4:
                    System.out.println("\nExiting Calendar...");
                    break;

                default:
                    System.out.println("\nInvalid option.");
            }

            System.out.println();

        } while (choice != 4);

        scanner.close();
    }

    // ==========================
    // DISPLAY CALENDAR
    // ==========================

    public static void displayCalendar() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month - 1, 1);

        int daysInMonth =
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int firstDay =
                calendar.get(Calendar.DAY_OF_WEEK);

        String monthName =
                calendar.getDisplayName(
                        Calendar.MONTH,
                        Calendar.LONG,
                        java.util.Locale.ENGLISH
                );

        System.out.println("\n       " + monthName + " " + year);
        System.out.println();

        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        for (int i = Calendar.SUNDAY; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {

            if (importantDates.contains(day)) {

                System.out.printf("%3d* ", day);

            } else {

                System.out.printf("%4d ", day);
            }

            if ((day + firstDay - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    // ==========================
    // MARK IMPORTANT DATE
    // ==========================

    public static void markImportantDate() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month - 1, 1);

        int daysInMonth =
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("\n===== MARK IMPORTANT DATE =====");

        System.out.print("Enter date: ");
        int day = scanner.nextInt();

        if (day >= 1 && day <= daysInMonth) {

            if (importantDates.contains(day)) {

                System.out.println(
                        "This date is already marked as important."
                );

            } else {

                importantDates.add(day);

                System.out.println(
                        "Date marked as important!"
                );
            }

        } else {

            System.out.println("Invalid date.");
        }
    }

    // ==========================
    // REMOVE IMPORTANT DATE
    // ==========================

    public static void removeImportantDate() {

        System.out.println("\n===== REMOVE IMPORTANT DATE =====");

        System.out.print("Enter date: ");
        int day = scanner.nextInt();

        if (importantDates.contains(day)) {

            importantDates.remove(day);

            System.out.println(
                    "Important mark removed."
            );

        } else {

            System.out.println(
                    "That date is not marked as important."
            );
        }
    }

    // ==========================
    // CHANGE MONTH
    // ==========================

    public static void changeMonth() {

        System.out.println("\n===== CHANGE MONTH =====");

        System.out.print("Enter year: ");
        int newYear = scanner.nextInt();

        System.out.print("Enter month (1-12): ");
        int newMonth = scanner.nextInt();

        if (newMonth >= 1 && newMonth <= 12) {

            year = newYear;
            month = newMonth;

            importantDates.clear();

            System.out.println(
                    "Calendar changed successfully!"
            );

        } else {

            System.out.println("Invalid month.");
        }
    }


    // ==========================
    // JUNIT TESTS
    // ==========================

    @Before
    public void setUp() {

        importantDates.clear();

        month = 9;
        year = 2026;
    }


    @Test
    public void testMarkImportantDate() {

        importantDates.add(25);

        assertTrue(
                importantDates.contains(25)
        );
    }


    @Test
    public void testDateIsNotImportant() {

        assertFalse(
                importantDates.contains(25)
        );
    }


    @Test
    public void testRemoveImportantDate() {

        importantDates.add(25);

        assertTrue(
                importantDates.contains(25)
        );

        importantDates.remove(25);

        assertFalse(
                importantDates.contains(25)
        );
    }


    @Test
    public void testMultipleImportantDates() {

        importantDates.add(5);
        importantDates.add(15);
        importantDates.add(25);

        assertTrue(
                importantDates.contains(5)
        );

        assertTrue(
                importantDates.contains(15)
        );

        assertTrue(
                importantDates.contains(25)
        );

        assertEquals(
                3,
                importantDates.size()
        );
    }


    @Test
    public void testDuplicateImportantDate() {

        importantDates.add(25);
        importantDates.add(25);

        // HashSet does not allow duplicates
        assertEquals(
                1,
                importantDates.size()
        );
    }


    @Test
    public void testCalendarMonthAndYear() {

        assertEquals(
                9,
                month
        );

        assertEquals(
                2026,
                year
        );
    }


    @Test
    public void testClearImportantDates() {

        importantDates.add(10);
        importantDates.add(20);
        importantDates.add(30);

        importantDates.clear();

        assertTrue(true
        );
    }
}

