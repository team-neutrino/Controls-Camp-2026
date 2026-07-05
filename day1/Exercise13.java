package day1;

import java.util.InputMismatchException;
import java.util.Scanner;

// this one is actually kinda hard tbh I didn't expect it to be this complicated

public class Exercise13 {
    public static String getCharFromUser(Scanner scanner) {
        System.out.println("Enter an operation: ");

        String input = scanner.nextLine();

        if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
            return input;
        } else {
            System.out.println("Invalid operation. Enter +, -, *, or /.");
            return getCharFromUser(scanner);
        }
    }

    public static double getNumberFromUser(Scanner scanner) {
        System.out.println("Enter a number: ");

        try {
            double input = scanner.nextDouble();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Invalid number.");
            return getNumberFromUser(scanner);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in); // they must create it here and pass it in as a parameter
        // I guess they could just have a memory leak in the code too but if they follow
        // Java's directions and close the scanner it will close System.in forever and it won't work anymore

        String operation = getCharFromUser(scanner);
        double num1 = getNumberFromUser(scanner);
        double num2 = getNumberFromUser(scanner);

        if (operation.equals("+")) {
            System.out.println(num1 + " " + operation + " " + num2 + " = " + (num1 + num2));
        } else if (operation.equals("-")) {
            System.out.println(num1 + " " + operation + " " + num2 + " = " + (num1 - num2));
        } else if (operation.equals("*")) {
            System.out.println(num1 + " " + operation + " " + num2 + " = " + (num1 * num2));
        } else if (operation.equals("/")) {
            System.out.println(num1 + " " + operation + " " + num2 + " = " + (num1 / num2));
        }
    }
}