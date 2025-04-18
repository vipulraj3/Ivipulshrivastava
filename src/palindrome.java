import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int x = input.nextInt();
        int original = x;

        int sum = 0;
        while (x > 0) {
            int rev = x % 10; // % means remainder
            x = x / 10;       //   / means quotient
            sum = sum * 10 + rev;
        }

        if (sum == original) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }

        input.close();
    }
}