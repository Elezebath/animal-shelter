package org.example.validator;

import java.util.Scanner;


public class AnimalInputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Reads and validates an integer input from the user.
     *
     * @param fieldName Name of the field being validated for error message
     * @return a valid non-negative integer entered by the user
     */
    public static int getValidInt(String fieldName) {
        while (true) {
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value < 0) {
                    System.out.println(fieldName + " cannot be negative. Try again:");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println(fieldName + " must be a valid number. Try again:");
                continue;
            }
        }
    }


    /**
     * Reads and validates a string input from the user.
     *
     * @param fieldName Name of the field being validated for error message
     * @return a valid string entered by the user
     */
    public static String getValidString(String fieldName) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                String value = String.valueOf(input);

                if (value.isEmpty()) {
                    System.out.println(fieldName + " cannot be empty. Try again:");
                    continue;
                }

                return value;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again:");
                continue;
            }
        }
    }
}
