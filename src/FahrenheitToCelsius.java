import java.util.*;
public class FahrenheitToCelsius {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the degree in Fahrenheit: ");
        double fahrenheit = input.nextDouble();
        double celsius = ( 5.0 / 9 ) * (fahrenheit-32);
        System.out.print("Celsius is: "+celsius);
    }
}
