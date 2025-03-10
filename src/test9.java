

public class test9 {
    public static void main(String[] args){
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter the first number: ");
        double x = input.nextDouble();

        System.out.print("Enter the second number: ");
        double y = input.nextDouble();

        System.out.print("Enter the third number: ");
        double z = input.nextDouble();

        System.out.println((x<y && y<z) ? "Sorted" : "not sorted");

    }
}
