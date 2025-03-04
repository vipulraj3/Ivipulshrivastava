import java.util.*;

public class intro3_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of a circle: ");
        int radius= input.nextInt();

        if(radius<0) {
            System.out.println("Incorrect input");
        }
        else{
            double area = radius*radius*3.14;
            System.out.print("Area is: "+ area);
        }
    }
}
