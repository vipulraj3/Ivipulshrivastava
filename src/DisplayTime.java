import java.util.*;
public class DisplayTime {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integer for second: ");
        int second = input.nextInt();
        int minutes = second/60;
        int remainingSeconds = second % 60;
        System.out.print(second + "Second is "+ minutes+ " minutes and "+ remainingSeconds+ " Seconds");
    }
}
