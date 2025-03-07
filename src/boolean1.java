import java.util.*;

public class boolean1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double PI = 3.14f;
        System.out.print("Enter the radius of a circle: ");
        double radius = input.nextFloat();

        if (radius >= 0){
             double area = radius * radius * PI;
             System.out.println("The area of the circle of radius " + String.format("%.2f", radius) + " is " + String.format("%.2f", area));
        }
        else{
            System.out.println("Please enter valid input: ");
        }
        input.close();
    }
}
