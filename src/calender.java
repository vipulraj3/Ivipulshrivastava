import java.util.*;

public class calender {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year  = input.nextInt();

        switch( year % 12 ) {
            case 0: System.out.println("january"); break;
            case 1: System.out.println("February"); break;
            case 2: System.out.println("March"); break;
            case 3: System.out.println("April"); break;
            case 4: System.out.println("May"); break;
            case 5: System.out.println("June"); break;
            case 6: System.out.println("July"); break;
            case 7: System.out.println("August"); break;
            case 8: System.out.println("September"); break;
            case 9: System.out.println("October"); break;
            case 10: System.out.println("November"); break;
            case 11: System.out.println("December"); break;
        }
    }
}