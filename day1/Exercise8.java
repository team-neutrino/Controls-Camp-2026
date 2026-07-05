package day1;

public class Exercise8 {
    public static void main(String[] args) {
        int x = 5;
        int y = 8;
        int z = 3;

        if (x > y && x > z) {
            System.out.println("The largest number is " + x);
        } else if (y > x && y > z) {
            System.out.println("The largest number is " + y);
        } else {
            System.out.println("The largest number is " + z);
        }
    }
}