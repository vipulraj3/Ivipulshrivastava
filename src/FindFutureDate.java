import java.util.*;

public class FindFutureDate {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"
        };
        System.out.println("Enter today's day: ");
        int a = input.nextInt();

        System.out.print("Enter the number of days since elapsed today: ");
        int b= input.nextInt();

        int futureDay = (a+b) % 7;

        System.out.println("Today is " + days[a] + " and the future day is "+ days[futureDay]);
    }
}
