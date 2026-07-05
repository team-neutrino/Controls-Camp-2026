package day1;

public class Exercise11 {
    public static void main(String[] args) {
        String name = "John Neutrino";
        int age = 1;

        double price = 6.54;
        double tax = 0.07;

        if (age > 65) {
            price = price * 0.7;
        } else if (age < 13) {
            price = price * 1.5;
        }

        price = price + (price * tax);

        System.out.println("Hello " + name + ", your ticket price is $" + price);

        if (price > 10) {
            System.out.println("man you got scammed");
        } else {
            System.out.println("you got a good deal");
        }
    }
}