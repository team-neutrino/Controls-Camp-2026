package day1;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise14 {
    public static double getNumberFromUser(Scanner scanner) {
        System.out.println("Enter a number");
        try {
            double input = scanner.nextDouble();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Invalid number. Enter a whole number");
            return getNumberFromUser(scanner);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        double number = getNumberFromUser(scanner);

        TreeMap<Double, Double> map = new TreeMap<Double, Double>();
        map.put(0.0, 0.0);
        map.put(15.0, 20.0);
        map.put(20.0, 36.2);
        map.put(30.5, 38.0);

        Map.Entry<Double, Double> bound1 = map.floorEntry(number);
        Map.Entry<Double, Double> bound2 = map.ceilingEntry(number);

        double divisor = bound2.getKey();
        if (divisor == 0) {
            divisor = 1;
        }

        double percent = (bound1.getKey() + (number - bound1.getKey())) / bound2.getKey();
        double value = bound1.getValue() + ((bound2.getValue() - bound1.getValue()) * percent);

        System.out.println(value);
    }
}