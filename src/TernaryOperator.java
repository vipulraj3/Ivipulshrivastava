import java.util.*;

public class TernaryOperator {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        // max = (num1 > num2) ? num1 : num2;
        System.out.print("Enter the number: ");
        int num = input.nextInt();
        System.out.println((num % 2 == 0) ? "num is even" :"num is odd");

    }

}