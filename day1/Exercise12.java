package day1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise12 {
    public static int getNumberFromUser(Scanner scanner) {
        System.out.println("What is your age?");
        try {
            int input = scanner.nextInt();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Invalid number. Enter a whole number");
            return getNumberFromUser(scanner);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        int age = getNumberFromUser(scanner);

        if (age > 19) {
            System.out.println("You are a boomer");
        } else if (age > 12) {
            System.out.println("You are a teenager");
        } else {
            System.out.println("You are a child");
        }
    }
}