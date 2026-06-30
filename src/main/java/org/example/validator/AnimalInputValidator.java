package org.example.validator;

import java.util.Scanner;


public class AnimalInputValidator {
    /**
     * Reads and validates an integer input from the user.
     *
     * @param fieldName Name of the field being validated for error message
     * @return a valid non-negative integer entered by the user
     */
    public static int getValidInt(Scanner scanner,String fieldName) {
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
            }
        }
    }


    /**
     * Reads and validates a string input from the user.
     *
     * @param fieldName Name of the field being validated for error message
     * @return a valid string entered by the user
     */
    public static String getValidString(Scanner scanner,String fieldName) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(fieldName + " cannot be empty. Try again:");
                continue;
            }

            return input;
        }
    }
}
