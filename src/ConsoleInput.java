import java.util.Scanner;
public class ConsoleInput
{
    public static void main(String[] args)

    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double radius = input.nextDouble();
        double area = radius * radius * 3.14;
        System.out.print("Area of the circle is: " + area);

    }
}
