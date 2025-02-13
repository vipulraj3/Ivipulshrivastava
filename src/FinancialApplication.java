import java.util.Scanner;

public class FinancialApplication {
    public static void main(String[] args) {

        final double MONTHLY_DEPOSIT = 100;
        final double ANNUAL_INTEREST_RATE = 3.75 / 100;
        final double MONTHLY_INTEREST_RATE = ANNUAL_INTEREST_RATE / 12;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of months: ");
        int months = scanner.nextInt();

        double balance = 0;

        for (int month = 1; month <= months; month++) {
            balance = (balance + MONTHLY_DEPOSIT) * (1 + MONTHLY_INTEREST_RATE);
            System.out.printf("Month %d: $%.2f\n", month, balance);
        }

        System.out.printf("\nTotal balance after %d months: $%.2f\n", months, balance);

        scanner.close();
    }
}