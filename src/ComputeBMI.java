import java.util.*;

public class ComputeBMI {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the weight: ");
        double weight = input.nextDouble();

        System.out.print("Enter the height: ");
        double height = input.nextDouble();

        double BMI = weight/(height*height);

        System.out.println("BMI is: " + BMI);

        if (BMI < 18.5)
            System.out.println("Under weight");

        else if (BMI < 25)
            System.out.println("Normal");

        else if (BMI < 30)
            System.out.println("Overweight");

        else
            System.out.println("Obese");
    }
}