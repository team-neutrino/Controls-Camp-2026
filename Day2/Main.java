package Day2;

public class Main {
    private static int m_integer = 5;
    private static double m_decimal = 5.5;
    private static String m_string = "Hello";
    private static boolean m_boolean = true;

    public static void printVariables(int number, double decimal, String word, boolean bool) {
        System.out.println(number);
        System.out.println(decimal);
        System.out.println(word);
        System.out.println(bool);
    }

    public static void plusOne(int argument) {
        System.out.println(argument + 1);
    }

    public static void greaterNumber(int number1, int number2) {
        if (number1 > number2) {
            System.out.println(number1);
        } else if (number2 > number1) {
            System.out.println(number2);
        } else {
            System.out.println("Both numbers are equal");
        }

    }

    public static double absoluteValue(double x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    public static void main(String[] args) {
        printVariables(m_integer, m_decimal, m_string, m_boolean);
        plusOne(5);
        greaterNumber(5, 8);
        System.out.println("Result: " + absoluteValue(-100));
    }
}
