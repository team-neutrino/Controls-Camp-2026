package day1;

public class Exercise10 {
    public static void main(String[] args) {
        String letter = "a";

        letter = letter.toLowerCase();

        if (letter.length() != 1) {
            System.out.println("we only got the processing power for one letter sorry");
        } else if (letter == "a" || letter == "e" || letter == "i" || letter == "o" || letter == "u") {
            System.out.println("vowel");
        } else {
            System.out.println("consonant");
        }
    }
}