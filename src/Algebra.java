import java.util.*;

public class Algebra {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("The given quadratic equation is ax^2 + bc + c +0, ");
        System.out.println("Enter the value of a, b, c : ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double x = Math.pow(b, 2) - 4 * a * c;
        double r1 = (-b + Math.pow( x, 0.5))/2 *a;
        double r2 = (-b - Math.pow( x, 0.5))/2 *a;

        input.close();

        if(x > 0)
        {
            System.out.println("The equation has two roots " + r1 + " and " + r2);
        }
        else if( x == 0)
        {
            System.out.println("The equation has one root " + r1 );
        }
        else
        {
            System.out.println("The equation has no real roots " );
        }
    }
}
