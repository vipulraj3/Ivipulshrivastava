import java.util.*;
public class test8 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value of b: ");
        int b = input.nextInt();


        System.out.print("Enter the value of a: ");
        int a = input.nextInt();


        System.out.print("Enter the value of c: ");
        int c = input.nextInt();

//        System.out.println("(  -b + ( Math.sqrt ( Math.pow ( b , 2 ) -4 * a * c )))/2*a");
        System.out.print((  -b + ( Math.sqrt ( Math.pow ( b , 2 ) -4 * a * c )))/2*a);
    }
}
