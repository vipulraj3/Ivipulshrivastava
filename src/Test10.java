import java.util.*;

public class Test10 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the age: ");
        int age = input.nextInt();

        System.out.print((age>=16) ? "Ticket Price is 20" : "Ticket price is 10");
    }
}
