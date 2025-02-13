import java.util.Scanner;

public class multiplyDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer between 0 and 1000: ");
        int num = input.nextInt();

        if (num < 0 || num >= 1000) {
            System.out.println("Invalid input! Please enter a number between 0 and 1000.");
        } else {
            int product = 1;

            while (num > 0) {
                int digit = num % 10;
                if (digit != 0)
                {
                    product *= digit;
                }
                num /= 10;
            }

            System.out.println("Multiplication of all digits: " + product);
        }

        input.close();
    }
}