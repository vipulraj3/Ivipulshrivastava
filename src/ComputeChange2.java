import java.util.*;
public class ComputeChange2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount in double: ");
        double amount = input.nextDouble();

        int remainingAmount = (int)(amount * 100 );
        //Find the number of one dollar

        int numberOfOneDollars = remainingAmount/100;  // we find quotient
        remainingAmount = remainingAmount %100;  //we find the remainder

        int numberOfQuarters = remainingAmount/25;
        remainingAmount = remainingAmount % 25;

        int numberOfDimes = remainingAmount/10;
        remainingAmount = remainingAmount % 10;

        int numberOfNickels = remainingAmount/5;
        remainingAmount = remainingAmount%5;

        int numberOfPennies = remainingAmount;

        System.out.println("your amount: " +amount + " Consist of ");
        System.out.println(" " +numberOfOneDollars+" dollars");
        System.out.println(" " +numberOfQuarters+" quarters");
        System.out.println(" " +numberOfDimes+" dimes");
        System.out.println(" " +numberOfNickels+" nickels");
        System.out.println(" " +numberOfPennies+" pennies");

    }
}
