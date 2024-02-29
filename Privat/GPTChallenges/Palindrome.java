import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a string: ");
        Palindrome.check(scn.nextLine(), 0);
        scn.close();
    }

    public static void check(String answer, int i) {
        if (answer.length() == 1) {
            System.out.println("The string is a palindrome.");
        } else {
            try {
                if (!(answer.charAt(i) == answer.charAt(answer.length()-1-i))) {
                    System.out.println("The string is not a palidnrome.");
                } else {
                    check(answer, i+1);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("The string is a palindrome.");
            }
        }
    }
}