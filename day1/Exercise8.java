package day1;

public class Exercise8 {
    public static void main(String[] args) {
        int x = 5;
        int y = 8;
        int z = 3;

        if (x > y && x > z) {
            System.out.println("x is the largest number");
        } else if (y > x && y > z) {
            System.out.println("y is the largest number");
        } else {
            System.out.println("z is the largest number");
        }
    }
}