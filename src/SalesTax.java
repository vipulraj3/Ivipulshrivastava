import java.util.*;

public class SalesTax {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the purchase amount: ");
        double purchaseAmount = input.nextDouble();
        double tax = purchaseAmount * 0.06;
        System.out.print("Sales tax is: "+(tax*100)/100);
    }

}
