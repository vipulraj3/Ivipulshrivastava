import java.util.*;

public class ComputeAreaWithConstant
{
    public static void main(String[] args)
    {
        //final is used for declaring constant
        final double PI = 3.14159;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a radius: ");
        double radius = input.nextDouble();
        double area = radius * radius * PI;
        System.out.println("The area for the circle of radius "+ radius + " is :" + area);
    }
}
